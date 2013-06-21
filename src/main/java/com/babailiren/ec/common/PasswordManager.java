package com.babailiren.ec.common;

import java.security.MessageDigest;

/**
 * 密码管理
 */
public class PasswordManager {
	private static Des des = new Des();

	private static byte[] key = { (byte) 0x15, (byte) 0x32, (byte) 0x47,
			(byte) 0x24, (byte) 0x69, (byte) 0x43, (byte) 0x65, (byte) 0x11 };

	static {
		// 设置密钥
		des.setKey(key);
	};

	// 为密码指定编码
	public static String encode(String password) {
		return des.encrypt(password);
	}

	// 为密码解编码
	public static String decode(String password) {
		return des.decrypt(password);
	}

	public static String md5(String name) {
		try {
			// 使用给定的 ISO-8859-1 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组
			byte[] sb = name.getBytes("UTF-8");
			// 此 MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法
			// 返回实现指定摘要算法的 MessageDigest 对象
			MessageDigest currentAlgorithm = MessageDigest.getInstance("MD5");
			// 使用指定的 byte 数组更新摘要
			currentAlgorithm.update(sb);
			// 通过执行诸如填充之类的最终操作完成哈希计算
			byte[] hash = currentAlgorithm.digest();
			String value = "";
			for (int i = 0; i < hash.length; i++) {
				int index = hash[i] & 0xFF;
				if (index < 16) {
					value += "0";
				}
				value += Integer.toString(index, 16).toUpperCase();
			}
			return value;
		} catch (Exception e) {
			return name;
		}
	}

	public static void main(String[] args) {
		// 2G$iCe
		System.out.println(new String(key));
		System.out.println(PasswordManager.decode("96C04C1A3CE50942F4E08B8E6C475CBE"));
	}
}
