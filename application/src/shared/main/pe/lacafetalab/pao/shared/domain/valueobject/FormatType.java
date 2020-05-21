package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Comparator;
import java.util.Optional;

import javax.persistence.MappedSuperclass;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

@MappedSuperclass
public class FormatType extends EnumValueObject<FormatType.Type> {

	private static BadRequestException INVALID_VALUE = new BadRequestException("Invalid course format type",
			ErrorConstantsShared.BAD_COURSE_CONTENTTYPE);

	public FormatType(Type value) {
		super(value);
		if (value == null) {
			throw INVALID_VALUE;
		}
	}

	public FormatType(String str) {
		this(Type.valueFrom(str).orElseThrow(() -> INVALID_VALUE));
	}

	public static class CourseFormatTypeComparator implements Comparator<FormatType> {
		@Override
		public int compare(FormatType o1, FormatType o2) {
			return (o1 != null && o2 != null) ? Integer.compare(o1.value().getOrder(), o2.value().getOrder()) : 0;
		}
	}

	public static enum Type {
		VIDEO(1), AUDIO(2), PDF(3);

		private int order;

		private Type(int order) {
			this.order = order;
		}

		public int getOrder() {
			return order;
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

		public static class FormatTypeComparator implements Comparator<Type> {
			@Override
			public int compare(Type o1, Type o2) {
				return (o1 != null && o2 != null) ? Integer.compare(o1.getOrder(), o2.getOrder()) : 0;
			}
		}
	}
}
