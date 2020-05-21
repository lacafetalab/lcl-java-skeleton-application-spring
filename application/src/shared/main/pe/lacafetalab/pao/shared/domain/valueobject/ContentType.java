package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Optional;

import javax.persistence.MappedSuperclass;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@MappedSuperclass
public class ContentType extends EnumValueObject<ContentType.Type> {

	public static BadRequestException INVALID_VALUE = new BadRequestException("Invalid content type",
			ErrorConstantsShared.BAD_THEME_CONTENTTYPE);

	public ContentType(Type value) {
		super(value);
		if (value == null) {
			throw INVALID_VALUE;
		}
	}

	public ContentType(String str) {
		this(Type.valueFrom(str).orElseThrow(() -> INVALID_VALUE));
	}

	public static enum Type {
		MULTIMEDIA, TASK, EVALUATION;

		private Type() {
		}

		public static Optional<Type> valueFrom(String str) {
			try {
				return Optional.of(Type.valueOf(str));
			} catch (IllegalArgumentException | NullPointerException e) {
				return Optional.empty();
			}
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}
