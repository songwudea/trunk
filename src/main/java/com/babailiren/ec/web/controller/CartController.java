package com.babailiren.ec.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.enumeration.PurchasingType;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.provider.PointProvider;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/cart")
public class CartController {


	@Autowired
	private WebCache webCache;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String view(HttpServletRequest request,HttpServletResponse response, String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		List<Cart> cartList = Lists.newArrayList();
		String guestID = WebUtils.getGuestID(request,response);
		if(userId == null) {
			cartList = cartService.findCartByGuestId(guestID);
		} else {
			cartService.updateCart(userId,guestID);
			cartList = cartService.findCartByUserId(userId);
		}
		Integer sum = 0;
		for(Cart cart : cartList) {
			sum += cart.getAmount();
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("sum", sum);
		return WebUtils.themesView(request, currentSite, "cart/view");
		
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,HttpServletResponse response, String site,Integer itemId,Integer qty,String purchasingType) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		String guestID = WebUtils.getGuestID(request,response);
		Cart cart = cartService.getCartByGuestId(guestID, itemId);
		if(cart == null) {
			cart = new Cart();
			cart.setCreatedAt(new Date());
			cart.setUpdatedAt(new Date());
			cart.setCreatedBy(guestID);
			cart.setGuestId(guestID);
			cart.setItemId(itemId);
			Item item = itemService.getItem(itemId);
			cart.setName(item.getName());
			cart.setPrice(item.getPrice());
			cart.setMarketPrice(item.getMarketPrice());
			cart.setPoint(PointProvider.getSimplePoint(item));
			cart.setUserId((Integer)request.getSession().getAttribute(SessionName.USER_ID.toString()));
			cart.setQty(qty);
			cart.setSiteId(currentSite.getId());
			cart.setPurchasingType(PurchasingType.NORMAL.toString());
			cartService.addToCart(cart);
			WebUtils.putSuccessMessage(item.getName()+"已加入您的购物袋", request);
		} else {
			cart.setUpdatedAt(new Date());
			cart.setQty(qty + cart.getQty());
			cartService.updateCart(cart);
			WebUtils.putSuccessMessage("您购物袋中的"+cart.getName()+"已增加"+qty+"件", request);
		}

		count(request,response,site);
		return view( request, response,  site);
	}
	

	@RequestMapping(value = "del", method = RequestMethod.GET)
	public String del(HttpServletRequest request,HttpServletResponse response, String site,Integer itemId) {
		//Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		String guestID = WebUtils.getGuestID(request,response);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		
		Item item = itemService.getItem(itemId);

		cartService.deleteCart(guestID,itemId);
		if(userId != null) {
			cartService.deleteCart(userId,itemId);
		}
		WebUtils.putSuccessMessage(item.getName()+"已从您的购物袋中取出", request);
		count(request,response,site);
		
		return view( request, response,  site);
	}
	
	
	private void count(HttpServletRequest request,HttpServletResponse response, String site) {
		//Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		List<Cart> cartList = Lists.newArrayList();
		String guestID = WebUtils.getGuestID(request,response);
		if(userId == null) {
			cartList = cartService.findCartByGuestId(guestID);
		} else {
			cartService.updateCart(userId,guestID);
			cartList = cartService.findCartByUserId(userId);
		}
		request.getSession().setAttribute(SessionName.CART_COUNT.toString(), cartList.size());
		
	}
	
	
	
	@RequestMapping(value = "ajax/qty", method = RequestMethod.POST)
	@ResponseBody
	public String minus(HttpServletRequest request,HttpServletResponse response, String site,Integer itemId,Integer qty) {
		String guestID = WebUtils.getGuestID(request,response);
		Cart c = cartService.getCartByGuestId(guestID, itemId);
		updateQty(c,qty);
		Integer amount = c.getAmount();

		List<Cart> cartList = cartService.findCartByGuestId(guestID);
		Integer sum = 0;
		for(Cart cart : cartList) {
			sum += cart.getAmount();
		}

		return "{qty: '"+qty+"',amount: '"+amount/100+"', sum: '"+sum/100+"'}";
	}
	
	
	private void updateQty(Cart cart,Integer qty) {
		cart.setQty(qty);
		cartService.updateCart(cart);
	}
	
	
	
}
