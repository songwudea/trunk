package com.babailiren.thirdpart.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import com.babailiren.thirdpart.alipay.config.AlipayConfig;
import com.babailiren.thirdpart.alipay.util.AlipayCore;
import com.babailiren.thirdpart.alipay.util.AlipayNotify;
import com.babailiren.thirdpart.config.Config;
import com.babailiren.thirdpart.qq.config.QqConfig;

public class QqThirdpartUtil {
	/**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_user_info_Access_Token(String code) {
    	//定义一系列的参数
    	String authorizationCode="authorization_code";
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(Config.QQ_GATEWAY_ACCESS_TOKEN_URL);
        action_url.append("grant_type=");
        action_url.append(authorizationCode);
        action_url.append("&client_id=");
        action_url.append(QqConfig.APPID);
        action_url.append("&client_secret=");
        action_url.append(QqConfig.APPKEY);
        action_url.append("&code=");
        action_url.append(code);
        action_url.append("&state=");
        action_url.append(QqConfig.state);
        action_url.append("&redirect_uri=");
        action_url.append(QqConfig.redirect_uri_token);
		return action_url.toString();
    }
    
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_user_info_OpenID(String access_token) {
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(Config.QQ_GATEWAY_ACCESS_OpenID);
        action_url.append(access_token);
   		return action_url.toString();
    }
    
}
