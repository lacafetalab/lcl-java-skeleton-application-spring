package pe.lacafetalab.pao.shared.domain.valueobject;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Getter
public class UnityOrder extends IntegerValueObject {
	private static final long serialVersionUID = 1L;

	protected UnityOrder() {
	}

	public UnityOrder(Integer value) {
		super(value);
		if (value == null || value <= 0) {
			throw new BadRequestException("The unity order must be greater than zero",
					ErrorConstantsShared.BAD_UNITY_ORDER);
		}
	}

	public UnityOrder(String value) {
		super(value, new BadRequestException("The unity order must be a integer number greater than zero",
				ErrorConstantsShared.BAD_UNITY_ORDER));
		if (value() <= 0) {
			throw new BadRequestException("The unity order must be a integer number greater than zero",
					ErrorConstantsShared.BAD_UNITY_ORDER);
		}
	}
}