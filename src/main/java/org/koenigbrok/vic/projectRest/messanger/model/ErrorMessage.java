package org.koenigbrok.vic.projectRest.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String message;
	private int errorCode;
	private String doc;
	
	
	public ErrorMessage() {
	
	}

	

	public ErrorMessage(String message, int errorCode, String doc) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.doc = doc;
	}



	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getDoc() {
		return doc;
	}


	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	
	
}
