package com.babailiren.ec.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.enumeration.OrderDispatchEnum;
import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.model.Province;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.pay.PayUtils;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.OrderDispatchService;
import com.babailiren.ec.service.OrderPayService;
import com.babailiren.ec.service.OrderService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.babailiren.thirdpart.alipay.services.AlipayService;
import com.babailiren.thirdpart.alipay.util.AlipayNotify;
import com.babailiren.thirdpart.alipay.util.UtilDate;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;

	@Autowired
	private OrderPayService orderPayService;
	
	@Autowired
	private OrderDispatchService orderDispatchService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private WebCache webCache;

	/**
	 * 结算
	 * 
	 * @return
	 */
	@RequestMapping(value = "settleaccount.html", method = RequestMethod.GET)
	public String settleAccount(HttpServletRequest request,
			HttpServletResponse response, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer) request.getSession().getAttribute(SessionName.USER_ID.toString());
		if(userId == null) {
			request.setAttribute("url", "pay/settleaccount.html");
			WebUtils.putErrorMessage("您需要登录后才能继续购买", request);
			return WebUtils.themesView(request, currentSite, "user/login");
		}
		String guestId = WebUtils.getGuestID(request, response);
		
		
		// 购物车中的物品
		List<Cart> carts = cartService.findAll(userId, guestId);
		// 算总价
		Integer total = PayUtils.total(carts);
		
		// 用户地址
		List<Address> addresses = addressService.findAddressByUserId(userId);
		List<Province> provinces = addressService.findProvinces();
		
		request.setAttribute("provinces", provinces);
		request.setAttribute("orders", carts);
		request.setAttribute("total", total);
		request.setAttribute("addresses", addresses);
		
		return WebUtils.themesView(request, currentSite, "pay/settleaccount");
	}

	
	@RequestMapping(value = "pay_success.html", method = RequestMethod.GET)
	public String paySuccess(HttpServletRequest request,
			HttpServletResponse response, String trade_no,String out_trade_no,String total_fee,
			String subject,String body,String buyer_email,String receive_name,String receive_address,
			String receive_zip,String receive_phone,String receive_mobile,String trade_status) {
		//获取支付宝POST过来反馈信息
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), "");
		Map<String,String> params = new HashMap<String,String>();
		
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
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
		
		
/*		params.put("trade_no",trade_no);
		params.put("out_trade_no",out_trade_no);
		params.put("price",price);
		params.put("subject",subject);
		params.put("body",body);
		params.put("buyer_email",buyer_email);
		params.put("receive_name",receive_name);
		params.put("receive_address",receive_address);
		params.put("receive_zip",receive_zip);
		params.put("receive_phone",receive_phone);
		params.put("receive_mobile",receive_mobile);
		params.put("trade_status",trade_status);*/
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
	
		boolean verify_result = true;AlipayNotify.verify(params,false);
		
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){

				//request.setAttribute("subject", "感谢您订购瞳话产品，我们会尽快为您安排配送。");
			}
		
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				//request.setAttribute("subject", "感谢您订购瞳话产品，我们会尽快为您安排配送。");
			}
			
			
			OrderPay op = orderPayService.getOrderPayByPayNumber(out_trade_no);
			///user/order.html
			
			List<String> msg = Lists.newArrayList();
			msg.add("您已成功付款 <font color=red>￥"+total_fee+"</font> 元");
			msg.add("感谢您在瞳话官方商城购物！我们会尽快为您安排配送。");
			msg.add("订单编号：<a href='"+request.getContextPath()+"/user/order_"+op.getOrderNumber()+".html'>"+op.getOrderNumber()+"</a>");
			msg.add("支付单号："+op.getTradeNumber());
			msg.add("<a href='"+request.getContextPath()+"/user/order.html'>&#187; 我的订单</a>");
			request.setAttribute("message", Joiner.on("<br/>").join(msg));
			request.setAttribute("amount", total_fee);
			request.setAttribute("orderId", op.getOrderNumber());
			//该页面可做页面美工编辑
			//out.println("验证成功<br />");
			//out.println("trade_no=" + trade_no);
			
			//request.setAttribute("trade_no", trade_no);
			//request.setAttribute("out_trade_no", out_trade_no);
			//request.setAttribute("receive_address", receive_address);
			

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
			
			return WebUtils.themesView(request, currentSite, "pay/finished");
			
		}else{
			
			request.setAttribute("message", "交易验证失败，请通过<a href='"+request.getContextPath()+"/user/order.html'>我的订单</a>重新进行支付");
			return WebUtils.themesView(request, currentSite, "pay/finished");
		}
	
	}
	@ResponseBody
	@RequestMapping(value = "alipay_return.html", method = RequestMethod.POST)
	public String alipay(HttpServletRequest request,
			HttpServletResponse response, String trade_no,String out_trade_no,String price,
			String subject,String body,String buyer_email,String receive_name,String receive_address,
			String receive_zip,String receive_phone,String receive_mobile,String trade_status) {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
/*			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			params.put(name, valueStr);
		}
		
/*		params.put("trade_no",trade_no);
		params.put("out_trade_no",out_trade_no);
		params.put("price",price);
		params.put("subject",subject);
		params.put("body",body);
		params.put("buyer_email",buyer_email);
		params.put("receive_name",receive_name);
		params.put("receive_address",receive_address);
		params.put("receive_zip",receive_zip);
		params.put("receive_phone",receive_phone);
		params.put("receive_mobile",receive_mobile);
		params.put("trade_status",trade_status);*/
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if(AlipayNotify.verify(params,true)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			OrderPay orderPay = orderPayService.getOrderPayByPayNumber(out_trade_no);
			String orderNumber = orderPay.getOrderNumber();
			orderPay.setBuyer(buyer_email);
			
			orderPayService.updateBuyer(buyer_email, orderPay.getPayNumber());
			
			
			if(trade_status.equals("WAIT_BUYER_PAY")){
				//该判断表示买家已在支付宝交易管理中产生了交易记录，但没有付款
				
					//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					orderPayService.updateStatus(trade_no,out_trade_no, OrderPayEnum.ORDER_PAY_STATUS_BUYER_WAIT);
					// orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_WAIT_PAY);
					return "success";
				} else if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
				//该判断表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货
				
					//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					// orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_CONFIRM);
					orderPayService.updateStatus(trade_no,out_trade_no, OrderPayEnum.ORDER_PAY_STATUS_SELLER_CONFIRM);
					
					return "success";
				} else if(trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")){
					// 该判断表示卖家已经发了货，但买家还没有做确认收货的操作
					// 判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					// orderPayService.updateStatus(out_trade_no, OrderPayEnum.ORDER_PAY_WAIT_BUYRT_CONFIRM);
					return "success";
				} else if(trade_status.equals("TRADE_FINISHED")){
					
					// 立即到账
					if("ORDER_PAY_STATUS_BUYER_WAIT".equals(orderPay.getStatus())) {
						orderPayService.updateStatus(trade_no,out_trade_no, OrderPayEnum.ORDER_PAY_STATUS_SELLER_CONFIRM);
						return "success";
					} else {
						// 该判断表示买家已经确认收货，这笔交易完成
						// 判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
						// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						// 如果有做过处理，不执行商户的业务程序
						orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_FINISH);
//					orderPayService.updateStatus(out_trade_no, OrderPayEnum.ORDER_PAY_FINISH);
						orderDispatchService.updateStatus(orderNumber, OrderDispatchEnum.ORDER_DISPATCH_STATUS_FINISH);
						return "success";
					}
					
					
					
				} else {
					return "success";
				}
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
		} else{//验证失败
			orderPayService.updateStatus(trade_no,out_trade_no, OrderPayEnum.ORDER_PAY_VERIFY_FAIL);
			return "fail";
		}
	}
	
	

	@RequestMapping(value = "alipay_{userOrder}.html", method = RequestMethod.GET)
	public String alipay(HttpServletRequest request,
			HttpServletResponse response, String site,@PathVariable String userOrder) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer) request.getSession().getAttribute(SessionName.USER_ID.toString());
		if(userId == null) {
			WebUtils.putErrorMessage("您需要登录后才能继续购买", request);
			return WebUtils.themesView(request, currentSite, "user/login");
		}
		String guestId = WebUtils.getGuestID(request, response);
		Orders order = orderService.getOrder(userOrder);
		

		////////////////////////////////////请求参数//////////////////////////////////////
		
		//必填参数//

		
		// 根据orderNumber 查看是否支付过支付过则读出
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(order.getOrderNumber());
		
		
		
		String out_trade_no = "";
		String subject = "";
		String body = "";
		String price = "";
		String logistics_fee = "";
		String logistics_type = "";
		String logistics_payment = "";
		String quantity = "";
		String receive_name	= "";
		String receive_address = "";
		String receive_zip = "";
		String receive_phone = "";
		String receive_mobile = "";
		String show_url = "";
		
		
		if(orderPays != null && orderPays.size() > 0) {
			OrderPay orderPay = orderPays.get(0);
			// UtilDate date = new UtilDate();//调取支付宝工具类生成订单号
			//请与贵网站订单系统中的唯一订单号匹配
			out_trade_no = orderPay.getPayNumber();
			//订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			subject = "瞳话官方商城_"+order.getOrderNumber();
			//订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			body = "";
			//订单总金额，显示在支付宝收银台里的“应付总额”里
			price = String.valueOf(order.getPrice() / 100);
			
			//物流费用，即运费。
			logistics_fee = String.valueOf(order.getShipfee() / 100);
			//物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
			logistics_type = "EXPRESS";
			//物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
			logistics_payment = "SELLER_PAY";
			
			//商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。
			quantity = "1";
			
			//扩展参数//
			
			//买家收货信息（推荐作为必填）
			//该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
			//若要使用该功能，请至少保证receive_name、receive_address有值
			receive_name	= order.getShipname();			//收货人姓名，如：张三
			receive_address = order.getShipcity()+order.getShipregion()+order.getShipaddress();		//收货人地址，如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
			receive_zip = order.getShipzip();				//收货人邮编，如：123456
			receive_phone = order.getShiptel();		//收货人电话号码，如：0571-81234567
			receive_mobile = order.getShiptel();		//收货人手机号码，如：13312341234
			
			// 网站商品的展示地址，不允许加?id=123这类自定义参数
			show_url = "http://www.pretale.com/eyes/heiyanquan.html";
		} else {
			// UtilDate date = new UtilDate();//调取支付宝工具类生成订单号
			//请与贵网站订单系统中的唯一订单号匹配
			out_trade_no = UtilDate.getOrderNum();
			//订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			subject = "瞳话官方商城_"+order.getOrderNumber();
			//订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			body = "";
			//订单总金额，显示在支付宝收银台里的“应付总额”里
			price = String.valueOf(order.getPrice() / 100);
			
			//物流费用，即运费。
			logistics_fee = String.valueOf(order.getShipfee() / 100);
			//物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
			logistics_type = "EXPRESS";
			//物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
			logistics_payment = "SELLER_PAY";
			
			//商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。
			quantity = "1";
			
			//扩展参数//
			
			//买家收货信息（推荐作为必填）
			//该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
			//若要使用该功能，请至少保证receive_name、receive_address有值
			receive_name	= order.getShipname();			//收货人姓名，如：张三
			receive_address = order.getShipcity()+order.getShipregion()+order.getShipaddress();		//收货人地址，如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
			receive_zip = order.getShipzip();				//收货人邮编，如：123456
			receive_phone = order.getShiptel();		//收货人电话号码，如：0571-81234567
			receive_mobile = order.getShiptel();		//收货人手机号码，如：13312341234
			
			// 网站商品的展示地址，不允许加?id=123这类自定义参数
			show_url = "http://www.pretale.com/eyes/heiyanquan.html";
			orderPayService.createPay(order.getOrderNumber(),out_trade_no);
		}
		
		
		
		

		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("payment_type","1");
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("body", body);
		sParaTemp.put("price", price);
		sParaTemp.put("logistics_fee", logistics_fee);
		sParaTemp.put("logistics_type", logistics_type);
		sParaTemp.put("logistics_payment", logistics_payment);
		sParaTemp.put("quantity", quantity);
		sParaTemp.put("receive_name", receive_name);
		sParaTemp.put("receive_address", receive_address);
		sParaTemp.put("receive_zip", receive_zip);
		sParaTemp.put("receive_phone", receive_phone);
		sParaTemp.put("receive_mobile", receive_mobile);
		
		//构造函数，生成请求URL
		String sHtmlText = AlipayService.trade_create_by_buyer(sParaTemp);

		//创建一个OP

		request.setAttribute("sHtmlText", sHtmlText);
		return WebUtils.themesView(request, currentSite, "pay/alipay");
	}
	
	public static void main(String[] args) {
		System.out.println("%E6%8B%89%E4%B8%9D%E5%A7%97");
	}
}
