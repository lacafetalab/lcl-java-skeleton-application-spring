package pe.lacafetalab.pao.shared.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class VimeoUploader {
	private static final Logger LOGGER = LoggerFactory.getLogger(VimeoUploader.class.getName());

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("VimeoUploader.main()");

		String fullToken = "ac04a77125465b33d96cfc7dee55e57b";

//		String token = "4562ac9d6a3844a3e6a9ced527250dae";
		String token = "03f72098b147dd25c4637719fe73110b";
//		String url = "https://files.tus.vimeo.com/files/vimeo-prod-src-tus-us/51c5e0181cf59ae59f339cc7d85e4ff3";
//		String filePath = "/Users/walter/Documents/gource.mp4";

//		String url = "https://files.tus.vimeo.com/files/vimeo-prod-src-tus-us/d0ac7905862ad4600b5ec6576d0d2137";
//		String url = "https://files.tus.vimeo.com/files/vimeo-prod-src-tus-us/12069c3cd67f5fe20a63fe4c3027ca3c";
		String url = "https://files.tus.vimeo.com/files/vimeo-prod-src-tus-us/a63182b72e6f7f399b89cfc4b8a5e36f";

		String filePath = "/Users/walter/Desktop/video.test.mov";
		String httpMethod = "PATCH";

		try {
			HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL)
					.build();
			HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder();

			httpRequestBuilder.uri(URI.create(url));
			httpRequestBuilder.header("Content-Type", "application/offset+octet-stream");
			httpRequestBuilder.header("Authorization", "Bearer " + token);
			httpRequestBuilder.header("Tus-Resumable", "1.0.0");
			httpRequestBuilder.header("Upload-Offset", "0");
			httpRequestBuilder.header("Accept", "application/vnd.vimeo.*+json;version=3.4");

			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			httpRequestBuilder.method(httpMethod, BodyPublishers.ofByteArray(fis.readAllBytes()));
			fis.close();

			long start = System.currentTimeMillis();

			HttpResponse<String> response = client.send(httpRequestBuilder.build(), BodyHandlers.ofString());

			LOGGER.info("http service response done in {} milliseconds  status code [{}] - headers [{}]",
					(System.currentTimeMillis() - start), response.statusCode(), new Gson().toJson(response.headers()));

			String content = response.body();
			LOGGER.info("http service response content [{}]", content);
			int responseCode = response.statusCode();
			if (responseCode >= 200 && responseCode < 300) {

			} else {
				System.err.println("responseCode: " + responseCode);
				System.err.println("content: " + content);

			}
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}
