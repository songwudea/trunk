package com.babailiren.ec.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.xml.serializer.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.CacheName;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.ItemAttribute;
import com.babailiren.ec.model.ItemCustomerAttribute;
import com.babailiren.ec.model.UploadPic;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.CategoryAttributeService;
import com.babailiren.ec.service.CategoryService;
import com.babailiren.ec.service.ItemAttributeService;
import com.babailiren.ec.service.ItemCustomerAttributeService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.AjaxVO;
import com.babailiren.ec.web.vo.AttrJson;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryAttributeService categoryAttributeService;

	@Autowired
	private ItemAttributeService itemAttributeService;

	@Autowired
	private WebCache webCache;

	@Autowired
	private ItemCustomerAttributeService itemCustomerAttributeService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		List<Category>  categories = Lists.newArrayList();
		categories = categoryService.fullCategory();
		request.setAttribute("categories", categories);
		return "admin/item/index";
	}
	
	@RequestMapping(value = "shelves.html", method = RequestMethod.POST)
	public @ResponseBody 
	String shelves(Integer id) {
		AjaxVO ajax = new AjaxVO();
		Gson gson = new Gson();
		try {
			Item item = itemService.getItem(id);
			if(item.isPublished() == true) {
				ajax.setResult("suss");
				ajax.setMessage("商品已经上架。");
			} else {
				item.setPublished(true);
				itemService.update(item);
				ajax.setResult("suss");
				ajax.setMessage("商品已经上架成功。");
			}
			return gson.toJson(ajax);
		} catch(Exception e) {
			ajax.setResult("fail");
			ajax.setMessage("商品上架失败。");
			return gson.toJson(ajax);
		}
	}
	
	/**
	 * 删除商品图片
	 * @param itemId
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "deleteItemPic.html", method = RequestMethod.POST)
	public @ResponseBody 
	String deleteItemPic(Integer itemId, String picName) {
		Item item = itemService.getItem(itemId);
		List<UploadPic> oldUploadPics = itemService.getItemPicArr(item);
		List<UploadPic> newUploadPics = new ArrayList<UploadPic>();
		for(int i = 0;i < oldUploadPics.size(); i++) {
			UploadPic uploadPic = oldUploadPics.get(i);
			if(!picName.equals(uploadPic.getUrl())) {
				newUploadPics.add(uploadPic);
			}
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(newUploadPics);
		json = json.substring(1,json.length() - 1);
		itemService.updateItemImages(item, json);
		return json;
	}

	@RequestMapping(value = "deleteItemAttr.html", method = RequestMethod.POST)
	public @ResponseBody
	String deleteItemAttr(Integer itemId, String key) {
		try {
			itemAttributeService.delete(itemId, key);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	@RequestMapping(value = "itemattr.html", method = RequestMethod.POST)
	public String itemAttr(Integer itemId, String[] attr_name_list,
			String[] attr_value_list, HttpServletRequest request) {
		for (int i = 0; i < attr_name_list.length; i++) {
			String attrName = attr_name_list[i];
			String attrValue = attr_value_list[i];

			// 获取属性看更新还是插入
			ItemAttribute itemAttribute = itemAttributeService
					.getItemAttribute(itemId, attrName);
			if (itemAttribute == null) {
				if (StringUtils.isNotEmpty(attrValue)) {
					itemAttribute = new ItemAttribute();
					itemAttribute.setAttrName(attrName);
					itemAttribute.setAttrValue(attrValue);
					itemAttribute.setItemId(itemId);
					itemAttribute.setCreatedAt(new Date());
					itemAttribute.setUpdatedAt(new Date());
					itemAttributeService.save(itemAttribute);
				}
				request.setAttribute("message", "商品属性设置成功");
			} else {
				itemAttribute.setAttrValue(attrValue);
				itemAttribute.setUpdatedAt(new Date());
				itemAttributeService.update(itemAttribute);
				request.setAttribute("message", "商品属性设置成功");
			}
		}
		Item item = new Item();
		item.setId(itemId);
		return doItemAttr(item, request);
	}

	@RequestMapping(value = "itemCustomerAttr.html", method = RequestMethod.POST)
	public String itemCustomerAttr(Integer itemId, String[] attrKeyList,
			String[] attrValueList, HttpServletRequest request) {
		itemCustomerAttributeService.deleteByItemId(itemId);
		if (attrKeyList != null && attrKeyList.length > 0) {
			List<ItemCustomerAttribute> list = new ArrayList<ItemCustomerAttribute>();
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			for (int i = 0; i < attrKeyList.length; i++) {
				String key = attrKeyList[i];
				String value = attrValueList[i];

				if (map.containsKey(key)) {
					map.get(key).add(value);
				} else {
					List<String> values = new ArrayList<String>();
					values.add(value);
					map.put(key, values);
				}
			}

			for (String key : map.keySet()) {
				ItemCustomerAttribute itemCustomerAttribute = new ItemCustomerAttribute();
				List<String> values = map.get(key);
				Gson gson = new GsonBuilder().serializeNulls().create();
				String value = gson.toJson(values);
				itemCustomerAttribute.setItemId(itemId);
				itemCustomerAttribute.setCreatedAt(new Date());
				itemCustomerAttribute.setUpdatedAt(new Date());
				itemCustomerAttribute.setAttrName(key);
				itemCustomerAttribute.setAttrValue(value);
				list.add(itemCustomerAttribute);
			}
			itemCustomerAttributeService.addAll(list
					.toArray(new ItemCustomerAttribute[0]));
			request.setAttribute("message", "商品附加属性设置成功.");
		}
		return itemCustomerAttr(itemId, request);
	}

	@RequestMapping(value = "itemCustomerAttr.html", method = RequestMethod.GET)
	public String itemCustomerAttr(Integer itemId, HttpServletRequest request) {
		List<ItemCustomerAttribute> itemCustomerAttributes = itemCustomerAttributeService
				.findItemCustomerAttributes(itemId);
		List<String> keys = new ArrayList<String>();
		List<String> values = new ArrayList<String>();

		for (int i = 0; i < itemCustomerAttributes.size(); i++) {
			ItemCustomerAttribute itemCustomerAttribute = itemCustomerAttributes
					.get(i);
			keys.add(itemCustomerAttribute.getAttrName());
			values.add(itemCustomerAttribute.getAttrValue());
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		request.setAttribute("keys", gson.toJson(keys));
		request.setAttribute("values", gson.toJson(values));
		request.setAttribute("itemId", itemId);
		return "admin/item/customerattr";
	}

	@RequestMapping(value = "doItemAttr.html", method = RequestMethod.GET)
	public String doItemAttr(Item item, HttpServletRequest request) {
		item = itemService.getItem(item.getId());

		// 分类的属性
		List<CategoryAttribute> categoryAttributes = categoryAttributeService
				.findCategoryAttributeByCidExtend(item.getCategoryId());
		// 商品的属性
		Map<String, String> itemAttributesMap = itemAttributeService
				.findItemAttributesMap(item.getId());
		Map<String, CategoryAttribute> categoryAttributeByCidExtendMap = categoryAttributeService
				.findCategoryAttributeByCidExtendMap(item.getCategoryId());

		if (itemAttributesMap == null || itemAttributesMap.size() == 0) {
			List<AttrJson> list = new ArrayList<AttrJson>();
			for (int i = 0; i < categoryAttributes.size(); i++) {
				AttrJson attrJson = new AttrJson();
				CategoryAttribute categoryAttribute = categoryAttributes.get(i);
				attrJson.setAttr(categoryAttribute.getName());
				attrJson.setAttrType(categoryAttribute.getAttrType());
				attrJson.setAttrOption(categoryAttribute.getOptions());
				list.add(attrJson);
			}
			Gson gson = new GsonBuilder().serializeNulls().create();
			request.setAttribute("attrs", gson.toJson(list));
			request.setAttribute("itemId", item.getId());
		} else {
			List<AttrJson> list = new ArrayList<AttrJson>();
			for (String key : categoryAttributeByCidExtendMap.keySet()) {
				AttrJson attrJson = new AttrJson();
				CategoryAttribute categoryAttribute = categoryAttributeByCidExtendMap
						.get(key);
				attrJson.setAttr(categoryAttribute.getName());
				attrJson.setAttrOption(categoryAttribute.getOptions());
				attrJson.setAttrType(categoryAttribute.getAttrType());
				// 存在把值存入,去除map 中的属性
				if (itemAttributesMap.containsKey(key)) {
					attrJson.setOldValue(itemAttributesMap.get(key));
					itemAttributesMap.remove(key);
				}
				list.add(attrJson);
			}
			// 判断map中的属性 以 text显示出来
			for (String key : itemAttributesMap.keySet()) {
				AttrJson attrJson = new AttrJson();
				String value = itemAttributesMap.get(key);
				attrJson.setAttr(key);
				attrJson.setOldValue(value);
				attrJson.setAttrType("TEXT");
				attrJson.setLostAttr(true);
				list.add(attrJson);
			}
			Gson gson = new GsonBuilder().serializeNulls().create();
			request.setAttribute("attrs", gson.toJson(list));
			request.setAttribute("itemId", item.getId());
		}
		return "admin/item/additemattr";
	}

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Item item, Page<Item> page, HttpServletRequest request,
			HttpServletResponse response) {
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		item.setSiteId(siteId);
		page = itemService.list(page, item);
		return new Pager<Item>().getJsonPagerData(page);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer id, HttpServletRequest request) {
		if (id != null) {
			Item item = itemService.getItem(id);
			item = itemService.calPriceDiv(item);
			// 查找分类
			webCache.initCategory(request.getSession().getServletContext());
			Map<Integer, Category> categories = (Map<Integer, Category>) request
					.getSession().getServletContext().getAttribute(CacheName.CATEGORY_BY_PK.toString());
			Category category = categories.get(item.getCategoryId());
			if (category.getParentId() != null) {
				Category category1 = categories.get(category.getParentId());
				if (category1.getParentId() != null) {
					Category category2 = categories
							.get(category1.getParentId());
					item.setTopCategoryId(category2.getId());
					item.setSecondCategoryId(category1.getId());
					item.setThirdCategoryId(category.getId());
				} else {
					item.setTopCategoryId(category1.getId());
					item.setSecondCategoryId(category.getId());
				}
			} else {
				item.setTopCategoryId(category.getId());
			}
			
			
			request.setAttribute("model", item);
		}
		return "admin/item/edit";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(Item item, HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(item.getName(), "请输入商品名称")
				.isNotBlankValidator(item.getDescription(), "请输入商品描述")
				.isNotBlankValidator(item.getCprice(), "请输入商品价格");
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			// TODO 需要还原对象
			request.setAttribute("model", item);
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			// 计算价格 * 100
			item = itemService.calcPriceMulti(item);
			setCategory(item);
			if (item.getId() == null) {
				initItem(item, backSession);
				item = itemService.save(item);
				request.setAttribute("message", "商品信息增加成功");
			} else {
				item.setUpdatedAt(new Date());
				itemService.update(item);
				request.setAttribute("message", "商品信息修改成功");
			}
		}
		return edit(item.getId(), request);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * 根据属性设置分类信息
	 * 
	 * @param item
	 */
	private void setCategory(Item item) {
		if (item.getThirdCategoryId() != null) {
			item.setCategoryId(item.getThirdCategoryId());
		} else if (item.getSecondCategoryId() != null) {
			item.setCategoryId(item.getSecondCategoryId());
		} else {
			item.setCategoryId(item.getTopCategoryId());
		}
	}

	/**
	 * 初始化 item
	 * 
	 * @return
	 */
	private void initItem(Item item, BackSession backSession) {
		item.setHitCounter(0);
		item.setRating(0);
		item.setSiteId(backSession.getSiteId());
		item.setRatingCounter(0);
		item.setCreatedAt(new Date());
		item.setUpdatedAt(new Date());
	}
}
