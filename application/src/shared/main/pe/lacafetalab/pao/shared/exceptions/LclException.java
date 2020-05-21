package pe.lacafetalab.pao.shared.exceptions;

import lombok.Getter;
import pe.lacafetalab.pao.shared.model.util.NumberUtils;

@Getter
public class LclException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private int statusCode;
	private int code;
	private String message;
	private Object data;
	
	public LclException(int statusCode, int code, String message, Object data) {
		this.statusCode = statusCode;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public LclException(int statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.code = NumberUtils.getFirstDigit(statusCode);
		this.message = message;
		this.data = data;
	}
}
