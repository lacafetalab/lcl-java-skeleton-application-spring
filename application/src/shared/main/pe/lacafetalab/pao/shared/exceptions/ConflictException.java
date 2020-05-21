package pe.lacafetalab.pao.shared.exceptions;

public class ConflictException extends LclException {
	private static final long serialVersionUID = 1L;

	public ConflictException(String message) {
		super(409, 4, message, new Object());
	}

	public ConflictException(String message, Object data) {
		super(409, 4, message, data);
	}

	public ConflictException(String message, Object data, int code) {
		super(409, code, message, data);
	}

	public ConflictException(String message, int code) {
		super(409, code, message, new Object());
	}
}