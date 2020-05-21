package pe.lacafetalab.pao.shared.application.bus.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Builder
public class GetCourseResponse implements Response {

	private String courseId;
	private String name;
	private String description;
	private String language;
	private String level;
	private Integer duration;
	private Integer numThemes;
	private List<String> contentTypes;
	private GetCourseResponse.Introduction introduction;
	private List<String> achievements;
	private List<GetCourseResponse.Unity> unities;
	private List<String> utpCourseCodes;

	@Getter
	@Builder
	public static class Unity {
		private String unityId;
		private String name;
		private String description;
		private Integer order;
		private Integer duration;
		private GetCourseResponse.Introduction introduction;
		private List<String> achievements;
	}

	@Getter
	@Builder
	public static class Introduction {
		private String videoUrl;
		private String imageUrl;
		private Integer width;
		private Integer height;

	}
}
