package pe.lacafetalab.pao.shared.model.util;

public class ClassUtils {

	@SuppressWarnings("rawtypes")
	public static Class getClassForName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
}
