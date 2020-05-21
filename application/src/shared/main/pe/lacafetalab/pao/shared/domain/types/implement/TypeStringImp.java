package pe.lacafetalab.pao.shared.domain.types.implement;

import pe.lacafetalab.pao.shared.domain.types.TypeString;

final public class TypeStringImp extends TypeString {
	TypeStringImp(String value) {
		super(value);
	}

	public static TypeString create(String value) {
		return new TypeStringImp(value);
	}
}
