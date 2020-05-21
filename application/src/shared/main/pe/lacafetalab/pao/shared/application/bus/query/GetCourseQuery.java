package pe.lacafetalab.pao.shared.application.bus.query;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;

@Getter
public class GetCourseQuery implements Query {
	private String courseId;

	public GetCourseQuery(String courseId) {
		super();
		this.courseId = courseId;
	}
}