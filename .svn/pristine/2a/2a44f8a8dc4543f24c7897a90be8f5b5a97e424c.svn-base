package com.babailiren.ec.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.enumeration.OpenAuth;
import com.babailiren.ec.enumeration.PurchasingType;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.Province;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.User;
import com.babailiren.ec.pay.PayUtils;
import com.babailiren.ec.provider.PointProvider;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.service.UserService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.babailiren.thirdpart.alipay.services.AlipayService;
import com.babailiren.thirdpart.qq.config.QqConfig;
import com.babailiren.thirdpart.qq.service.QqService;
import com.babailiren.thirdpart.qq.service.QqServiceTest;
import com.babailiren.thirdpart.qq.vo.QqInfoOpenIdVo;
import com.babailiren.thirdpart.qq.vo.QqUserInfoVo;
import com.babailiren.thirdpart.service.AlipayServiceI;
import com.babailiren.thirdpart.service.ServiceI;
import com.babailiren.thirdpart.service.factory.ServiceFactory;
import com.babailiren.thirdpart.sina.service.SinaServiceTest;
import com.babailiren.thirdpart.sina.vo.SinaInfoTokenVo;
import com.babailiren.thirdpart.sina.vo.SinaUserInfoVo;
import com.babailiren.thirdpart.util.AlipayThirdpartUtil;
import com.babailiren.thirdpart.util.QqThirdpartUtil;
import com.babailiren.thirdpart.util.SinaThirdpartUtil;
import com.babailiren.thirdpart.util.ThirdpartUtil;
import com.google.gson.Gson;


@Controller
@RequestMapping("/tpTest")
public class ThirdpartLoginControllerTest {

	
	@Autowired
	private WebCache webCache;

	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;
	private ServiceFactory factory=new ServiceFactory();
	
	
    /**
     * 第三方登录的方法
     * @param request
     * @param site
     * @return
     */
    @RequestMapping(value = "{pathBuild}Login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, String site, @PathVariable String pathBuild) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		//sina用户的登录
		//根据不同的登录的类型调用不同的service进行访问页面的构造
		String sHtmlText="";
		ServiceI service=factory.login(pathBuild);
		sHtmlText=service.sbHtml();
		request.setAttribute("html", sHtmlText);
		return WebUtils.themesView(request, currentSite, "thirdpart/outHtmlUrl");
	}
    
    
    /**
     * 第三方登录后的回调
     * @return
     */
    @RequestMapping(value = "{pathBuild}LoginRegist.html", method = RequestMethod.GET)
   	public String LoginRegist(HttpServletRequest request,HttpServletResponse response, String site, @PathVariable String pathBuild,String code,String state,Boolean ifDemand) {
   		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
   		if ("Alipay".equals(pathBuild)) {
   			AlipayServiceI service=factory.loginAlipayReturn(pathBuild);
   			Map requestParams=service.getParameterMaps(request);
   	    	Map<String, String> sPara =  AlipayThirdpartUtil.bulidMap(requestParams); 
   	    	User userQq = userService.vailUserByOpenId(sPara.get("user_id"));
   	        if (userQq != null && !"".equals(userQq.getEmail()) && !"".equals(userQq.getName())) {
   				login(userQq,request);
   				return "redirect:/" + "";
   			}else{
   				String actionUrl=AlipayThirdpartUtil.buildReturn(request, site,requestParams);
   				if("".equals(actionUrl))
   					return "redirect:/" + "";
   				else
   					return WebUtils.themesView(request, currentSite, actionUrl);
   			}
		}else if("sina".equals(pathBuild)){
			String url=SinaThirdpartUtil.get_sina_token(code);
			String content = ThirdpartUtil. httpClient(url,"post");
			Gson gson=new Gson();
			SinaInfoTokenVo infoTokenVo=gson.fromJson(content, SinaInfoTokenVo.class);
			//拿到access_token
			String access_token=infoTokenVo.getAccess_token();
			String sinaUid=infoTokenVo.getUid();
			///从数据库检索，从cookie里面拿到的只是最后一个qq号码的信息，通过openid来检索  
			User userSina = userService.vailUserByOpenId(sinaUid);
			//如果不为空，就直接进行登录
			if (userSina != null && !"".equals(userSina.getEmail()) && !"".equals(userSina.getName())) {
				login(userSina,request);
				return "redirect:/" + "";
			}else{
				//通过access_token和sinaUid拿到用户的信息
				String infoUrl=SinaThirdpartUtil.get_sina_user_info(access_token, sinaUid);
				String contentAll=ThirdpartUtil.httpClient(infoUrl,"get");
				String contentAllInfo = contentAll.replaceAll(",\"source.*", "")+"}}";
				SinaUserInfoVo infoVo=gson.fromJson(contentAllInfo, SinaUserInfoVo.class);
				request.getSession().setAttribute("userName", infoVo.getScreen_name());
				request.getSession().setAttribute("userReturn", infoVo);
				request.getSession().setAttribute("bianPage", "sina");
				request.setAttribute("source", "sina");
				return WebUtils.themesView(request, currentSite, "thirdpart/bindInfo");
			}
		}else if ("qq".equals(pathBuild)) {
			if (state.equals(QqConfig.state)) {
				//生成表单的请求数据
				String action_url = QqThirdpartUtil.get_user_info_Access_Token(code);
				//在这里使用HttpClient访问页面
				String content =ThirdpartUtil. httpClient(action_url,"get");
				//拿到access_token
				String access_token = content.substring(0,content.indexOf("&"));
				//qqReturnToken(request, response, site, access_token);			
				//生成表单的请求数据
				String action_url_user=QqThirdpartUtil.get_user_info_OpenID(access_token);
				//在这里使用HttpClient访问页面
				String contentUser = ThirdpartUtil.httpClient(action_url_user,"get");
				String jsonContent=StringUtils.substringBetween(contentUser, "(",")");
				Gson gson = new Gson();
				QqInfoOpenIdVo fromJson = gson.fromJson(jsonContent, QqInfoOpenIdVo.class);
				//得到OPENid
				String openId=fromJson.getOpenid();
				///从数据库检索，从cookie里面拿到的只是最后一个qq号码的信息，通过openid来检索  
				User userQq = userService.vailUserByOpenId(openId);
				//如果不为空，就直接进行登录
				if (userQq != null && !"".equals(userQq.getEmail()) && !"".equals(userQq.getName())) {
					login(userQq,request);
					return "redirect:/" + "";
				}else{
					if (!"".equals(access_token) && !"".equals(openId)) {
						//生成url返回qq的用户信息
						String action_info_url=QqService.get_user_info_all(access_token,openId);
						String contentAll =ThirdpartUtil. httpClient(action_info_url,"get");
//					System.out.println(contentAll);
						//将返回的数据保存
						QqUserInfoVo qqUserInfoVo=gson.fromJson(contentAll, QqUserInfoVo.class);
						request.getSession().setAttribute("userReturn", qqUserInfoVo);
						request.getSession().setAttribute("userName", qqUserInfoVo.getNickname());
						request.getSession().setAttribute("bianPage","qq");
						request.getSession().setAttribute("openId", openId);
						request.setAttribute("source", "QQ");
						//将信息写入数据库，进行注册
					}else{
						WebUtils.putErrorMessage("参数错误，登录失败，请重新登录。", request);
					}
					return WebUtils.themesView(request, currentSite, "thirdpart/bindInfoTest");
				}
			}else{
				WebUtils.putErrorMessage("参数错误，登录失败，请重新登录。", request);
	    		return WebUtils.themesView(request, currentSite, "user/login");
			}
		}
   		return "";
    }
    /**
     * 用户登录账号绑定
     * @param request
     * @param site
     * @param user
     * @return
     */
    @SuppressWarnings({ "static-access", "unchecked" })
	@RequestMapping(value = "{pathBuild}Bind.html", method = RequestMethod.POST)
	public String Bind(HttpServletRequest request,HttpServletResponse response, String site,String email,String password,@PathVariable String pathBuild,Boolean ifDemand) {
    	Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
    	String userNmae="";
    	OpenAuth auth=null;
    	String openId="";
    	User user= new User();
    	user.setUsername(email);
    	user.setEmail(email);
    	if ("qq".equals(pathBuild)) {
    		QqUserInfoVo infoVo=(QqUserInfoVo) request.getSession().getAttribute("userReturn");
    		user.setName(infoVo.getNickname());
    		userNmae="qq_"+infoVo.getNickname();
    		auth=auth.QQ;
    		openId=request.getSession().getAttribute("openId").toString();
		}else if ("alipay".equals(pathBuild)) {
			Map<String,String> params = (Map<String, String>) request.getSession().getAttribute("userReturn");
			user.setName(params.get("real_name"));
			userNmae="alipay_"+params.get("real_name");
    		auth=auth.ALIPAY;
    		openId=params.get("user_id");
		}else if("sina".equals(pathBuild)){
			SinaUserInfoVo infoTokenVo=(SinaUserInfoVo) request.getSession().getAttribute("userReturn");
			user.setName(infoTokenVo.getScreen_name());
			userNmae="sina_"+infoTokenVo.getScreen_name();
    		auth=auth.SINA_WEIBO;
    		openId=infoTokenVo.getId();
		}
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setSiteId(currentSite.getId());
		user.setPassword(password);
		user.setUserSource(auth.toString());
		user.setUsername(userNmae);
		user.setOpenId(openId);
		userService.add(user);
		login(user,request);
		//将信息保存到cookie里面，下次登录的时候就不需要进行绑定了
		String userName="";
		String userEmail="";
		try {
			userName = URLEncoder.encode(user.getName(),"UTF-8");
			userEmail=URLEncoder.encode(user.getEmail(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie userNameCookie=new Cookie("userName",userName );
		userNameCookie.setPath("/");
		userNameCookie.setMaxAge(31536000);
		response.addCookie(userNameCookie); 
		Cookie userEmailCookie=new Cookie("userEmail", userEmail);
		userEmailCookie.setPath("/");
		userEmailCookie.setMaxAge(31536000);
		response.addCookie(userEmailCookie); 
		//新增代码，注册送小样
		if (ifDemand != null && ifDemand == true) {
			/*
			1、在购物车添加一个商品
			2、提交一个订单				
			*/
			/*String guestID = WebUtils.getGuestID(request,response);
			Cart cart = cartService.getCartByGuestId(guestID, 19);*/
			//此处加地址验证和手机手机验证,调用添加购物车的方法
			demand(request, user, site);
			return view( request, response,  site);
		}else{
			return "redirect:/" + "";
		}

	}
    @RequestMapping(method = RequestMethod.GET)
	public String view(HttpServletRequest request,HttpServletResponse response, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		if(userId == null) {
			request.setAttribute("url", "pay/settleaccount.html");
			WebUtils.putErrorMessage("您需要登录后才能索取", request);
			return WebUtils.themesView(request, currentSite, "user/login");
		}
		/*String guestId = WebUtils.getGuestID(request, response);*/
		
		// 购物车中的物品
		List<Cart> carts = cartService.findCartByUserId(userId);
		// 算总价
		Integer total = PayUtils.total(carts);
		
		// 用户地址
		List<Address> addresses = addressService.findAddressByUserId(userId);
		List<Province> provinces = addressService.findProvinces();
		
		request.setAttribute("provinces", provinces);
		request.setAttribute("orders", carts);
		request.setAttribute("total", total);
		request.setAttribute("addresses", addresses);
		request.setAttribute("ifdemand", "0");
		request.getSession().setAttribute(SessionName.CART_COUNT.toString(), carts.size());
		return WebUtils.themesView(request, currentSite, "pay/settleaccount");
	}
    private void demand(HttpServletRequest request,User user,String site){
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Cart cart = new Cart();
		cart.setCreatedAt(new Date());
		cart.setUpdatedAt(new Date());
		cart.setCreatedBy("");
		cart.setGuestId("");
		cart.setItemId(19);
		Item item = itemService.getItem(19);
		cart.setName(item.getName());
		cart.setPrice(item.getPrice());
		cart.setMarketPrice(item.getMarketPrice());
		cart.setPoint(PointProvider.getSimplePoint(item));
		cart.setUserId((Integer)request.getSession().getAttribute(SessionName.USER_ID.toString()));
		cart.setQty(1);
		cart.setSiteId(currentSite.getId());
		cart.setPurchasingType(PurchasingType.NORMAL.toString());
		cartService.addToCart(cart);
		WebUtils.putSuccessMessage("您索取的小样["+item.getName()+"]已加入您的购物袋", request);
	}
	private void login(User u,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SessionName.USER_EMAIL.toString(), u.getEmail());
		session.setAttribute(SessionName.USER_ID.toString(), u.getId());
		session.setAttribute(SessionName.USER_NAME.toString(), u.getName());
		
	}
}
