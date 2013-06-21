package com.babailiren.ec.web.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Configuration {
	private static String imageDomain;
	private static String imageSavepath;
	private static Integer imagePrefix;
	private static Integer imageMaxWidth;
	private static boolean imageSaveThumb;
	private static String luceneIndexPath;
	private static String ZFB_PAY_URL;
	private static String ZFB_SERVICE; 
	private static String ZFB_SIGN_TYPE; 
	private static String ZFB_INPUT_CHARSET; 
	private static String ZFB_PARTNER;
	private static String ZFB_KEY;
	private static String ZFB_SHOW_URL;
	private static String ZFB_PAYMENT_TYPE;
	private static String ZFB_EMAIL;
	private static String ZFB_NOTIFY_URL;
	private static String ZFB_RETURN_URL;
	
	public static void init() {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("config.properties");
			imageDomain = (String)properties.get("image.domain");
			imageSavepath = (String)properties.get("image.savepath");
			imagePrefix = NumberUtils.toInt((String)properties.get("image.prefix"),2);
			imageMaxWidth = NumberUtils.toInt((String)properties.get("image.maxwidth"),1000);
			imageSaveThumb = Boolean.valueOf((String)properties.get("image.savethumb"));
			luceneIndexPath = (String)properties.get("lucene.indexpath");
			
			// 支付宝
			ZFB_PAY_URL = (String)properties.get("zfb_pay_url");
			ZFB_SERVICE = (String)properties.get("zfb_service");
			ZFB_SIGN_TYPE = (String)properties.get("zfb_sign_type");
			ZFB_INPUT_CHARSET = (String)properties.get("zfb_input_charset");
			ZFB_PARTNER = (String)properties.get("zfb_partner");
			ZFB_KEY = (String)properties.get("zfb_key");
			ZFB_SHOW_URL = (String)properties.get("zfb_show_url");
			ZFB_PAYMENT_TYPE = (String)properties.getProperty("zfb_payment_type");
			ZFB_EMAIL = (String)properties.getProperty("zfb_email");
			ZFB_NOTIFY_URL = (String)properties.getProperty("zfb_notify_url");
			ZFB_RETURN_URL = (String)properties.getProperty("zfb__url");
			
		} catch (IOException e) {
			
		}
	}

	
	public static boolean isImageSaveThumb() {
		return imageSaveThumb;
	}

	public static String getImageDomain() {
		return imageDomain;
	}

	public static String getImageSavepath() {
		return imageSavepath;
	}

	public static Integer getImagePrefix() {
		return imagePrefix;
	}

	public static Integer getImageMaxWidth() {
		return imageMaxWidth;
	}


	public static String getLuceneIndexPath() {
		return luceneIndexPath;
	}


	public static String getZFB_PAY_URL() {
		return ZFB_PAY_URL;
	}


	public static String getZFB_SERVICE() {
		return ZFB_SERVICE;
	}


	public static String getZFB_SIGN_TYPE() {
		return ZFB_SIGN_TYPE;
	}


	public static String getZFB_INPUT_CHARSET() {
		return ZFB_INPUT_CHARSET;
	}


	public static String getZFB_PARTNER() {
		return ZFB_PARTNER;
	}


	public static String getZFB_KEY() {
		return ZFB_KEY;
	}


	public static String getZFB_SHOW_URL() {
		return ZFB_SHOW_URL;
	}


	public static String getZFB_PAYMENT_TYPE() {
		return ZFB_PAYMENT_TYPE;
	}


	public static String getZFB_EMAIL() {
		return ZFB_EMAIL;
	}


	public static String getZFB_NOTIFY_URL() {
		return ZFB_NOTIFY_URL;
	}


	public static String getZFB_RETURN_URL() {
		return ZFB_RETURN_URL;
	}
	
	

}
