package com.babailiren.thirdpart.sina.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.babailiren.thirdpart.sina.config.SinaConfig;


public class SinaService {
    
  
    private static final String SINA_GATEWAY_TOKEN = "https://api.weibo.com/oauth2/access_token?";
    //根据sina的用户的用户ID获取用户信息
    private static final String SINA_GATEWAY_USER_INFO="https://api.weibo.com/2/users/show.json?";
    private static final String SINA_GATEWAY_LOGIN="https://api.weibo.com/oauth2/authorize?";
    
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_sina_login(String code) {
        //生成请求的路径
    	Map<String, String> sParaTemp =new HashMap<String, String>();
    	 sParaTemp.put("client_id", SinaConfig.AppKey);
         sParaTemp.put("redirect_uri",SinaConfig.redirect_uri);
         sParaTemp.put("response_type",code);
         sParaTemp.put("state", "zq0209");
         sParaTemp.put("display", "default");
         sParaTemp.put("language", "");
        StringBuffer action_url=new StringBuffer();
        action_url.append(SINA_GATEWAY_LOGIN);
        action_url.append("client_id=");
        action_url.append(SinaConfig.AppKey);
        action_url.append("&redirect_uri=");
        action_url.append(SinaConfig.redirect_uri);
        action_url.append("&response_type=");
        action_url.append(code);
        action_url.append("&state=");
        action_url.append("zq0209");
        action_url.append("&display=");
        action_url.append("default");
        action_url.append("&language=");
        action_url.append("");
//        return action_url.toString();
        String strButtonName = "确认";
   System.out.println("yi:"+action_url);
        return buildForm(sParaTemp, action_url, "post", strButtonName);
    }
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_sina_token(String code) {
    	Map<String, String> sParaTemp =new HashMap<String, String>();
    	//定义一系列的参数
		//把请求参数打包成数组
        sParaTemp.put("client_id", SinaConfig.AppKey);
        sParaTemp.put("client_secret",SinaConfig.AppSecret);
        sParaTemp.put("grant_type","authorization_code");
        sParaTemp.put("redirect_uri",SinaConfig.redirect_uri);        
        sParaTemp.put("code" , code);
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(SINA_GATEWAY_TOKEN);
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
//        String strButtonName = "确认";
//   System.out.println("yi:"+action_url);
//        return buildForm(sParaTemp, action_url, "post", strButtonName);
    }
    
    /**
     * 构造快捷登录接口
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String get_sina_user_info(String access_token,String uid) {
        //生成请求的路径
        StringBuffer action_url=new StringBuffer();
        action_url.append(SINA_GATEWAY_USER_INFO);
        action_url.append("source");
        action_url.append("");
        action_url.append("&access_token=");
        action_url.append(access_token);
        action_url.append("&uid=");
        action_url.append(uid);
     System.out.println("sin拿到用户信息:"+action_url);
        return action_url.toString();
//        String strButtonName = "确认";
//        return buildForm(sParaTemp, action_url, "post", strButtonName);
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
        sbHtml.append("<form id=\"sinaloginsubmit\" name=\"sinaloginsubmit\" action=\"" + gateway
                      + "\" method=\"" + strMethod
                      + "\">");
        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("</form>");
        sbHtml.append("<script>document.forms['sinaloginsubmit'].submit();</script>");
     System.out.println(sbHtml);
        return sbHtml.toString();
    }
}
