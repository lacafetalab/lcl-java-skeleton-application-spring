package pe.lacafetalab.pao.shared.utils;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import pe.lacafetalab.pao.shared.application.video.create.CreateVideoCommand;
import pe.lacafetalab.pao.shared.application.video.create.CreateVideoInput;
import pe.lacafetalab.pao.shared.application.video.create.CreateVideoResponse;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpService;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpServiceImpl;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpServiceImpl.ExternalResponse;

public class VimeoCreator {
	private static final Logger LOGGER = LoggerFactory.getLogger(VimeoCreator.class.getName());

	static ExternalHttpService httpService = new ExternalHttpServiceImpl(new Gson(),
			HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build());

	public static void main(String[] args) {
		String token = "4562ac9d6a3844a3e6a9ced527250dae";
		String url = "https://api.vimeo.com/me/videos";
		String httpMethod = "POST";

		try {

			CreateVideoCommand command = new CreateVideoCommand() {
				private static final long serialVersionUID = 1L;

				@Override
				public String getDescription() {
					return "new description";
				}

				@Override
				public String getName() {
					return "new video";
				}

				@Override
				public String getSize() {
					return "2606494";
				}

			};
			CreateVideoInput req = new CreateVideoInput(command);
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			headers.put("Authorization", String.format("Bearer %s", token));
			headers.put("Accept", "application/vnd.vimeo.*+json;version=3.4");

			ExternalResponse<CreateVideoResponse> response = httpService.doRequest(url, httpMethod, headers, req,
					CreateVideoResponse.class);
			LOGGER.info("response:" + new Gson().toJson(response));
			System.out.println("response:" + new Gson().toJson(response));

			System.out.println("upload link: [" + response.getResponse().getUpload().getLink() + "]");

		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}
