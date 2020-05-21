package pe.lacafetalab.pao.shared.domain.valueobject;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@Getter
public class NumThemes extends IntegerValueObject {
	private static final long serialVersionUID = 1L;

	protected NumThemes() {
	}

	public NumThemes(Integer value) {
		super(value);
		if (value == null || value < 0) {
			throw new BadRequestException("The number of themes must be equal or greater than zero",
					ErrorConstantsShared.BAD_COURSE_NUMTHEMES);
		}
	}
}