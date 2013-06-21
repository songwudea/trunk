package com.babailiren.ec.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.UploadPic;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.ItemDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	
	public List<Item> findUrlRewriteItem() {
		
		return itemDao.findUrlRewriteItem();
	}
	
	
	public void updateItemImages(Item item, String images) {
		itemDao.updateItemImages(item, images);
	}
	
	public List<Item> findItemByCategoryId(Integer categoryId) {
		
		return itemDao.findItemByCategoryId(categoryId);
	}
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}
	
	public List<UploadPic> getItemPicArr(Item item) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		List<UploadPic> list = gson.fromJson("[" + item.getImages() + "]", new TypeToken<List<UploadPic>>(){}.getType());	
		return list;
	}
	
	public Item calPriceDiv(Item item) {
		item.setCcost(Double.valueOf(item.getCost() / 100));
		item.setCprice(Double.valueOf(item.getPrice() / 100));
		item.setCmarketPrice(Double.valueOf(item.getMarketPrice() / 100));
		return item;
	}
	
	/**
	 * 计算价格 写入数据库时候 * 100
	 * @param item
	 * @return Item
	 */
	public Item calcPriceMulti(Item item) {
		item.setCost((int)(item.getCcost() * 100));
		item.setPrice((int)(item.getCprice() * 100));
		item.setMarketPrice((int)(item.getCmarketPrice() * 100));
		return item;
	}
	
	@Cacheable(value= "item", key="'item_p' + #id")  
	public Item getItem(Integer id) {
		return itemDao.getByPK(id);
	}
	
	public Page<Item> list(Page<Item> page, Item item) {

		Page<Item> findItemPage = itemDao.findItemPage(page, item);
		List<Item> result = findItemPage.getResult();
		Gson gson = new Gson();
		for(Item it : result) {
			if(StringUtils.isNotEmpty(it.getImages())) {
				List<UploadPic> picList= gson.fromJson("["+it.getImages()+"]", new TypeToken<List<UploadPic>>() {}.getType());
				it.setItemImage(picList);
			} 
		}


		return findItemPage;
	}
	
	public List<Item> findByPK(Integer[] pk) {
		return itemDao.findByPK(pk);
	}
	
	public Item save(Item entity) {
		return itemDao.add(entity);
	}
	
	@CacheEvict(value="item",key="'item_p' + #entity.id")  
	public void update(Item entity) {
		Item[]entities = {entity};
		itemDao.update(entities);
	}
	
	
}
