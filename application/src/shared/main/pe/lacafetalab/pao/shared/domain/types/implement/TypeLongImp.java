package pe.lacafetalab.pao.shared.domain.types.implement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.domain.types.TypeLong;

final public class TypeLongImp extends TypeLong {
	TypeLongImp(Long value) {
		super(value);
	}

	public static TypeLong create(Long value) {
		return new TypeLongImp(value);
	}

	public static TypeLong create(String value, BadRequestException ex) {
		return create(value, ex, false);
	}

	public static TypeLong create(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value) && NumberUtils.isDigits(value)) {
			return new TypeLongImp(Long.valueOf(value));
		} else if (allowNull && value == null) {
			return new TypeLongImp(null);
		} else {
			throw ex;
		}
	}
}