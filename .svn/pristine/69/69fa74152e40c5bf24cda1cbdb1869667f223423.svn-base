package com.babailiren.ec.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.PasswordManager;
import com.babailiren.ec.common.Validator;
import com.babailiren.ec.enumeration.PurchasingType;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.Province;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.User;
import com.babailiren.ec.pay.PayUtils;
import com.babailiren.ec.provider.PointProvider;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.service.OrderService;
import com.babailiren.ec.service.UserService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private WebCache webCache;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "modifyUser.html", method = RequestMethod.GET)
	public String modifyUser(HttpServletRequest request, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Integer userId = WebUtils.getUserId(request);
		User user = userService.getUser(userId);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String d = formatter.format(user.getBirthday());
//		request.setAttribute("birth", d);
		//user.setBirthday(DateUtil.getDate("yyyy-MM-dd", formatter.format(user.getBirthday())));
		request.setAttribute("user", user);
		return WebUtils.themesView(request, currentSite, "user/modifyuser");
	}

	@RequestMapping(value = "modifyUser.html", method = RequestMethod.POST)
	public String modifyUser(User u,HttpServletRequest request, String site,
			String oldPassword, String newPassword) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Integer userId = WebUtils.getUserId(request);
		User user = userService.getUser(userId);
		if("".equals(u.getName()) || null == u.getName()){
			WebUtils.putErrorMessage("名字不能为空", request);
			return WebUtils.themesView(request, currentSite, "user/modifyuser");
		}if("".equals(u.getMobile()) || null == u.getMobile()){
			WebUtils.putErrorMessage("联系电话不能为空", request);
			return WebUtils.themesView(request, currentSite, "user/modifyuser");
		}
		if("".equals(u.getBirthday()) || null == u.getBirthday() ){
			WebUtils.putErrorMessage("生日不能为空", request);
			return WebUtils.themesView(request, currentSite, "user/modifyuser");
		}
		if (!"".equals(u.getPassword()) && null != u.getPassword()) {
			if(!user.getPassword().equals(PasswordManager.encode(u.getPassword()))){
				WebUtils.putErrorMessage("密码错误", request);
				return WebUtils.themesView(request, currentSite, "user/modifyuser");
			}
			user.setPassword(PasswordManager.encode(newPassword));
		}
		user.setUpdatedAt(new Date());
		user.setBirthday(u.getBirthday());
		user.setGender(u.getGender().toString());
		user.setName(u.getName());
		user.setMobile(u.getMobile());
		userService.update(user);
		WebUtils.putErrorMessage("修改成功", request);
		return WebUtils.themesView(request, currentSite, "user/modifyuser");
	}

	/**
	 * 用户订单明细
	 * 
	 * @param request
	 * @param site
	 * @param orderNumber
	 * @return
	 */
	@RequestMapping(value = "userOrderDetail.html", method = RequestMethod.GET)
	public String userOrderDetail(HttpServletRequest request, String site,
			String orderNumber) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		List<OrderDetail> orderDetails = orderService
				.findOrderDetailByOrderNumber(orderNumber);
		request.setAttribute("orderDetails", orderDetails);
		return WebUtils.themesView(request, currentSite, "user/orderdetail");
	}

	@RequestMapping(value = "register.html", method = RequestMethod.GET)
	public String register(HttpServletRequest request, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		return WebUtils.themesView(request, currentSite, "user/register");
	}

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public String register(Boolean ifDemand,User user, String site, HttpServletRequest request,
			HttpServletResponse response) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(user.getName(), "请填写用户名")
				.isNotBlankValidator(user.getEmail(), "请填写邮箱地址")
				.emailValidator(user.getEmail(), "请填写正确的邮箱地址")
				.expressionValidator(userService.existsUser(user.getEmail()),
						"该E-Mail地址已注册");

		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		if (validator.isValid()) {
			user.setUsername(user.getEmail());
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			user.setSiteId(currentSite.getId());
			user.setIfdemand(0);
			userService.add(user);
			login(user,request);
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
				return "redirect:regfinished.html";
			}
		} else {
			WebUtils.putErrorMessage(validator.renderHtmlMessage(), request);
			return WebUtils.themesView(request, currentSite, "user/register");
		}
	}
	/**
	 * 索取小票
	 * @param ifDemand
	 * @param user
	 * @param site
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "demandnote.html", method = RequestMethod.GET)
	public String demandnote(String site, HttpServletRequest request,
			HttpServletResponse response) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Integer userId = WebUtils.getUserId(request);
		User user = userService.getUser(userId);
		if (user.getIfdemand() != null && user.getIfdemand() == 0) {
			demand(request, user, site);
			//ifdemand为1已经索取，0为没有索取
			return view( request, response,  site);
		} else {
			WebUtils.putErrorMessage("您已经索取过小样了", request);
			return WebUtils.themesView(request, currentSite, "");
		}
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
		Item item = itemService.getItem(47);
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
	
	@RequestMapping(value = "regfinished.html", method = RequestMethod.GET)
	public String regfinished(String site, HttpServletRequest request,
			HttpServletResponse response) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		return WebUtils.themesView(request, currentSite, "user/regfinished");
	}
	
	
	@RequestMapping(value = "ajax/email", method = RequestMethod.GET)
	@ResponseBody
	public String email(String email) {
		// 存在相同EMAIL不允许注册
		return String.valueOf(!userService.existsUser(email));
	}

	@RequestMapping(value = "ajax/captcha", method = RequestMethod.GET)
	@ResponseBody
	public String captcha(String captcha, HttpServletRequest request) {
		// String valueOf =
		// String.valueOf(SimpleImageCaptchaServlet.service.validateResponseForID(request.getSession().getId(),
		// captcha));
		String valueOf = String.valueOf((captcha
				.equalsIgnoreCase((String) request.getSession().getAttribute(
						SessionName.VERIFYCODE.toString()))));
		return valueOf;
	}

	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, String site, String email) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		request.setAttribute("email", email);
		return WebUtils.themesView(request, currentSite, "user/login");
	}

	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String site, User user, String url) {
		User u = userService.vailUser(user.getEmail(), user.getPassword());
		if (u != null) {
			// 登錄
			login(u,request);
			
			if (site == null) {
				site = "";
			}
			
			if(url != null && !"".equals(url)) {
				return "redirect:/" + url;
			}
			
			return "redirect:/" + site;
		} else {
			WebUtils.putErrorMessage("电子邮箱或密码错误。", request);
			return login(request, site, user.getEmail());
		}

	}

	private void login(User u,HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.setAttribute(SessionName.USER_EMAIL.toString(), u.getEmail());
		session.setAttribute(SessionName.USER_ID.toString(), u.getId());
		session.setAttribute(SessionName.USER_NAME.toString(), u.getName());
		session.setAttribute(SessionName.IF_DEMAND.toString(), u.getIfdemand());
		
	}
	
	
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, String site) {

		request.getSession().invalidate();
		if (site == null) {
			site = "";
		}
		return "redirect:/" + site;
	}

	@RequestMapping(value = "forget.html", method = RequestMethod.GET)
	public String forgetPassword(HttpServletRequest request, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		return WebUtils.themesView(request, currentSite, "user/forget");
	}

	@RequestMapping(value = "forget.html", method = RequestMethod.POST)
	public @ResponseBody
	String forgetPassword(String username, HttpServletRequest request) {
		if(userService.existsUser(username)) {
			SimpleMailMessage mail = new SimpleMailMessage();  
			User user = userService.getUserByMail(username);
	        mail.setFrom("babailiren@126.com");
	        mail.setTo(username);
	        mail.setSubject("个人用户寻找密码通知");  
	        mail.setText("用户的密码是:" + PasswordManager.decode(user.getPassword()));  
	        mailSender.send(mail);
	        return "邮件已发送请查收.";
		} else {
			return "用户不存在.";
		}
	}
	
	@RequestMapping(value = "imgList.html", method = RequestMethod.GET)

	public String imgList(HttpServletRequest request, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/jsp/themes/"+currentSite.getTemplate().getPath()+"/images");
		System.out.println(path);
		File dir = new File(path);
		String html = "";
		
		for(File f : dir.listFiles()) {
			html += "<img src='"+request.getContextPath()+"/themes/default/images/"+f.getName()+"'/>";
			
		}
		request.setAttribute("html", html);
		System.out.println(html);
		return "html";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}


}