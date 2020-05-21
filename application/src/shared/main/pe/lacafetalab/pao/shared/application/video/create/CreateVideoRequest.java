package pe.lacafetalab.pao.shared.application.video.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateVideoRequest {
	private String name;
	private String description;
	private CreateVideoRequest.Upload upload;
	private String content_rating = "safe";
	private CreateVideoRequest.Privacy privacy = new CreateVideoRequest.Privacy();

	public CreateVideoRequest(CreateVideoInput input) {
		this.name = input.getName().value();
		this.description = input.getDescription().value();
		this.upload = new CreateVideoRequest.Upload("tus", input.getSize().value());
	}

	@Getter
	@Setter
	@AllArgsConstructor
	private static class Upload {
		private String approach;
		private Long size;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	private static class Privacy {
		private Boolean add = false;
		private String comments = "nobody";
		private Boolean download = false;
		private String view = "unlisted";

	}
}