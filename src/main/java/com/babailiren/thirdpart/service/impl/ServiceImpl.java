package com.babailiren.thirdpart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceImpl  {


	/**
	 * 构造提交表单HTML数据
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param gateway
	 *            网关地址
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @return 提交表单HTML文本
	 */
	public String buildForm(Map<String, String> sParaTemp,String gateway, String strMethod) {
		// 待请求参数数组
		Map<String, String> sPara = sParaTemp;
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();
		sbHtml.append("<form id=\"loginsubmit\" name=\"loginsubmit\" action=\""
				+ gateway + "\" method=\"" + strMethod + "\">");
		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);
			sbHtml.append("<input type=\"hidden\" name=\"" + name
					+ "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("</form>");
		sbHtml.append("<script>document.forms['loginsubmit'].submit();</script>");
		System.out.println(sbHtml);
		return sbHtml.toString();
	}
}
