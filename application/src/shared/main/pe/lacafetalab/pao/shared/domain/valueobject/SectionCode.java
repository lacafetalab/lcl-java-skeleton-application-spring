package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class SectionCode extends StringValueObject {
	private static final long serialVersionUID = 1L;

	public SectionCode(String value) {
		super(value);
		verifyIsNotBlank("section code", ErrorConstantsShared.BAD_SECTION_CODE);
	}

	public SectionCode() {
		super();
	}
}
