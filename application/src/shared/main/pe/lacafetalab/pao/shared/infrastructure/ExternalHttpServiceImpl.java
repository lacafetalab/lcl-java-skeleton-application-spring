package pe.lacafetalab.pao.shared.infrastructure;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.exceptions.LclException;

@Component
public class ExternalHttpServiceImpl implements ExternalHttpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalHttpServiceImpl.class.getName());

	public static final String HEADER_NAME = "Bearer";

	private static final String CHARSET = "UTF-8";

	private final Gson gson;
	private final HttpClient httpClient;

	public ExternalHttpServiceImpl(Gson gson, HttpClient httpClient) {
		this.httpClient = httpClient;
		this.gson = gson;
	}

	@Override
	public <T, S> S doPost(String url, String token, T body, Class<S> target) {
		return doRequest(url, "POST", token, body, target).getResponse();
	}

	@Override
	public <S> S doGet(String url, String token, Class<S> target) {
		return doRequest(url, "GET", token, null, target).getResponse();
	}

	@Override
	public <T, S> ExternalResponse<S> doRequest(String url, String httpMethod, String token, T body, Class<S> target) {
		Map<String, String> headers = token != null ? Map.of("Authorization", HEADER_NAME + " " + token) : Map.of();
		return doRequest(url, httpMethod, headers, body, target);
	}

	@Override
	public <T, S> ExternalResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, T body, Class<S> target) {
		LOGGER.info("http service request payload [{}]", body != null ? body.toString() : null);
		byte[] bytes = null;
		if (body != null) {
			try {
				String payload = gson.toJson(body);
				bytes = payload.getBytes(CHARSET);
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
				throw new BadRequestException(String.format("Error in external service [%s]", ex.getMessage()));
			}
		}
		return doRequest(url, httpMethod, headers, bytes, target, null);
	}

	@Override
	public <S, T> ExternalResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, byte[] bytes, Class<S> target, Long timeout) {
		try {
			HttpRequest.Builder HttpRequestBuilder = HttpRequest.newBuilder();

			HttpRequestBuilder.uri(URI.create(url));
			if (timeout != null) {
				HttpRequestBuilder.timeout(Duration.ofMillis(timeout));
			}
			if (headers != null) {
				headers.keySet().stream().forEach(k -> HttpRequestBuilder.header(k, headers.get(k)));
			}
			if (bytes != null) {
				HttpRequestBuilder.method(httpMethod, BodyPublishers.ofByteArray(bytes));
			}

			LOGGER.info("http service request url [{}]", url);
			long start = System.currentTimeMillis();

			HttpResponse<String> response = httpClient.send(HttpRequestBuilder.build(), BodyHandlers.ofString());

			LOGGER.info("http service response done in {} milliseconds  status code [{}] - headers [{}]", (System.currentTimeMillis() - start), response.statusCode(), gson.toJson(response.headers()));

			String content = response.body();

			LOGGER.info("http service response content [{}]", content);
			int responseCode = response.statusCode();

			if (responseCode >= 200 && responseCode < 300) {
				ExternalResponse<S> uresponse = new ExternalResponse<>();
				uresponse.setHeaders(getHeaders(response));
				if (target != null) {
					uresponse.setResponse(getResponse(content, target));
				}
				return uresponse;
			} else if (responseCode < 500) {
				LOGGER.trace("Bad request error {} - university response [{}]", responseCode, content);
				LclException error = getResponse(content, LclException.class);
				throw new LclException(responseCode, error.getCode(), error.getMessage(), error.getData());
			} else {
				LOGGER.trace("Error {} - auth response [{}]", responseCode, content);
				Object error;
				String message;
				try {
					error = target != null ? getResponse(content, Object.class) : content;
					message = "Error";
				} catch (Throwable e) {
					error = new Object();
					message = content;
				}
				throw new LclException(responseCode, message, error);
			}
		} catch (LclException ex) {
			throw ex;
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new BadRequestException(String.format("Error in external service [%s]", ex.getMessage()));
		}
	}

	@Override
	public <T> CompletableFuture<HttpResponse<String>> doRequestAsync(String url, String httpMethod, String token, T body) {

		try {
			HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();

			HttpRequest.Builder HttpRequestBuilder = HttpRequest.newBuilder();

			HttpRequestBuilder.uri(URI.create(url)).timeout(Duration.ofMillis(75000)).header("Content-Type", "application/json");

			String payload = null;
			if (body != null) {
				payload = gson.toJson(body);
				HttpRequestBuilder.method(httpMethod, BodyPublishers.ofByteArray(payload.getBytes(CHARSET)));
			}
			if (token != null) {
				HttpRequestBuilder.setHeader("Authorization", HEADER_NAME + " " + token);
			}
			LOGGER.info("http service request url [{}] - payload [{}]", url, payload);
			long start = System.currentTimeMillis();

			CompletableFuture<HttpResponse<String>> response = client.sendAsync(HttpRequestBuilder.build(), BodyHandlers.ofString());

			LOGGER.info("http service request async done in {} milliseconds", (System.currentTimeMillis() - start));

			return response;
		} catch (Throwable ex) {
			throw new BadRequestException(String.format("Error in external http service [%s]", ex.getMessage()), ex);
		}
	}

	private <T> Map<String, String> getHeaders(HttpResponse<T> response) {
		Map<String, String> headers = new HashMap<>();
		for (String name : response.headers().map().keySet()) {
			Optional<String> optValue = response.headers().firstValue(name);
			if (optValue.isPresent()) {
				headers.put(name, optValue.get());
			}
		}
		;
		return headers;
	}

	public <T> T getResponse(String source, Class<T> target) {
		return gson.fromJson(source, target);
	}

	public static class ExternalResponse<T> {

		private T response;
		private Map<String, String> headers;

		public T getResponse() {
			return response;
		}

		public void setResponse(T response) {
			this.response = response;
		}

		public Map<String, String> getHeaders() {
			return headers;
		}

		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}

	}
}
