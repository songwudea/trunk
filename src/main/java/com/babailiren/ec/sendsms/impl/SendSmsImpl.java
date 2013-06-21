package com.babailiren.ec.sendsms.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Map;

import com.babailiren.ec.sendsms.SendSmsI;
import com.babailiren.ec.sendsms.config.SendSmsConfig;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;

public class SendSmsImpl implements SendSmsI , Runnable{
	@Override
	public String sendSMSEXI(Map<String, String> sendParams) {
		StringBuffer url = new StringBuffer();
		String result = "";
		url.append(SendSmsConfig.SENDURL);
		url.append("regcode=");
		url.append(SendSmsConfig.REGCODE);
		url.append("&pwd=");
		url.append(SendSmsConfig.PWD);
		url.append("&phone=");
		url.append(sendParams.get("phone"));
		url.append("&CONTENT=");
		try {
			url.append(URLEncoder.encode(sendParams.get("content"), "gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		url.append("&extnum=1");
		url.append("&level=1");
		url.append("&Schdate=null");
		url.append("&reportflag=1");
		url.append("&url=null");
		url.append("&smstype=0");
		url.append("&key=");
		url.append(SendSmsConfig.KEY);
		result = webClient(url.toString());
		return result;
	}

	@Override
	public String recvSMSI() {
		//开启一条线程
		new Thread(new SendSmsImpl()).start();
		return null;
	}

	
	@Override
	public void run() {
		boolean flag=false;
		int time= 60 * 60 * 1000;
		while (true) {
			/*System.out.println("----");
			String date=DateUtil.getFormatDate("HH", new Date());
			if (date.equals("22") && !flag) {
				flag = true;
				time = 24 * 60 * 60 * 1000;
			}   
			if (flag) {
				//接收短信
			}
			try {
				//线程休眠60分钟
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			date  =DateUtil.getFormatDate("HH", new Date());;// 计算当前时间
*/		}
	}

	private String webClient(String url){
		WebClient client = new WebClient();
		Page page = null;
		try {
			page = client.getPage(url);
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String content = page.getWebResponse().getContentAsString();
	System.out.println(content);
		return content;
	}
	
	public static void main(String[] args) {

	}
	
}
