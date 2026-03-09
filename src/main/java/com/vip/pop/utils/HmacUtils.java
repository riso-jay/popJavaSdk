package com.vip.pop.utils;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * hmac公用方法类
 * 
 * @author weihui.tang
 * 
 */
public class HmacUtils {
	public static final String CHARSET_UTF8 = "UTF-8";

	public static final String KEY_MAC = "HmacMD5";

	private static final String HEXSTR = "0123456789ABCDEF";

	private static String[] binaryArray = { "0000", "0001", "0010", "0011",
			"0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
			"1100", "1101", "1110", "1111" };

	

	/**
	 * hmac-md5签名
	 * 
	 * @param data 待签名数据
	 * @param secret 密钥
	 * @return 签名后的字节数组
	 * @throws IOException IO异常
	 * @throws NoSuchAlgorithmException 算法不存在异常
	 * @throws InvalidKeyException 无效密钥异常
	 */
	public static byte[] encryptHMAC(String data, String secret)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		byte[] bytes = null;
		SecretKey secretKey = new SecretKeySpec(secret.getBytes(CHARSET_UTF8),
				KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		bytes = mac.doFinal(data.getBytes(CHARSET_UTF8));
		return bytes;
	}

	/**
	 * 将byte转化为十六进制字符串
	 * 
	 * @param bytes 字节数组
	 * @return 十六进制字符串
	 */
	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sign.append(String.valueOf(HEXSTR.charAt((bytes[i] & 0xF0) >> 4))); // 字节高4位
			sign.append(String.valueOf(HEXSTR.charAt(bytes[i] & 0x0F))); // 字节低4位
		}
		return sign.toString().toUpperCase();
	}

	/**
	 * 将十六进制转换为字节数组
	 *
	 * @param hexString 十六进制字符串
	 * @return 字节数组
	 */
	public static byte[] hexToBinary(String hexString) {
		// hexString的长度对2取整，作为bytes的长度
		int len = hexString.length() / 2;
		byte[] bytes = new byte[len];
		for (int i = 0; i < len; i++) {
			// 右移四位得到高位
			byte high = (byte) ((HEXSTR.indexOf(hexString.charAt(2 * i))) << 4);// 字节高四位
			byte low = (byte) HEXSTR.indexOf(hexString.charAt(2 * i + 1));// 字节低四位
			bytes[i] = (byte) (high | low);// 高地位做或运算
		}
		return bytes;
	}

	/**
	 *
	 * @param bArray 待转换的字节数组
	 * @return 转换为二进制字符串
	 */
	public static String bytes2BinaryStr(byte[] bArray) {
		StringBuilder outStr = new StringBuilder();
		for (byte b : bArray) {
			// 高四位
			int pos = (b & 0xF0) >> 4;
			outStr.append(binaryArray[pos]);
			// 低四位
			pos = b & 0x0F;
			outStr.append(binaryArray[pos]);
		}
		return outStr.toString();

	}
}
