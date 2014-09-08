/**
 * 
 */
package com.lives.api.helper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yyypasserby
 *
 */
@XmlRootElement
public class Error {
	private int errorType;
	private String errorMessage;
	public Error() {}
	
	public Error(int type, String msg) {
		this.errorType = type;
		this.errorMessage = msg;
	}
	/**
	 * @return the errorType
	 */
	public int getErrorType() {
		return errorType;
	}
	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
