package com.vip.pop;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.vip.pop.base.exception.PopSdkException;
import com.vip.pop.base.model.PopAppKeyConfig;
import com.vip.pop.base.model.PopBaseRsp;
import com.vip.pop.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vip.pop.beans.Configure;
import com.vip.pop.utils.Constants;
import com.vip.pop.utils.HmacUtils;
import com.vip.pop.utils.WebUtil;

/**
 * 基础服务类
 * 提供POP API的HTTP请求、签名和响应处理功能
 */
public class BaseService {

	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	private static final Properties configProps = new Properties();

	static {
		try {
			InputStream input = BaseService.class.getClassLoader().getResourceAsStream("config.properties");
			if (input != null) {
				configProps.load(input);
				input.close();
			}
		} catch (IOException e) {
			logger.error("Failed to load config.properties", e);
		}
	}

	private static final ThreadLocal<PopAppKeyConfig> POP_APP_KEY_CONFIG_THREADLOCAL = new ThreadLocal<>();
	private static final String APP_KEY = getConfig("pop.app.key");
	private static final String APP_SECRET = getConfig("pop.app.secret");
	private static final String APP_URL = getConfig("pop.app.url");

	/**
	 * 获取配置值，按以下优先级读取：
	 * 1. JVM 系统属性 (-Dpop.app.key=xxx)
	 * 2. 操作系统环境变量
	 * 3. 配置文件 (config.properties)
	 *
	 *
	 * @param key 配置键名
	 * @return 配置值
	 */
	private static String getConfig(String key) {
		// 1. 优先读取 JVM 系统属性 (-D参数)
		String sysValue = System.getProperty(key);
		if (sysValue != null && !sysValue.isEmpty()) {
			logger.debug("Config '{}' loaded from JVM system property", key);
			return sysValue;
		}

		// 2. 其次读取环境变量
		String envValue = System.getenv(key);
		if (envValue != null && !envValue.isEmpty()) {
			logger.debug("Config '{}' loaded from environment variable '{}'", key, key);
			return envValue;
		}

		// 3. 最后读取配置文件
		String propValue = configProps.getProperty(key);
		if (propValue != null) {
			logger.debug("Config '{}' loaded from config.properties", key);
		} else {
			logger.warn("Config '{}' not found in system property, environment or config.properties", key);
		}
		return propValue;
	}

	private static final String DATA_FORMAT = "json";

	private static HttpClient client;

	private static final int DEFAULT_TIME_OUT = 30000;

	/**
	 * 获取HTTP客户端实例（单例模式）
	 *
	 * @return HttpClient实例
	 */
	private static HttpClient getHttpClient() {
		if (client == null) {
			client = HttpClientBuilder.create().setDefaultRequestConfig(
							RequestConfig.custom().setConnectTimeout(DEFAULT_TIME_OUT)
									.setConnectionRequestTimeout(DEFAULT_TIME_OUT).setSocketTimeout(DEFAULT_TIME_OUT).build())
					.build();
		}
		return client;
	}

	/**
	 * 设置POP的密钥及访问地址
	 * @param appKey
	 * @param appSecret
	 * @param appUrl
	 */
	public PopAppKeyConfig setPopAppKeyConfig(String appKey, String appSecret, String appUrl) {

		if (StringUtils.isBlank(appKey)) {
			throw new PopSdkException("AppKey is null");
		}
		if (StringUtils.isBlank(appSecret)) {
			throw new PopSdkException("AppSecret is null");
		}
		if (StringUtils.isBlank(appUrl)) {
			throw new PopSdkException("AppUrl is null");
		}
		POP_APP_KEY_CONFIG_THREADLOCAL.set(new PopAppKeyConfig(appKey, appSecret, appUrl));
		return POP_APP_KEY_CONFIG_THREADLOCAL.get();
	}

	/**
	 * 执行API请求
	 *
	 * @param serviceName 服务名称
	 * @param method 方法名称
	 * @param businessParams 业务参数JSON字符串
	 * @return API响应结果
	 * @throws Exception 请求异常
	 */
	public String doRequest(String serviceName, String method, String businessParams) throws Exception {
		HttpPost post = null;
		try {
			//获取当前会话中的配置
			PopAppKeyConfig popAppKeyConfig = POP_APP_KEY_CONFIG_THREADLOCAL.get();
			//如果没有设置,就使用默认的
			if (popAppKeyConfig == null) {
				popAppKeyConfig = setPopAppKeyConfig(APP_KEY, APP_SECRET, APP_URL);
				if (popAppKeyConfig == null) {
					throw new PopSdkException("请先设置密钥及访问地址");
				}
			}

			if (logger.isDebugEnabled()) {
				logger.debug("Current timestamp: {}", System.currentTimeMillis() / 1000);
			}
			Configure configure = new Configure();
			configure.setAppKey(popAppKeyConfig.getAppKey()).setAppSecrect(popAppKeyConfig.getAppSecret())
					.setFormat(DATA_FORMAT).setService(serviceName).setMethod(method)  //获取订单轨迹接口
					.setTimestamp(String.valueOf(System.currentTimeMillis() / 1000)).setVersion("1.0.0")//版本号
					.setUrl(popAppKeyConfig.getAppUrl())//测试环境访问URL
					.setBusinessData(businessParams);//业务参数

			Map<String, String> sysParams = doSign(configure);

			if (logger.isDebugEnabled()) {
				logger.debug("Request URL: {}", configure.getUrl() + "?" + WebUtil.getQueryString(sysParams));
				logger.debug("Business parameters: {}", businessParams);
			}
			post = new HttpPost(configure.getUrl() + "?" + WebUtil.getQueryString(sysParams));
			post.setEntity(new StringEntity(businessParams, WebUtil.getContentType(configure.getFormat())));

			//响应结果
			HttpResponse res = getHttpClient().execute(post);
			String resStr = doResponse(res);
			if (logger.isDebugEnabled()) {
				logger.debug("Response: {}", resStr);
			}
			return resStr;
		} catch (Exception e) {
			logger.error("Error occurred while executing request", e);
			throw e; // 重新抛出异常以保持原有行为
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
	}

	/**
	 * 签名处理
	 *
	 * @param configure 配置对象
	 * @return 包含签名的参数Map
	 * @throws Exception 签名异常
	 */
	private Map<String, String> doSign(Configure configure) throws Exception {
		Map<String, String> params = getByConfigure(configure);

		if (logger.isDebugEnabled()) {
			logger.debug("parameters: {}", params);
		}

		String data = WebUtil.convertToSortStr(params) + configure.getBusinessData();

		if (logger.isDebugEnabled()) {
			logger.debug("Signature data: {}", data);
		}

		String sign = HmacUtils.byte2hex(HmacUtils.encryptHMAC(data, configure.getAppSecrect()));
		logger.info("Signature result: {}", sign);
		params.put("sign", sign);
		return params;
	}

	/**
	 * 处理HTTP响应
	 *
	 * @param res HTTP响应对象
	 * @return 响应内容字符串
	 */
	private String doResponse(HttpResponse res) {
		int code = res.getStatusLine().getStatusCode();
		if (code == 200) {
			HttpEntity entity = res.getEntity();
			if (entity.getContentLength() == 0) {
				logger.warn("Business interface returned empty response");
				throw new PopSdkException("business-Interface no response data!");
			}
			try {
				String resStr = WebUtil.stream2Str(entity.getContent());
				PopBaseRsp popBaseRsp = JsonUtils.toObj(resStr, PopBaseRsp.class);
				if ("0".equals(popBaseRsp.getReturnCode())) {
					return JsonUtils.toStr(popBaseRsp.getResult());
				} else {
					throw new PopSdkException(popBaseRsp.getReturnMessage());
				}
			} catch (Exception ex) {
				logger.warn(ex.getMessage(), ex);
				throw new PopSdkException(ex.getMessage());
			}
		} else {
			logger.error("Request pop interface failed with status code: {}", code);
			throw new PopSdkException("Request pop interface Exception【" + code + "】！");
		}
	}

	/**
	 * 准备参数
	 *
	 * @param configure 配置对象
	 * @return 参数Map
	 */
	private Map<String, String> getByConfigure(Configure configure) {
		Map<String, String> params = new HashMap<>();
		params.put(Constants.SERVICE_NAME, configure.getService());//addressService-getChannelOrderList
		params.put(Constants.METHOD_NAME, configure.getMethod());
		params.put(Constants.TIMESTAMP, configure.getTimestamp());
		params.put(Constants.FORMAT, configure.getFormat());
		params.put(Constants.APP_KEY, configure.getAppKey());
		params.put(Constants.VERSION, configure.getVersion());

		return params;
	}
}
