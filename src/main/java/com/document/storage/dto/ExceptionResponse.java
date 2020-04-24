/**
 * 
 */
package com.document.storage.dto;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516992383328613128L;

	private String message;
	private String svcErrCode;
	private String svcErrMessage;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the svcErrCode
	 */
	public String getSvcErrCode() {
		return svcErrCode;
	}

	/**
	 * @param svcErrCode the svcErrCode to set
	 */
	public void setSvcErrCode(String svcErrCode) {
		this.svcErrCode = svcErrCode;
	}

	/**
	 * @return the svcErrMessage
	 */
	public String getSvcErrMessage() {
		return svcErrMessage;
	}

	/**
	 * @param svcErrMessage the svcErrMessage to set
	 */
	public void setSvcErrMessage(String svcErrMessage) {
		this.svcErrMessage = svcErrMessage;
	}

}
