package pe.lacafetalab.pao.shared.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.LoginException;

public class AuthenticatorUtils {
	
	public static final String AUTHORIZATION = "Authorization";
	private static final Pattern AUTH_HEADER_PATTERN = Pattern.compile("(\\s*)(B|b)(earer)(\\s+)(\\S+)");

	public static String findToken(String header) {
		Optional.ofNullable(StringUtils.defaultIfBlank(header, null)).orElseThrow(() -> new LoginException("Invalid credentials, check for token presence"));
		Matcher matcher = AUTH_HEADER_PATTERN.matcher(header);
		if (matcher.find()) {
			return matcher.group(5);
		} else {
			throw new LoginException("Invalid credentials, check for token presence");
		}
	}
	
	public static String findToken(HttpServletRequest request) {
		String header = request.getHeader(AUTHORIZATION);
		return findToken(header);
	}
}
