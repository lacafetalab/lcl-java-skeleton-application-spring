package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Optional;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class QuestionType extends EnumValueObject<QuestionType.Type> {

	public static BadRequestException INVALID_VALUE = new BadRequestException("Invalid question type",
			ErrorConstantsShared.BAD_QUESTION_TYPE);

	public QuestionType(Type value) {
		super(value);
		if (value == null) {
			throw INVALID_VALUE;
		}
	}

	public QuestionType(String value) {
		this(Type.valueFrom(value).orElseThrow(() -> {
			return INVALID_VALUE;
		}));
	}

	public static enum Type {
		ONEOPTION, MULTIOPTION, OPENANSWER, ASSOCIATED_OPTION;

		public static Optional<Type> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Type.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}

//		(1, 'ALTERNATIVAS') -> ONEOPTION, 
//		(2, 'EN BLANCO') -> OPENANSWER,
//		(3, 'ASOCIAR'),
//		(4, 'VERDADERO O FALSO') -> MULTIOPTION,
//		(5, 'PERSONALIZADA')

	}

}