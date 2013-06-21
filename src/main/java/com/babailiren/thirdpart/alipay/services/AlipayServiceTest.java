package com.babailiren.thirdpart.alipay.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.babailiren.thirdpart.alipay.config.AlipayConfig;
import com.babailiren.thirdpart.config.Config;
import com.babailiren.thirdpart.service.AlipayServiceI;
import com.babailiren.thirdpart.service.ServiceI;
import com.babailiren.thirdpart.service.impl.ServiceImpl;
import com.babailiren.thirdpart.util.AlipayThirdpartUtil;

/* *
 *类名：AlipayService
 *功能：支付宝各接口构造类
 *详细：构造支付宝各接口请求参数
 *版本：3.2
 *修改日期：2011-03-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayServiceTest extends AlipayThirdpartUtil implements ServiceI,AlipayServiceI{
	private ServiceImpl impl=new ServiceImpl();
    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    
    
    /**
     * 返回alipay授权请求的表单元素
     */
	@Override
	public String sbHtml() {
		Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "alipay.auth.authorize");
        sParaTemp.put("target_service", "user.auth.quick.login");
        sParaTemp.put("partner", Config.ALIPAY_partner);
        sParaTemp.put("return_url", Config.ALIPAY_login_suss);
        sParaTemp.put("_input_charset", Config.ALIPAY_input_charset);
        sParaTemp.put("anti_phishing_key", "");
        sParaTemp.put("exter_invoke_ip", "");
        String actionUrl=actionUrl(sParaTemp);
        sParaTemp=buildRequestPara(sParaTemp);
        String sbHtml=impl.buildForm(sParaTemp, actionUrl,"get");
        return sbHtml;
	}
	/**
     *返回Alipay授权的表单请求的action
     */
	@Override
	public String actionUrl(Map<String, String> sParaTemp) {
		StringBuffer action_url=new StringBuffer();
   	 	Map<String, String> sPara = AlipayThirdpartUtil.buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());
        action_url.append(ALIPAY_GATEWAY_NEW);
   	 for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);
            action_url.append(name);
            action_url.append("=");
            action_url.append(value);
            if (i==keys.size()-1) {				
			}else{
				action_url.append("&");
			}
        }
       return action_url.toString();
	}
	@Override
	public String actionReturnUrl(Map<String, String> sParam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map getParameterMaps(HttpServletRequest request) {
		Map requestParams=request.getParameterMap();
		return requestParams;
	}
	
	
}
