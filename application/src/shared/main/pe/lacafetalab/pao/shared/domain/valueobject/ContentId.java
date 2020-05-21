package pe.lacafetalab.pao.shared.domain.valueobject;

public class ContentId extends UUIDValueObject {
	private static final long serialVersionUID = 1L;

	protected ContentId() {}

	public ContentId(String uuid) {
		super(uuid);
	}
}
