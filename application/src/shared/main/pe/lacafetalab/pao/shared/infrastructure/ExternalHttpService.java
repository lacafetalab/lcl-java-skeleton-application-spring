package pe.lacafetalab.pao.shared.infrastructure;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpServiceImpl.ExternalResponse;

public interface ExternalHttpService {

	<T, S> S doPost(String url, String token, T body, Class<S> target);

	<S> S doGet(String url, String token, Class<S> target);

	<T, S> ExternalResponse<S> doRequest(String url, String httpMethod, String token, T body, Class<S> target);

	<T, S> ExternalResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, T body,
			Class<S> target);

	<S, T> ExternalResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, byte[] bytes,
			Class<S> target, Long timeout);

	<T> CompletableFuture<HttpResponse<String>> doRequestAsync(String url, String httpMethod, String token, T body);
}
