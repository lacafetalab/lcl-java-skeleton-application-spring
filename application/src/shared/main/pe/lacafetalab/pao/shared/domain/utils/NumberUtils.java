package pe.lacafetalab.pao.shared.domain.utils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class NumberUtils {

    public static int getFirstDigit(int number) {
        return Integer.valueOf(String.valueOf(String.valueOf(number).charAt(0)));
    }

    public static Double round(Double value, int numDecimals) {
        if (value == null) {
            return null;
        }
        if (numDecimals < 1) {
            throw new BadRequestException("type number",String.format("Value for numDecimals[%d] not valid", numDecimals));
        }
        double exp = Math.pow(10.0, numDecimals);
        return Math.round(value.doubleValue() * exp) / exp;
    }
}