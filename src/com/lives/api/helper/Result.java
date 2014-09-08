package com.lives.api.helper;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	private String result;
	private Object object;
	
	public Result() {}
	public Result(String result, Object obj) {
		this.result = result;
		this.object = obj;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
}
