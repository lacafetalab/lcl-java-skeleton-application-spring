package pe.lacafetalab.pao.shared.domain.valueobject;

public class CourseId extends UUIDValueObject {
	private static final long serialVersionUID = 1L;

	protected CourseId() {
	}

	public CourseId(String uuid) {
		super(uuid);
	}

}
