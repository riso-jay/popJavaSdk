package com.vip.pop.base.model;

public class PopBaseRsp {
	
	private String returnCode;
	
	private String returnMessage;

	private Object result;

	public PopBaseRsp(){
		super();
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnCode() {
		return this.returnCode;
	}
	
	public String getReturnMessage() {
		return returnMessage;
	}
	
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getResult() {
		return this.result;
	}

}