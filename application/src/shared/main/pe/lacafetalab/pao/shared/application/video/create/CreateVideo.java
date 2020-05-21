package pe.lacafetalab.pao.shared.application.video.create;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.exceptions.LclException;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpService;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpServiceImpl.ExternalResponse;

@Service
public class CreateVideo {

	private ExternalHttpService externalHttpService;
	private String videosUrl;
	private String token;
	private Gson gson;

	public CreateVideo(ExternalHttpService externalHttpService, @Value("${vimeo.videos.me.url}") String videosUrl,
			@Value("${vimeo.token}") String token, Gson gson) {
		this.externalHttpService = externalHttpService;
		this.videosUrl = videosUrl;
		this.token = token;
		this.gson = gson;
	}

	public CreateVideoResponse execute(CreateVideoInput input) {
		try {
			CreateVideoRequest request = new CreateVideoRequest(input);
			ExternalResponse<CreateVideoResponse> response = externalHttpService.doRequest(videosUrl, "POST",
					buildHeaders(), request, CreateVideoResponse.class);
			return response.getResponse();
		} catch (LclException ex) {
			throw processException(ex);
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new LclException(500, ex.getMessage(), new Object());
		}
	}

	private LclException processException(LclException ex) {
		if (ex.getData() != null) {
			String jsonResponse = gson.toJson(ex.getData());
			try {
				ErrorVimeoResponse errorResponse = gson.fromJson(jsonResponse, ErrorVimeoResponse.class);
				String message = errorResponse.getDeveloper_message();
				int code = 4;
				if (Integer.valueOf(4101).equals(errorResponse.getError_code())) {
					message = "The video size is larger than permitted";
					code = ErrorConstantsShared.BAD_VIDEO_SIZE;
				}
				return new BadRequestException(message, code);
			} catch (JsonSyntaxException jse) {
				jse.printStackTrace();
			}
		}
		return ex;
	}

	private Map<String, String> buildHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", String.format("Bearer %s", token));
		headers.put("Accept", "application/vnd.vimeo.*+json;version=3.4");
		return headers;
	}

	@Getter
	static class ErrorVimeoResponse implements Serializable {
		private static final long serialVersionUID = 1L;
		private String error;
		private String link;
		private String developer_message;
		private Integer error_code;

	}

}
