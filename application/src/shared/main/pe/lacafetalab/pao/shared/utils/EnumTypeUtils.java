package pe.lacafetalab.pao.shared.utils;

import java.util.Optional;

public class EnumTypeUtils {

	public static <T extends Enum<T>> Optional<T> valueFrom(String str, Class<T> clazz) {
		try {
			return Optional.of(Enum.valueOf(clazz, str));
		} catch (IllegalArgumentException | NullPointerException e) {
			return Optional.empty();
		}
	}

	public static <T extends Enum<T>> boolean isValid(String str, Class<T> clazz) {
		return valueFrom(str, clazz).isPresent();
	}

}
