package pe.lacafetalab.pao.shared.domain.types.implement;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;


import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.domain.types.TypeBoolean;

final public class TypeBooleanImp extends TypeBoolean {
	TypeBooleanImp(Boolean value) {
		super(value);
	}

	public static TypeBoolean create(Boolean value) {
		return new TypeBooleanImp(value);
	}

	public static TypeBoolean create(String value, BadRequestException ex) {
		return create(value, ex, false);
	}

	public static TypeBoolean create(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value)
				&& (value.toLowerCase().equals("true") || value.toLowerCase().equals("false"))) {
			return create(BooleanUtils.toBooleanObject(value));
		} else if (allowNull && value == null) {
			return create(null);
		} else {
			throw ex;
		}
	}
}