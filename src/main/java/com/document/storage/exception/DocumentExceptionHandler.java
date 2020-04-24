/**
 * 
 */
package com.document.storage.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.document.storage.dto.ExceptionResponse;

/**
 * The exception handler that handles the exceptions that are occurred in
 * Document Service.
 *
 */
@ControllerAdvice
public class DocumentExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = DocumentException.class)
	public ResponseEntity<ExceptionResponse> handleDocumentxception(DocumentException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMsg());
		response.setSvcErrCode(ex.getSvcErrCode());
		response.setSvcErrMessage(ex.getSvcErrMessage());
		return ResponseEntity.status(ex.getHttpStatus()).body(response);
	}

}
