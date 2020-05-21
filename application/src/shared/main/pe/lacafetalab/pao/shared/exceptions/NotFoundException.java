package pe.lacafetalab.pao.shared.exceptions;

public class NotFoundException extends LclException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(404, 4, message, new Object());
	}

	public NotFoundException(String message, Object data) {
		super(404, 4, message, data);
	}

	public NotFoundException(String message, Object data, int code) {
		super(404, code, message, data);
	}

	public NotFoundException(String message, int code) {
		super(404, code, message, new Object());
	}
}