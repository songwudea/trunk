package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Item;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;
import com.google.common.collect.Lists;

@Repository
@EntityDao(Table = "items")
public class ItemDao extends JdbcEntityDao<Item, Integer> {
	
	public List<Item> findUrlRewriteItem() {
		
		return find("SELECT * FROM items WHERE url_rewrite <> ''");
	}
	
	public List<Item> findItemByCategoryId(Integer categoryId) {
		
		return find("SELECT * FROM items WHERE category_id = ? AND published = 1 ORDER BY sort DESC",categoryId);
	}
	
	
	
	public Page<Item> findItemPage(Page<Item> page, Item item) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select items.*,categories.name as categoryName  from items ");
		sb.append(" left join categories on items.category_id = categories.id ");
		sb.append(" where 1 = 1 ");
		List<Object> list = Lists.newArrayList(); 
		
		if(item.getName() != null && !"".equals(item.getName())) {
			sb.append(" and items.name = ? ");
			list.add(item.getName());
		}
		
		if(item.getCategoryId() != null && !"".equals(item.getCategoryId()) && !"all".equals(item.getCategoryId())) {
			sb.append(" and categories.id = ? ");
			list.add(item.getCategoryId());
		}
		
		if(item.getStartcreatedAt() != null && !"".equals(item.getStartcreatedAt()) && item.getEndcreatedAt() != null && !"".equals(item.getEndcreatedAt())) {
			sb.append(" and items.created_at >= ? ");
			list.add(item.getStartcreatedAt());
			sb.append(" and items.created_at <= ? ");
			list.add(item.getEndcreatedAt());
		}
		
		page = findPage(page, sb.toString(),list.toArray());
		return page;
	}
	
	public void updateItemImages(Item item, String images) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update items ");
		sb.append(" set images = ? ");
		sb.append(" where id = ? ");
		this.getJdbcTemplate().update(sb.toString(), images, item.getId());
	}
	
}
