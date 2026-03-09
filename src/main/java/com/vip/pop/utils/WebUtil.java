package com.vip.pop.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;


public class WebUtil {
	private static final String CHARACTER_CODING = "UTF-8";
	private static final String CONTENT_TYPE_XML = "application/xml";
	private static final String CONTENT_TYPE_JSON = "application/json";

	/**
	 * 将Map转化为排序后的组字符串
	 *
	 * @param params 参数Map
	 * @return 排序后的字符串
	 */
	public static String convertToSortStr(Map<String, String> params) {
		if (params == null || params.isEmpty()) {
			return null;
		}

		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		StringBuilder query = new StringBuilder();

		for (String key : keys) {
			String value = params.get(key);
			if (isNotEmpty(key, value)) {
				query.append(key).append(value);
			}
		}

		return query.toString();
	}

	public static boolean isNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !StringUtils.isEmpty(value);
			}
		}
		return result;
	}

	public static String getQueryString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder query = new StringBuilder();
		boolean hasParam = false;
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		for (String key : keys) {
			String value = params.get(key);
			if (isNotEmpty(key, value)) {
				if (hasParam) {
					query.append("&");
				} else {
					hasParam = true;
				}
				query.append(key).append("=").append(URLEncoder.encode(value, CHARACTER_CODING));
			}
		}

		return query.toString();
	}

	/**
	 * 不能用BufferedReader的ReadLine和read来读，因为不方便处理换行和编码处理。只能一个一个读，才能保证正确性。
	 *
	 * @param is 输入流
	 * @return 字符串内容
	 * @throws Exception 读取异常
	 */
	public static String stream2Str(InputStream is) throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		int i;
		while ((i = is.read()) != -1) {
			stream.write(i);
		}
		is.close();
		return stream.toString();
	}

	public static ContentType getContentType(String format) {
		ContentType contentType = ContentType.create(CONTENT_TYPE_XML, CHARACTER_CODING);
		if ("JSON".equalsIgnoreCase(format)) {
			contentType = ContentType.create(CONTENT_TYPE_JSON, CHARACTER_CODING);
		}
		return contentType;
	}
}
