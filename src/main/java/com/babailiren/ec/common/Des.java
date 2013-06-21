package com.babailiren.ec.common;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.log4j.Logger;

import com.sun.crypto.provider.SunJCE;

public class Des {
	private static Logger logger = Logger.getLogger(Des.class);

	private static final char[] hexchar = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private String algorithm = "DES";

	private byte[] defaultkey = { 85, 50, 23, 100, 5, 84, 119, 22 };

	private byte[] key = this.defaultkey;

	public Des() {
		Security.addProvider(new SunJCE());
	}

	/**
	 * 
	 * @param key
	 */
	public void setKey(byte[] key) {
		if ((key == null) || (key.length == 0)) {
			return;
		}
		this.key = new byte[key.length];
		for (int i = 0; i < key.length; ++i) {
			this.key[i] = key[i];
		}
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	public String encrypt(String password) {
		try {
			DESKeySpec deskeyspec = new DESKeySpec(this.key);
			SecretKeyFactory secretkeyfactory = SecretKeyFactory
					.getInstance(this.algorithm);
			SecretKey secretkey = secretkeyfactory.generateSecret(deskeyspec);
			Cipher cipher = Cipher.getInstance(this.algorithm);
			cipher.init(1, secretkey);
			byte[] arrayOfByte = cipher
					.doFinal(password.getBytes("UTF-8"));
			String str = byteToHex(arrayOfByte);
			return str;
		} catch (Exception localException) {
			logger.error("cannot encrypt (" + password + "):"
					+ localException.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	public String decrypt(String password) {
		if (password.length() % 16 != 0)
			return null;
		try {
			DESKeySpec localDESKeySpec = new DESKeySpec(this.key);
			SecretKeyFactory localSecretKeyFactory = SecretKeyFactory
					.getInstance(this.algorithm);
			SecretKey localSecretKey = localSecretKeyFactory
					.generateSecret(localDESKeySpec);
			Cipher localCipher = Cipher.getInstance(this.algorithm);
			localCipher.init(2, localSecretKey);
			byte[] arrayOfByte = localCipher.doFinal(hexToBs(password));
			String str = new String(arrayOfByte, "UTF-8");
			return str;
		} catch (Exception localException) {
			logger.error("cannot decrypt (" + password + "):"
					+ localException.getMessage());
		}
		return null;
	}

	private String byteToHex(byte[] paramArrayOfByte) {
		String str = "";
		for (int i = 0; i < paramArrayOfByte.length; ++i) {
			int j;
			if (paramArrayOfByte[i] >= 0)
				j = paramArrayOfByte[i];
			else
				j = paramArrayOfByte[i] + 256;
			str = str + "" + hexchar[(j / 16)] + hexchar[(j % 16)];
		}
		return str;
	}

	private byte[] hexToBs(String paramString) {
		byte[] arrayOfByte = new byte[paramString.length() / 2];
		for (int i = 0; i < paramString.length(); i += 2) {
			int j = paramString.charAt(i);
			int k = paramString.charAt(i + 1);
			int l = 0;
			int i1 = 0;
			if ((j >= 48) && (j <= 57))
				l = j - 48;
			else
				l = j - 65 + 10;
			if ((k >= 48) && (k <= 57))
				i1 = k - 48;
			else
				i1 = k - 65 + 10;
			int i2 = l * 16 + i1;
			if (i2 >= 128)
				;
			arrayOfByte[(i / 2)] = (byte) (i2 -= 256);
		}
		return arrayOfByte;
	}
}