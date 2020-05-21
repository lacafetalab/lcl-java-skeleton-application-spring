package pe.lacafetalab.pao.shared.exceptions;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class LoginException extends LclException {
	private static final long serialVersionUID = 1L;

	public LoginException(int code) {
		super(401, code, "Bad credentials", new Object());
	}

	public LoginException(String message, int code) {
		super(401, code, message, new Object());
	}

	public LoginException(String message) {
		super(401, ErrorConstantsShared.BAD_CREDENTIALS, message, new Object());
	}

	public LoginException() {
		this(ErrorConstantsShared.BAD_CREDENTIALS);
	}
}
