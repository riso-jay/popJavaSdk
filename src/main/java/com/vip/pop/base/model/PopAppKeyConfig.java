package com.vip.pop.base.model;

/**
 * pop的密钥及访问地址配置对象
 */
public class PopAppKeyConfig {
	private String appKey;
	private String appSecret;
	private String appUrl;

	public PopAppKeyConfig(){
		super();
	}

	public PopAppKeyConfig(String appKey, String appSecret, String appUrl) {
		super();
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.appUrl = appUrl;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
}
