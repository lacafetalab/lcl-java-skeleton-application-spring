package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Optional;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class EvaluationType extends EnumValueObject<EvaluationType.Type> {

	public static BadRequestException INVALID_VALUE = new BadRequestException("Invalid evaluation type",
			ErrorConstantsShared.BAD_EVALUATION_TYPE);

	public EvaluationType(Type value) {
		super(value);
		if (value == null) {
			throw INVALID_VALUE;
		}
	}

	public EvaluationType(String value) {
		this(Type.valueFrom(value).orElseThrow(() -> INVALID_VALUE));
	}

	public static enum Type {

		PC1, PC2, PC3, PC4, PC5, PC6, EXPA, EXFI;

		public static Optional<Type> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Type.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}