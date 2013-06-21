package com.babailiren.ec.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
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
import com.babailiren.thirdpart.alipay.util.AlipayNotify;
import com.babailiren.thirdpart.qq.config.QqConfig;
import com.babailiren.thirdpart.qq.service.QqService;
import com.babailiren.thirdpart.qq.vo.QqInfoOpenIdVo;
import com.babailiren.thirdpart.qq.vo.QqUserInfoVo;
import com.babailiren.thirdpart.sina.service.SinaService;
import com.babailiren.thirdpart.sina.service.util.MySecureProtocolSocketFactory;
import com.babailiren.thirdpart.sina.vo.SinaInfoTokenVo;
import com.babailiren.thirdpart.sina.vo.SinaUserInfoVo;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.google.gson.Gson;


@Controller
@RequestMapping("/tp")
public class ThirdpartLoginController {

	
	@Autowired
	private WebCache webCache;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private AddressService addressService;
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
		String sHtmlText="";
		if ("sina".equals(pathBuild)) {
			String code="code";
			sHtmlText = SinaService.get_sina_login(code);
			request.setAttribute("html", sHtmlText);
			return WebUtils.themesView(request, currentSite, "thirdpart/outHtmlUrl");
		}else if("alipay".equals(pathBuild)){
			String anti_phishing_key  = "";
			String exter_invoke_ip= "";
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
	        sParaTemp.put("anti_phishing_key", anti_phishing_key);
	        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
			//构造函数，生成请求URL
			 sHtmlText = AlipayService.alipay_auth_authorize(sParaTemp);
			request.setAttribute("html", sHtmlText);
			return WebUtils.themesView(request, currentSite, "thirdpart/outHtmlUrl");
		}else if("qq".equals(pathBuild)){
			//生成请求URL
			 sHtmlText = QqService.get_user_info();
			request.setAttribute("html", sHtmlText);
			return WebUtils.themesView(request, currentSite, "thirdpart/outHtmlUrl");
		}
		return "";
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
    @RequestMapping(value = "return_url.html", method = RequestMethod.GET)
    public  String return_url(Map<String, String> sParaTemp, String gateway, String strMethod,
                                   String strButtonName,HttpServletRequest request, String site
                                  ) {
    	Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
    	Map requestParams = request.getParameterMap();
    	Map<String, String> sPara = AlipayService.bulidMap(requestParams); 
    	User userQq = userService.vailUserByOpenId(sPara.get("user_id"));
        if (userQq != null && !"".equals(userQq.getEmail()) && !"".equals(userQq.getName())) {
			login(userQq,request);
			return "redirect:/" + "";
		}else{
			String actionUrl=buildReturn(request, site,requestParams);
			if("".equals(actionUrl))
				return "redirect:/" + "";
			else
				return WebUtils.themesView(request, currentSite, actionUrl);
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
    private  String buildReturn(HttpServletRequest request,String site,Map requestParams) {
    	Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
    	Map<String,String> params = new HashMap<String,String>();
    	params=AlipayService.bulidMap(requestParams); 	
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
	    		User user=new User();
	    		user.setUsername(email);
	    		user.setEmail(email);
	    		user.setName(user_id);
				user.setCreatedAt(new Date());
				user.setUpdatedAt(new Date());
				user.setSiteId(currentSite.getId());
				user.setPassword("");
				user.setUserSource(OpenAuth.ALIPAY.toString());
				userService.add(user);
				return "";
			}else{
				request.getSession().setAttribute("userName", params.get("real_name"));
				request.getSession().setAttribute("userReturn", params);
				request.getSession().setAttribute("bianPage", "alipayBindLogin");
				//跳到账号绑定的页面s\
			//System.out.println("绑定页面");
				request.setAttribute("source", "支付宝");
				return  "thirdpart/bindInfo";
			}
    	}else{
    		WebUtils.putErrorMessage("登录失败，请重新登录。", request);
    		return "user/login";
    	}
    }
    
    /**
     * 支付宝用户登录账号绑定
     * @param request
     * @param site
     * @param user
     * @return
     */
    @RequestMapping(value = "alipayBindLogin.html", method = RequestMethod.POST)
	public String alipayBindLogin(HttpServletRequest request,HttpServletResponse response, String site,String email,String password,Boolean ifDemand) {
    	Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
    	Map<String,String> params = (Map<String, String>) request.getSession().getAttribute("userReturn");
    	User user= new User();
		user.setUsername(email);
		user.setEmail(email);
		user.setName(params.get("real_name"));
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setSiteId(currentSite.getId());
		user.setPassword(password);
		user.setUserSource(OpenAuth.ALIPAY.toString());
		user.setUsername("alipay_"+params.get("real_name"));
		//
		user.setOpenId(params.get("user_id"));
		user.setIfdemand(0);
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
    

    

    /**
     * 新浪微博用户授权成功后拿到access_token
     * @param request
     * @param site
     * @param user
     * @return
     */
    @RequestMapping(value = "sinaLoginAccessToken.html", method = RequestMethod.GET)
	public String sinaLoginAccessToken(HttpServletRequest request,HttpServletResponse response, String site,String code) {
			Site currentSite = webCache.getSiteByDomain(request.getSession()
					.getServletContext(), site);
			String url=SinaService.get_sina_token(code);
			String content = httpClient(url,"post");
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
				String infoUrl=SinaService.get_sina_user_info(access_token, sinaUid);
				String contentAll=httpClient(infoUrl,"get");
				String contentAllInfo = contentAll.replaceAll(",\"source.*", "")+"}}";
				SinaUserInfoVo infoVo=gson.fromJson(contentAllInfo, SinaUserInfoVo.class);
				request.getSession().setAttribute("userName", infoVo.getScreen_name());
				request.getSession().setAttribute("userReturn", infoVo);
				request.getSession().setAttribute("bianPage", "sinaLoginRegist");
				request.setAttribute("source", "sina");
				return WebUtils.themesView(request, currentSite, "thirdpart/bindInfo");
			}
	}
    /**
     * sina用户登录设置账号
     */
    @RequestMapping(value = "sinaLoginRegist.html", method = RequestMethod.POST)
	public String sinaLoginRegist(HttpServletRequest request, HttpServletResponse response, String site, String email,String password,Boolean ifDemand) {
			Site currentSite = webCache.getSiteByDomain(request.getSession()
					.getServletContext(), site);
			SinaUserInfoVo infoTokenVo=(SinaUserInfoVo) request.getSession().getAttribute("userReturn");
			User user= new User();
			user.setUsername(email);
			user.setEmail(email);
			user.setName(infoTokenVo.getScreen_name());
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			user.setSiteId(currentSite.getId());
			user.setPassword(password);
			user.setUsername("sina_"+infoTokenVo.getScreen_name());
			user.setUserSource(OpenAuth.SINA_WEIBO.toString());
			//
			user.setOpenId(infoTokenVo.getId());
			user.setIfdemand(0);
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

    
    /**
     * 腾讯qq用户登录后回调
     * @param request
     * @param site
     * @param user
     * @return
     */
    @RequestMapping(value = "qqReturn.html", method = RequestMethod.GET)
	public String qqReturn(HttpServletRequest request,HttpServletResponse response, String site, User user,String code,String state) {
			Site currentSite = webCache.getSiteByDomain(request.getSession()
					.getServletContext(), site);
			//在这里判断回传的state参数是否正确，MD5加密
			if (state.equals(QqConfig.state)) {
				//生成表单的请求数据
				String action_url = QqService.get_user_info_Access_Token(code);
				//在这里使用HttpClient访问页面
				String content = httpClient(action_url,"get");
				//拿到access_token
				String access_token = content.substring(0,content.indexOf("&"));
				qqReturnToken(request, response, site, access_token);				
				///从数据库检索，从cookie里面拿到的只是最后一个qq号码的信息，通过openid来检索  
				User userQq = userService.vailUserByOpenId(request.getSession().getAttribute("openId").toString());
				//如果不为空，就直接进行登录
				if (userQq != null && !"".equals(userQq.getEmail()) && !"".equals(userQq.getName())) {
					login(userQq,request);
					return "redirect:/" + "";
				}
				/*拿到cookie里面的值
				String userEmail="";
				String userName="";
				Cookie[] qqCookie=request.getCookies();
				if(qqCookie.length!=0){
				   for(int i=0;i<qqCookie.length;i++){
				      if(qqCookie[i].getName().equalsIgnoreCase("userEmail")){
				    	   try {
							userEmail=URLDecoder.decode(qqCookie[i].getValue().toString(),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}  ;
				      }

				      if(qqCookie[i].getName().equalsIgnoreCase("userName")){
				    	   try {
							userName=URLDecoder.decode(qqCookie[i].getValue().toString(),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
				      }
				   }
				}*/
//				if (!"".equals(userEmail) && !"".equals(userName)) {
//					return WebUtils.themesView(request, currentSite, "user/login");
//				}
				else{
					request.setAttribute("source", "QQ");
					return WebUtils.themesView(request, currentSite, "thirdpart/bindInfo");
				}
			}else{
				WebUtils.putErrorMessage("参数错误，登录失败，请重新登录。", request);
	    		return WebUtils.themesView(request, currentSite, "user/login");
			}

	}
    
    /**
     * 腾讯qq用户登录后回调,拿到OPENID
     * @param request
     * @param site
     * @param user
     * @return
     */

	private void qqReturnToken(HttpServletRequest request,HttpServletResponse response, String site,String access_token) {
			Site currentSite = webCache.getSiteByDomain(request.getSession()
					.getServletContext(), site);
			//拿到传回来的access_token信息，保存到cookie
			if (!"".equals(access_token)) {
				//生成表单的请求数据
				Cookie qqCokie=new Cookie("access_token", access_token);
				qqCokie.setPath("/");
				qqCokie.setMaxAge(31536000);
				response.addCookie(qqCokie); 
				//生成表单的请求数据
				String action_url=QqService.get_user_info_OpenID(access_token);
				//在这里使用HttpClient访问页面
				String content = httpClient(action_url,"get");
				String jsonContent=StringUtils.substringBetween(content, "(",")");
				Gson gson = new Gson();
				QqInfoOpenIdVo fromJson = gson.fromJson(jsonContent, QqInfoOpenIdVo.class);
				//得到OPENid
				String openId=fromJson.getOpenid();
				//生成url返回qq的用户信息
				String action_info_url=QqService.get_user_info_all(access_token,openId);
				String contentAll = httpClient(action_info_url,"get");
//			System.out.println(contentAll);
				//将返回的数据保存
				QqUserInfoVo qqUserInfoVo=gson.fromJson(contentAll, QqUserInfoVo.class);
					request.getSession().setAttribute("userReturn", qqUserInfoVo);
					request.getSession().setAttribute("userName", qqUserInfoVo.getNickname());
				request.getSession().setAttribute("bianPage","qqLoginRegist");
				request.getSession().setAttribute("openId", openId);
				//将信息写入数据库，进行注册
			}else{
				WebUtils.putErrorMessage("参数错误，登录失败，请重新登录。", request);
			}

	}
    /**
     * 腾讯qq用户登录设置账号
     * @param request
     * @param site
     * @param user
     * @return
     */
    @RequestMapping(value = "qqLoginRegist.html", method = RequestMethod.POST)
	public String qqLoginRegist(HttpServletRequest request, HttpServletResponse response, String site, String email,String password,Boolean ifDemand) {
			Site currentSite = webCache.getSiteByDomain(request.getSession()
					.getServletContext(), site);
			User user= new User();
			user.setUsername(email);
			user.setEmail(email);
			QqUserInfoVo infoVo=(QqUserInfoVo) request.getSession().getAttribute("userReturn");
			user.setName(infoVo.getNickname());
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			user.setSiteId(currentSite.getId());
			user.setPassword(password);
			user.setUserSource(OpenAuth.QQ.toString());
			user.setUsername("qq_"+infoVo.getNickname());
			//
			user.setOpenId(request.getSession().getAttribute("openId").toString());
			user.setIfdemand(0);
			userService.add(user);
			login(user,request);
			//将信息保存到cookie里面，下次登录的时候就不需要进行绑定了
			String userName="";
			String userEmail="";
			try {
				userName = URLEncoder.encode(user.getName(),"UTF-8");
				userEmail=URLEncoder.encode(user.getEmail(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
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
    
    
/*    private static String getResponseContent(String action_url,String methodFailed){
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
    }*/
    
    
    
    private static String httpClient(String action_url,String methodFailed){
    	String str="";
		//构造HttpClient的实例   
    	ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
		 Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
	     HttpClient httpClient = new HttpClient();   
	     //设置 Http 连接超时为20秒   
	     httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);   
	    //创建GET方法的实例   
	    String url =   action_url; 
	    if("post".equals(methodFailed)){
		   PostMethod postMethod = new PostMethod(url);
   		//设置 get 请求超时为 20秒   
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
    
	private void login(User u,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SessionName.USER_EMAIL.toString(), u.getEmail());
		session.setAttribute(SessionName.USER_ID.toString(), u.getId());
		session.setAttribute(SessionName.USER_NAME.toString(), u.getName());
		session.setAttribute(SessionName.IF_DEMAND.toString(), u.getIfdemand());
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
	
}
