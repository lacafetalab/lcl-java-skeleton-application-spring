package pe.lacafetalab.pao.shared.domain.types.implement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.domain.types.TypeInteger;

final public class TypeIntegerImp extends TypeInteger {
    TypeIntegerImp(Integer value) {
        super(value);
    }

    public static TypeInteger create(Integer value) {
        return new TypeIntegerImp(value);
    }
    
    public static TypeInteger create(String value, BadRequestException ex) {
		return create(value, ex, false);
	}

	public static TypeInteger create(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value) && NumberUtils.isDigits(value)) {
			return new TypeIntegerImp(Integer.valueOf(value));
		} else if (allowNull && value == null) {
			return new TypeIntegerImp(null);
		} else {
			throw ex;
		}
	}
}