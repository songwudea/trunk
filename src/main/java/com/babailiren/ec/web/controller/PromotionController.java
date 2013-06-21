package com.babailiren.ec.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.Promotion;
import com.babailiren.ec.model.PromotionDetails;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.PromotionDetailService;
import com.babailiren.ec.service.PromotionService;
import com.babailiren.ec.web.common.WebUtils;

@Controller
@RequestMapping("/admin/promotion")
public class PromotionController {

	@Autowired
	private CartService cartService;

	@Autowired
	private PromotionService promotionService;

	@Autowired
	private PromotionDetailService promotionDetailService;

	/**
	 * 促销规则
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String addCart(HttpServletRequest request,
			HttpServletResponse response) {
//		String guestId = WebUtils.getGuestID(request, response);
//		int promotinids = 0;
//		Promotion promotions = promotionService.getPromotionsById(itemId);
//		if (promotions != null) {
//			promotinids = promotions.getId();
//		}
//
//		// for (PromotionDetails promotionDetails : promotion) {
//		// String names = promotionDetails.getPromotionName();
//		// }
//		Cart carts = cartService.getCartByGuestId(guestId, itemId);// 获取未登陆时购物车的商品
//		if (carts == null) {
//			List<PromotionDetails> promotion = promotionDetailService
//					.getPromotionDetailsById(promotinids);
//			Cart cart = new Cart();
//			cart.setCreatedAt(new Date());
//			cart.setUpdatedAt(new Date());
//			cart.setCreatedBy(guestId);
//			cart.setPrice(promotions.getReducePrice());
//			// cart.setGuestId(guestId);
//			cart.setItemId(itemId);
//			cart.setName(promotion.get(0).getPromotionName());
//			cartService.addToCart(cart);
//		}
		return "admin/promotion/add";
	}

}
