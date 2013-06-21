package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Cart;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;


@Repository
@EntityDao(Table = "carts")
public class CartDao extends JdbcEntityDao<Cart, Long>{
	
	/**
	 * 获取购物车中的所有的物品
	 * @param guestId
	 * @param userId
	 * @return List
	 */
	public List<Cart> findCartByGuestIdOrUserId(String guestId, Integer userId) {
		String sql = " select * from carts where guest_id = ? or user_id = ? ";
		return find(sql, guestId, userId);
	}
	
	public List<Cart> findCartByGuestId(String guestId) {
		String sql = "SELECT * FROM carts WHERE guest_id = ?";
		return find(sql, guestId);
	}
	
	public Cart getCartByGuestId(String guestId,Integer itemId) {
		String sql = "SELECT * FROM carts WHERE guest_id = ? AND item_id = ?";
		return get(sql, guestId,itemId);
	}
	
	public List<Cart> findCartByUserId(Integer userId) {
		String sql = "SELECT * FROM carts WHERE user_id = ?";
		return find(sql, userId);
	}
	
	public int[] updateCart(Cart cart) {
		String sql = "UPDATE carts SET price = :price , " +
				"qty = :qty , updated_at = :updatedAt WHERE id = :id";
		return this.update(sql, new Cart[] {cart});
	}
	
	public void delete(String guestId,Integer itemId) {
		String sql = "DELETE FROM carts WHERE guest_id = '"+guestId+"' AND item_id = "+itemId;
		this.execute(sql);
	}
	
	public void delete(Integer userId,Integer itemId) {
		String sql = "DELETE FROM carts WHERE user_id = "+userId+" AND item_id = "+itemId;
		this.execute(sql);
	}
	public void updateCart(Integer userId,String guestId) {
		String sql = "UPDATE carts SET user_id = "+userId+" WHERE guest_id = '"+guestId+"'";
		this.execute(sql);
	}
	
	public void delCart(Integer userId, Integer siteId) {
		String sql = " delete from carts where user_id = " + userId + " and site_id = '"+ siteId + "'";
		this.execute(sql);
	}
	
}
