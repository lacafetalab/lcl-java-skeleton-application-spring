package pe.lacafetalab.pao.shared.model.util;

public class NumberUtils {

	public static int getFirstDigit(int number) {
		return Integer.valueOf(String.valueOf(String.valueOf(number).charAt(0)));
	}
	
}
