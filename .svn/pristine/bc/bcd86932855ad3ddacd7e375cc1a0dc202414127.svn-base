package com.babailiren.thirdpart.service.factory;

import com.babailiren.thirdpart.alipay.services.AlipayServiceTest;
import com.babailiren.thirdpart.qq.service.QqServiceTest;
import com.babailiren.thirdpart.service.AlipayServiceI;
import com.babailiren.thirdpart.service.ServiceI;
import com.babailiren.thirdpart.sina.service.SinaServiceTest;

public class ServiceFactory {

	public ServiceI login(String pathBuild) {
		// 根据不同的登录的类型调用不同的service进行访问页面的构造
		if ("sina".equals(pathBuild)) {
			ServiceI sinaService = new SinaServiceTest();
			return sinaService;
		} else if ("alipay".equals(pathBuild)) {
			ServiceI alipayService = new AlipayServiceTest();
			return alipayService;
		} else if ("qq".equals(pathBuild)) {
			ServiceI qqService = new QqServiceTest();
			return qqService;
		}
		return null;
	}
	public AlipayServiceI loginAlipayReturn(String pathBuild) {
		AlipayServiceI alipayService = new AlipayServiceTest();
		return alipayService;
	}
}
