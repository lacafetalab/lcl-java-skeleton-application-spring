package pe.lacafetalab.pao.shared.framework;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.lacafetalab.pao.shared.exceptions.LclException;
import pe.lacafetalab.pao.shared.model.EmptyObject;
import pe.lacafetalab.pao.shared.response.RestResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	static Logger logger = Logger.getLogger(RestExceptionHandler.class.getName());

	private final static int systemCodeStatus = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	private final static int appCodeError = 5;

	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<RestResponse> handleAll(Throwable ex, WebRequest request) {
		logger.log(Level.SEVERE, "Error", ex);
		ResponseEntity<RestResponse> response;
		if (LclException.class.isAssignableFrom(ex.getClass())) {
			LclException ugo2e = (LclException) ex;
			response = buildResponseEntity(new RestResponse(false, ugo2e.getStatusCode(), ugo2e.getCode(),
					ugo2e.getMessage(), ugo2e.getData()));
		} else {
			response = buildResponseEntity(
					new RestResponse(false, systemCodeStatus, appCodeError, ex.getMessage(), new EmptyObject()));
		}
		return response;
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		RestResponse restResponse = new RestResponse(false, HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.value(), ex.getMessage(), new Object());
		return buildResponseEntityObject(restResponse);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.log(Level.SEVERE, "Error", ex);
		ResponseEntity<Object> response;
		if (LclException.class.isAssignableFrom(ex.getClass())) {
			LclException ugo2e = (LclException) ex;
			response = buildResponseEntityObject(new RestResponse(false, ugo2e.getStatusCode(), ugo2e.getCode(),
					ugo2e.getMessage(), ugo2e.getData()));
		} else {
			response = buildResponseEntityObject(
					new RestResponse(false, status.ordinal(), status.ordinal(), ex.getMessage(), new EmptyObject()));
		}
		return response;
	}

	private ResponseEntity<RestResponse> buildResponseEntity(RestResponse apiError) {
		return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
	}

	private ResponseEntity<Object> buildResponseEntityObject(RestResponse apiError) {
		return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
	}
}