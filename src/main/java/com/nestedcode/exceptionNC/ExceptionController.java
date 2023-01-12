package com.nestedcode.exceptionNC;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nestedcode.responseNC.ResponseNc;

@RestController
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request, HttpServletRequest requestS ) throws Exception {
		ExceptionBean bean = new ExceptionBean(ex.getMessage(),HttpStatus.CONFLICT.getReasonPhrase().toString(),request.toString());
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		mainMessage.put("errormessage", bean);
		responseMap.setErrorMessage(mainMessage);
	return new ResponseEntity<Object>(responseMap,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionBean bean = new ExceptionBean(ex.getMessage(),HttpStatus.NOT_FOUND.toString(),request.toString());
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		mainMessage.put("errormessage", bean);
		responseMap.setErrorMessage(mainMessage);
	return new ResponseEntity<Object>(responseMap,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionBean bean = new ExceptionBean(ex.getMessage(),HttpStatus.NOT_FOUND.toString(),request.toString());
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		mainMessage.put("errormessage", bean);
		responseMap.setErrorMessage(mainMessage);
	return new ResponseEntity<Object>(responseMap,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleNotMethod(Exception ex, WebRequest request) throws Exception {
		ExceptionBean bean = new ExceptionBean(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),request.toString());
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		mainMessage.put("errormessage", bean);
		responseMap.setErrorMessage(mainMessage);
	return new ResponseEntity<Object>(responseMap,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
	
	@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
       // logger.info(ex.getClass().getName());
        //
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
        ExceptionBean bean = new ExceptionBean(ex.getMessage(),"false",request.toString());
		ResponseNc responseMap = new ResponseNc();
		Map<String, Object> mainMessage = new HashMap<>();
		mainMessage.put("errormessage", bean);
		responseMap.setErrorMessage(mainMessage);
        //final ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
        return new ResponseEntity<Object>(responseMap, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
