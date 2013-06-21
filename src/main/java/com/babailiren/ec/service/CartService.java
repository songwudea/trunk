package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Cart;
import com.babailiren.ec.repository.dao.CartDao;


@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public List<Cart> findAll(Integer userId, String guestId) {
		return cartDao.findCartByGuestIdOrUserId(guestId, userId);
	}
	
	public void addToCart(Cart cart) {
		cartDao.add(cart);
	}
	
	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}
	
	public void deleteFromCart(Integer userId, Integer siteId) {
		cartDao.delCart(userId, siteId);
	}
	
	public void deleteCart(Integer userId,Integer itemId) {
		cartDao.delete(userId,itemId);
	}
	public void deleteCart(String guestId,Integer itemId) {
		cartDao.delete(guestId,itemId);
	}
	
	public Cart getCartByGuestId(String guestId,Integer itemId) {
		return cartDao.getCartByGuestId(guestId, itemId);
	}
	
	public List<Cart> findCartByGuestId(String guestId) {
		return cartDao.findCartByGuestId(guestId);
	}
	
	public List<Cart> findCartByUserId(Integer userId) {
		return cartDao.findCartByUserId(userId);
	}
	
	public void updateCart(Integer userId,String guestId) {
		cartDao.updateCart(userId,guestId);
	}
}
