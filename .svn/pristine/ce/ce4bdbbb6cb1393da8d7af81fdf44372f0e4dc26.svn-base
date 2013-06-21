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

public class AlipayThirdpartUtil {
	/**
     * 支付宝通知验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	/**
     * 生成要请求给支付宝的参数数组
     * @param sParaTemp 请求前的参数数组
     * @return 要请求的参数数组
     */
    public static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        //除去数组中的空值和签名参数
        Map<String, String> sPara = paraFilter(sParaTemp);
        //生成签名结果
        String mysign = buildMysign(sPara);
     System.out.println(mysign);
        //签名结果与签名方式加入请求提交参数组中
        sPara.put("sign", mysign);
        sPara.put("sign_type", Config.ALIPAY_sign_type);

        return sPara;
    }
    
    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    private static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
    /**
     * 生成签名结果
     * @param sArray 要签名的数组
     * @return 签名结果字符串
     */
    private static String buildMysign(Map<String, String> sArray) {
        String prestr = createLinkString(sArray); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        prestr = prestr + Config.ALIPAY_key; //把拼接后的字符串再与安全校验码直接连接起来
        String mysign = md5(prestr);
        return mysign;
    }
    
    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    private static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    private static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.log_path);
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 对字符串进行MD5签名
     * 
     * @param text
     *            明文
     * 
     * @return 密文
     */
    private static String md5(String text) {

        return DigestUtils.md5Hex(getContentBytes(text, AlipayConfig.input_charset));

    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    
    public  static Map<String ,String> bulidMap(Map paramsMap){
    	Map<String,String> params = new HashMap<String,String>();
    	for (Iterator iter = paramsMap.keySet().iterator(); iter.hasNext();) {
    		String name = (String) iter.next();
    		String[] values = (String[]) paramsMap.get(name);
    		String valueStr = "";
    		for (int i = 0; i < values.length; i++) {
    			valueStr = (i == values.length - 1) ? valueStr + values[i]
    					: valueStr + values[i] + ",";
    		}
    		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
    		try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		params.put(name, valueStr);
    	}
    	return params;
    }
    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @return 生成的签名结果
     */
    private static String getMysign(Map<String, String> Params) {
        Map<String, String> sParaNew = AlipayCore.paraFilter(Params);//过滤空值、sign与sign_type参数
        String mysign = AlipayCore.buildMysign(sParaNew);//获得签名结果
        return mysign;
    }
    /**
     * 获取远程服务器ATN结果,验证返回URL
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
     private static String verifyResponse(String notify_id) {
         //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

         String partner = AlipayConfig.partner;
         String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

         return checkUrl(veryfy_url);
     }
     /**
      * 获取远程服务器ATN结果
      * @param urlvalue 指定URL路径地址
      * @return 服务器ATN结果
      * 验证结果集：
      * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
      * true 返回正确信息
      * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
      */
      private static String checkUrl(String urlvalue) {
          String inputLine = "";

          try {
              URL url = new URL(urlvalue);
              HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
              BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                  .getInputStream()));
              inputLine = in.readLine().toString();
          } catch (Exception e) {
              e.printStackTrace();
              inputLine = "";
          }

          return inputLine;
      }
    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params,boolean log) {

        String mysign = getMysign(params);
        String responseTxt = "true";
        if(params.get("notify_id") != null) {responseTxt = verifyResponse(params.get("notify_id"));}
        String sign = "";
        if(params.get("sign") != null) {sign = params.get("sign");}

        //写日志记录（若要调试，请取消下面两行注释）
//        if(log) {
//            String sWord = "responseTxt=" + responseTxt + "\n notify_url_log:sign=" + sign + "&mysign="
//                    + mysign + "\n notify回来的参数：" + AlipayCore.createLinkString(params);
//            AlipayCore.logResult(sWord);
//        }



        //验证
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
        if (mysign.equals(sign) && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    /**
	 * 支付宝的同步登录
     * 构造提交表单HTML数据
     * @param sParaTemp 请求参数数组
     * @param gateway 网关地址
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildReturn(HttpServletRequest request,String site,Map requestParams) {
    	Map<String,String> params = new HashMap<String,String>();
    	params=bulidMap(requestParams); 	
    	 String is_success=params.get("is_success");
    	 //是否处理成功
    	 
    	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
    	
    	//计算得出通知验证结果
    	boolean verify_result = AlipayNotify.verify(params,true);
    	
    	if(verify_result){//验证成功
    		//将信息保存到数据库
	    	//支付宝用户id
	    	String user_id = request.getParameter("user_id");
	    	//授权令牌
	    	String token = request.getParameter("token");
	    	//支付宝用的email
	    	String email= request.getParameter("email");
	    	//得到用户的姓名
	    	if (email!=null && !"".equals(email)) {
				return "";
			}else{
				request.getSession().setAttribute("userName", params.get("real_name"));
				request.getSession().setAttribute("userReturn", params);
				request.getSession().setAttribute("bianPage", "alipay");
				//跳到账号绑定的页面s\
			//System.out.println("绑定页面");
				request.setAttribute("source", "支付宝");
				return  "thirdpart/bindInfoTest";
			}
    	}else{
    		return "user/login";
    	}
    }
}
