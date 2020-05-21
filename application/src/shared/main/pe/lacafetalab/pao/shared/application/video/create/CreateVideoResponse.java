package pe.lacafetalab.pao.shared.application.video.create;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class CreateVideoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String uri;
	private String name;
	private String description;
	private String link;
	private CreateVideoResponse.Upload upload;

	protected CreateVideoResponse() {
	}

	@Getter
	public static class Upload {
		private String status;
		private String approach;

		@SerializedName("upload_link")
		private String link;
	}
}