package pe.lacafetalab.pao.shared.domain.types.implement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.domain.types.TypeDouble;

final public class TypeDoubleImp extends TypeDouble {

	public TypeDoubleImp(Double value) {
		super(value);
	}

	public static TypeDouble empty() {
		return new TypeDoubleImp(null);
	}

	public static TypeDouble create(Double value) {
		return new TypeDoubleImp(value);
	}

	public static TypeDouble create(String value, BadRequestException ex) {
		return create(value, ex, false);
	}

	public static TypeDouble create(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value) && NumberUtils.isCreatable(value)) {
			return new TypeDoubleImp(Double.valueOf(value));
		} else if (allowNull && value == null) {
			return new TypeDoubleImp(null);
		} else {
			throw ex;
		}
	}
}
