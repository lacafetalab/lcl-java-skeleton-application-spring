package pe.lacafetalab.pao.shared.domain.valueobject;

public class UnityId extends UUIDValueObject {
	private static final long serialVersionUID = 1L;

	protected UnityId() {}

	public UnityId(String uuid) {
		super(uuid);
	}
}
