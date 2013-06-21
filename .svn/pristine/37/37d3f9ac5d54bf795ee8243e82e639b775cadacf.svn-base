package com.babailiren.thirdpart.util;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import com.babailiren.thirdpart.sina.service.util.MySecureProtocolSocketFactory;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;

public class ThirdpartUtil {

	public static String getResponseContent(String action_url,String methodFailed){
			WebClient client = new WebClient();
			String content = "";
			try {
				WebRequest req = new WebRequest(new URL(action_url),"post".equalsIgnoreCase(methodFailed)?HttpMethod.POST:HttpMethod.GET);
				Page page = client.getPage(req);
				content = page.getWebResponse().getContentAsString();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return content;
	    }
	    
	    
	    
	    public static String httpClient(String action_url,String methodFailed){
	    	String str="";
			//构造HttpClient的实例   
	    	ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
			 Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
		     HttpClient httpClient = new HttpClient();   
		     //设置 Http 连接超时为30秒   
		     httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);   
		    //创建GET方法的实例   
		    String url =   action_url; 
		    if("post".equals(methodFailed)){
			   PostMethod postMethod = new PostMethod(url);
	   		//设置 get 请求超时为 30秒   
			   postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,30000);   
	 	    	//使用系统提供的默认的恢复策略   
			   postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,   
	 	    			new DefaultHttpMethodRetryHandler()); 
	 		     try{   
	 		      //执行getMethod   
	 		      int statusCode = httpClient.executeMethod(postMethod);   
	 		      if (statusCode != HttpStatus.SC_OK){   
	 		       System.err.println("Method failed: "  
	 		              + postMethod.getStatusLine());   
	 		      }   
	 		      //读取内容 
	 		      byte[] responseBody = postMethod.getResponseBody();   
	 		      //处理内容   
	 		      str=new String(responseBody);
	 		     }catch(HttpException e){   
	 		      //可能是协议不对或者返回的内容有问题   
	 		        System.out.println("Please check your provided http address!");   
	 		        e.printStackTrace();   
	 		     }catch(IOException e){   
	 		      //发生网络异常   
	 		      e.printStackTrace();   
	 		     }finally{   
	 		      //释放连接   
	 		    	postMethod.releaseConnection();
	 		     } 
		    }else{
		    	GetMethod getMethod = new GetMethod(url);
		   
		    	//设置 get 请求超时为 20秒   
		    	getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,30000);   
		    	//使用系统提供的默认的恢复策略   
		    	getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,   
		    			new DefaultHttpMethodRetryHandler()); 
			     try{   
			      //执行getMethod   
			      int statusCode = httpClient.executeMethod(getMethod);   
			      if (statusCode != HttpStatus.SC_OK){   
			       System.err.println("Method failed: "  
			              + getMethod.getStatusLine());   
			      }   
			      //读取内容 
			      byte[] responseBody = getMethod.getResponseBody();   
			      //处理内容   
			      str=new String(responseBody);
			     }catch(HttpException e){   
			      //可能是协议不对或者返回的内容有问题   
			        System.out.println("Please check your provided http address!");   
			        e.printStackTrace();   
			     }catch(IOException e){   
			      //发生网络异常   
			      e.printStackTrace();   
			     }finally{   
			      //释放连接   
			    	getMethod.releaseConnection();
			     }  
		    }
	    	return str;
	    }
}
