package pe.lacafetalab.pao.shared.utils;

import pe.lacafetalab.pao.shared.domain.UserIdentification;

public interface EncriptService {

	UserIdentification decript(String token);

	String generate();

	String computeSHA1256(String password);

	byte[] calcHmacSha256(byte[] secretKey, byte[] message);

}
