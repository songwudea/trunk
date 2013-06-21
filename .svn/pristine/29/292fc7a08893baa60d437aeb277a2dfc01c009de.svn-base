package com.babailiren.thirdpart.util;

import com.babailiren.thirdpart.config.Config;
import com.babailiren.thirdpart.sina.config.SinaConfig;

public class SinaThirdpartUtil {
	/**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_sina_token(String code) {
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(Config.SINA_GATEWAY_TOKEN);
        action_url.append("client_id=");
        action_url.append(SinaConfig.AppKey);
        action_url.append("&client_secret=");
        action_url.append(SinaConfig.AppSecret);
        action_url.append("&grant_type=");
        action_url.append("authorization_code");
        action_url.append("&redirect_uri=");
        action_url.append(SinaConfig.redirect_uri);
        action_url.append("&code=");
        action_url.append(code);
        return action_url.toString();
    }
    
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_sina_user_info(String access_token,String uid) {
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(Config.SINA_GATEWAY_USER_INFO);
        action_url.append("source");
        action_url.append("");
        action_url.append("&access_token=");
        action_url.append(access_token);
        action_url.append("&uid=");
        action_url.append(uid);
     System.out.println("sin拿到用户信息:"+action_url);
        return action_url.toString();
    }
}
