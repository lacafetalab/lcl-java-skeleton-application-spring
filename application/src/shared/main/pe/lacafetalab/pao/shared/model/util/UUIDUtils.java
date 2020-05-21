package pe.lacafetalab.pao.shared.model.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class UUIDUtils {

	public static UUID generateUUID(String str) {
		if (StringUtils.isBlank(str)) {
			throw new BadRequestException("String to generate uuid can not be empty");
		}
		try {
			return UUID.nameUUIDFromBytes(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new BadRequestException("Invalid String to generate uuid");
		}
	}
}
