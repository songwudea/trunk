package com.babailiren.thirdpart.qq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.babailiren.thirdpart.qq.config.QqConfig;


public class QqService {
    
  
    private static final String QQ_GATEWAY_NEW = "https://graph.qq.com/oauth2.0/authorize?";
    private static final String QQ_GATEWAY_ACCESS_TOKEN_URL="https://graph.qq.com/oauth2.0/token?";
    private static final String QQ_GATEWAY_ACCESS_OpenID="https://graph.qq.com/oauth2.0/me?";
    private static final String QQ_GATEWAY_INFO="https://graph.qq.com/user/get_user_info?";
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_user_info() {
    	Map<String, String> sParaTemp =new HashMap<String, String>();
    	//定义一系列的参数
		String scope ="get_user_info";
		String state ="test";
		String display ="";
		String g_ut ="2";
		//把请求参数打包成数组
        sParaTemp.put("scope", scope);
        sParaTemp.put("state",state);
        sParaTemp.put("display",display);
        sParaTemp.put("g_ut",g_ut);        
        sParaTemp.put("client_id", QqConfig.APPID);
        sParaTemp.put("redirect_uri" , QqConfig.redirect_uri );
        sParaTemp.put("response_type" , QqConfig.response_type);
        sParaTemp.put("state" , QqConfig.state);
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(QQ_GATEWAY_NEW);
        action_url.append("response_type=");
        action_url.append(QqConfig.response_type);
        action_url.append("&client_id=");
        action_url.append(QqConfig.APPID);
        action_url.append("&redirect_uri=");
        action_url.append(QqConfig.redirect_uri);
        action_url.append("&scope=");
        action_url.append(scope);
        action_url.append("&state=");
        action_url.append(QqConfig.state);
        action_url.append("&display=");
        action_url.append("&g_ut=2");
        String strButtonName = "确认";
//   System.out.println("yi:"+action_url);
        return buildForm(sParaTemp, action_url, "post", strButtonName);
    }
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_user_info_Access_Token(String code) {
    	Map<String, String> sParaTemp =new HashMap<String, String>();
    	//定义一系列的参数
    	String authorizationCode="authorization_code";
    	sParaTemp.put("grant_type" , authorizationCode);
        sParaTemp.put("client_id", QqConfig.APPID);
        sParaTemp.put("client_secret" , QqConfig.APPKEY);
        sParaTemp.put("code" , code);
        sParaTemp.put("state" , QqConfig.state);
        sParaTemp.put("redirect_uri" , QqConfig.redirect_uri);
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(QQ_GATEWAY_ACCESS_TOKEN_URL);
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
//   System.out.println("er:"+action_url);
   		//直接返回调用的URL
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
        action_url.append(QQ_GATEWAY_ACCESS_OpenID);
        action_url.append(access_token);
//   System.out.println("san:"+action_url);
   		return action_url.toString();
    }
    
    
    /**
    * 构造快捷登录接口
    * @param sParaTemp 请求参数集合
    * @return 表单提交HTML信息
    */
   public static String get_user_info_all(String access_token,String openId) {
		//把请求参数打包成数组
       StringBuffer action_url=new StringBuffer();
       action_url.append(QQ_GATEWAY_INFO);
       action_url.append(access_token);
       action_url.append("&oauth_consumer_key=");
       action_url.append(QqConfig.APPID);
       action_url.append("&openid=");
       action_url.append(QqConfig.APPKEY);
//  System.out.println("san:"+action_url);
  		return action_url.toString();
   }
    /**
     * 构造提交表单HTML数据
     * @param sParaTemp 请求参数数组
     * @param gateway 网关地址
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildForm(Map<String, String> sParaTemp, StringBuffer gateway, String strMethod,
                                   String strButtonName) {
    	
        //待请求参数数组
        Map<String, String> sPara = sParaTemp;
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\"qqloginsubmit\" name=\"qqloginsubmit\" action=\"" + gateway
                      + "\" method=\"" + strMethod
                      + "\">");
        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("</form>");
        sbHtml.append("<script>document.forms['qqloginsubmit'].submit();</script>");
     System.out.println(sbHtml);
        return sbHtml.toString();
    }
}
