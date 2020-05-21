package pe.lacafetalab.pao.shared.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.UserIdentification;
import pe.lacafetalab.pao.shared.domain.valueobject.Role;
import pe.lacafetalab.pao.shared.domain.valueobject.UserId;
import pe.lacafetalab.pao.shared.exceptions.LclException;
import pe.lacafetalab.pao.shared.exceptions.LoginException;

public class JsonWebTokenEncriptService implements EncriptService {

	private static Logger logger = Logger.getLogger(JsonWebTokenEncriptService.class.getName());

	private Algorithm algorithm = null;
	private JWTVerifier jwtVerifier = null;

	public JsonWebTokenEncriptService(String secret) {
		if (algorithm == null) {
			logger.info("Initializing Encript Algorithm");
			try {
				algorithm = Algorithm.HMAC512(secret);
			} catch (IllegalArgumentException | UnsupportedEncodingException e) {
				throw new LclException(500, "Can not create the jwt algorithm", new Object());
			}
		}
		if (jwtVerifier == null) {
			logger.info("Initializing Encript Verifier");
			jwtVerifier = JWT.require(algorithm).build();
		}
	}

	@Override
	public UserIdentification decript(String token) {
		try {
			DecodedJWT decoded = jwtVerifier.verify(token);

			UserIdentification response = UserIdentification.builder().userId(new UserId(decoded.getSubject())).role(new Role(decoded.getClaim("role").asString())).build();

			logger.info("LoginResponse: " + new Gson().toJson(response));
			return response;

		} catch (TokenExpiredException tee) {
			throw new LoginException(ErrorConstantsShared.TOKEN_EXPIRED);
		} catch (JWTVerificationException e) {
			throw new LoginException();
		}
	}

	@Override
	public String generate() {
		String raw = UUID.randomUUID().toString();
		while (raw.contains("-")) {
			raw = raw.replaceFirst("-", RandomStringUtils.randomAlphabetic(2));
		}
		return SecurityEncription.INSTANCE.digest(String.format("%s%s", raw, String.format("%x", System.currentTimeMillis())));
	}

	@Override
	public String computeSHA1256(String password) {
		if (StringUtils.isBlank(password)) {
			return null;
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	@Override
	public byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
		try {
			Mac mac = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
			mac.init(secretKeySpec);
			byte[] hmacSha256 = mac.doFinal(message);
			return hmacSha256;
		} catch (Exception e) {
			throw new RuntimeException("Failed to calculate hmac-sha256", e);
		}
	}
}
