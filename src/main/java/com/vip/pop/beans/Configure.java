package com.vip.pop.beans;

public class Configure {
	/**
	 * 请求响应格式
	 */
	private String format;
	/**
	 * AppKey
	 */
	private String appKey;
	/**
	 * 服务名
	 */
	private String service;
	/**
	 * 方法名称
	 */
	private String method;
	/**
	 * 时间戳（误差不能相差十分钟）
	 */
	private String timestamp;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * AppSecrect
	 */
	private String appSecrect;
	/**
	 * 请求URL
	 */
	private String url;
	/**
	 * 业务参数
	 */
	private String businessData;

	public String getFormat() {
		return format;
	}

	public Configure setFormat(String format) {
		this.format = format;
		return this;
	}

	public String getAppKey() {
		return appKey;
	}

	public Configure setAppKey(String appKey) {
		this.appKey = appKey;
		return this;
	}
	

	public String getService() {
		return service;
	}

	public Configure setService(String service) {
		this.service = service;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public Configure setMethod(String method) {
		this.method = method;
		return this;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Configure setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public Configure setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getAppSecrect() {
		return appSecrect;
	}

	public Configure setAppSecrect(String appSecrect) {
		this.appSecrect = appSecrect;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Configure setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getBusinessData() {
		return businessData;
	}

	public Configure setBusinessData(String businessData) {
		this.businessData = businessData;
		return this;
	}
	
	
}
