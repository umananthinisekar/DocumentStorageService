/**
 * 
 */
package com.document.storage.exception;

import org.springframework.http.HttpStatus;

/**
 * The exception class that handles all the exceptions occurs in Document
 * Service.
 *
 */
public class DocumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5010913862245785222L;
	private final HttpStatus httpStatus;
	private final String msg;
	private final String svcErrCode;
	private final String svcErrMessage;


	public DocumentException(String errCode, String svcErrMessage, String msg, HttpStatus httpStatus) {
		this.svcErrCode = errCode;
		this.svcErrMessage = svcErrMessage;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}


	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @return the svcErrCode
	 */
	public String getSvcErrCode() {
		return svcErrCode;
	}


	/**
	 * @return the svcErrMessage
	 */
	public String getSvcErrMessage() {
		return svcErrMessage;
	}


}
