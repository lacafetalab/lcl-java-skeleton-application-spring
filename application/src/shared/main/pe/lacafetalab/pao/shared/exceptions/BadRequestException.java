package pe.lacafetalab.pao.shared.exceptions;

public class BadRequestException extends LclException {
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String message) {
		super(400, 4, message, new Object());
	}

	public BadRequestException(String message, Object data) {
		super(400, 4, message, data);
	}
	
	public BadRequestException(String message, Object data, int code) {
		super(400, code, message, data);
	}

	public BadRequestException(String message, int code) {
		super(400, code, message, new Object());
	}
}