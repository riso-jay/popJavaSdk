package com.vip.pop.utils;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * JSON工具类
 * 用于处理JSON字符串与Java对象之间的转换
 * 注意：这是一个简化的JSON解析器，仅用于处理WOP API返回的标准格式
 */
public class JsonUtils {
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

	public static <T> List<T> toList(String jsonStr, Class<T> clazz){
		return JSON.parseArray(jsonStr, clazz);
	}

	/**
	 * jsonStrng转Object
	 */
	public static <T> T toObj(String jsonStr, Class<T> clazz) {
		return JSON.parseObject(jsonStr, clazz);
	}

	/**
	 * Object转jsonString
	 */
	public static String toStr(Object obj) {
		return JSON.toJSONString(obj);
	}


}