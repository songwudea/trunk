package com.babailiren.ec.web.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.CacheName;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.model.Comment;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.UploadPic;
import com.babailiren.ec.provider.PointProvider;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.CategoryService;
import com.babailiren.ec.service.CommentService;
import com.babailiren.ec.service.FilterAttrService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.web.common.Configuration;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.babailiren.ec.web.vo.FilterAttr;
import com.google.common.collect.BiMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class ProductController {

	@Autowired
	private WebCache webCache;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private FilterAttrService filterAttrService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/products/{ctgPath}.html", method = RequestMethod.GET)
	public String grid(HttpServletRequest request, String site,
			Page<Item> page, @PathVariable String ctgPath) {
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Category category = WebUtils.getCategoryByPath(ctgPath, request);

		if(category == null && StringUtils.countMatches(ctgPath, "-") >= 7) {
			String[] params = ctgPath.split("-");
			
			if(Integer.valueOf(params[2]) != 0) {
				category = WebUtils.getCategoriesBySiteId(request, Integer.valueOf(params[2]));
			} else if(Integer.valueOf(params[1]) != 0) {
				category = WebUtils.getCategoriesBySiteId(request, Integer.valueOf(params[1]));
			} else if(Integer.valueOf(params[0]) != 0) {
				category = WebUtils.getCategoriesBySiteId(request, Integer.valueOf(params[0]));
			}
			
			// 获取顶级分类
			Category topCategory = categoryService.getTopCategory(category);
			
			// 获取分类属性
			List<CategoryAttribute> attrs = WebUtils.getCategoryAttrs(request, category);
			
			// 获取品牌
			List<Brand> brands = WebUtils.getBrandByCategoryId(request.getSession().getServletContext(), topCategory.getId());
			
			Item item = new Item();
			item.setCategoryId(category.getId());

			String template = ctgPath;

			// 合成分类的URL
			template = filterAttrService.categoryurl(category, template);
			
			// 合成品牌URL
			FilterAttr filterBrand = filterAttrService.brandurl(brands, template, params[Constants.BRAND_ATTR]);

			// 组织价格URL
			FilterAttr filterPrice = filterAttrService.priceurl(null, template, params[Constants.PRICE_ATTR]);

			// 组织属性
			List<FilterAttr> attrFilterList = filterAttrService.attrurl(attrs, template, ArrayUtils.subarray(params, 5, params.length));

			// 其他属性
			FilterAttr otherFilterList = filterAttrService.otherAttr(template, attrs.size(),  params[Constants.PRICE_ATTR + attrs.size() + 1]);

			Page<Item> list = itemService.list(page, item);
			request.setAttribute("brandList", filterBrand);
			request.setAttribute("priceList", filterPrice);
			request.setAttribute("attrFilterList", attrFilterList);
			request.setAttribute("productList", list.getResult());
			request.setAttribute("otherFilterList", otherFilterList);
		} else {
			// 建立上下级关系
			category = WebUtils.getCategoriesBySiteId(request, category.getId());

			// 获取顶级分类
			Category topCategory = categoryService.getTopCategory(category);

			// 获取分类属性
			List<CategoryAttribute> attrs = WebUtils.getCategoryAttrs(request, category);

			// 获取品牌
			List<Brand> brands = WebUtils.getBrandByCategoryId(request.getSession().getServletContext(), topCategory.getId());

			Item item = new Item();
			item.setCategoryId(category.getId());

			String template = filterAttrService.createBaseUrl(attrs.size());

			// 合成分类的URL
			template = filterAttrService.categoryurl(category, template);

			// 合成品牌URL
			FilterAttr filterBrand = filterAttrService.brandurl(brands, template, "0");

			// 组织价格URL
			FilterAttr filterPrice = filterAttrService.priceurl(null, template, "0");

			// 组织属性
			List<FilterAttr> attrFilterList = filterAttrService.attrurl(attrs, template);
			
			// 其他属性
			FilterAttr otherFilterList = filterAttrService.otherAttr(template, attrs.size(), "1");
			

			Page<Item> list = itemService.list(page, item);
			request.setAttribute("brandList", filterBrand);
			request.setAttribute("priceList", filterPrice);
			request.setAttribute("attrFilterList", attrFilterList);
			request.setAttribute("otherFilterList", otherFilterList);
			request.setAttribute("productList", list.getResult());
		}
		
		return WebUtils.themesView(request, currentSite, "product/grid");
	}

	
	
	@RequestMapping(value = "/eyes/{ctgPath}.html", method = RequestMethod.GET)
	public String list(HttpServletRequest request, String site,@PathVariable String ctgPath) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);
		List<Category> categoryList = categoryService.fullCategory();
		Category category = categoryService.getCategoryByPath(ctgPath);
		List<Item> itemList = itemService.findItemByCategoryId(category.getId());
		for(Item item : itemList) {
			List<UploadPic> images = jsonTranToPic(item.getImages());
			item.setItemImage(images);
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("category", category);
		request.setAttribute("itemList", itemList);
		
		return WebUtils.themesView(request, currentSite, "product/list");
	}
	
	@RequestMapping(value = "/product/p{itemId}.html", method = RequestMethod.GET)
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response, String site,
			@PathVariable Integer itemId) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);
		Item item = itemService.getItem(itemId);
		List<Comment> comments = commentService.findCommentsByItemId(itemId);
		
		@SuppressWarnings("unchecked")
		BiMap<String,Integer> itemIdUrlMap = (BiMap<String,Integer>)servletContext.getAttribute(CacheName.ITEM_ID_URL_MAP.toString());
		
		String url = itemIdUrlMap.inverse().get(item.getId());
		if(StringUtils.isNotBlank(url)) {
			//response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);   
			//response.setHeader("Location",url+".html");
			RedirectView rv = new RedirectView();
			rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
			rv.setUrl(url+".html");
			ModelAndView mv = new ModelAndView(rv);
			return mv;
		} else {
			return detail(request,currentSite,item,comments);
		}

	}

	@RequestMapping(value = "/product/{urlRewrite}.html", method = RequestMethod.GET)
	public ModelAndView ModelAndView(HttpServletRequest request, String site,
			@PathVariable String urlRewrite) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);
	
		@SuppressWarnings("unchecked")
		BiMap<String,Integer> itemIdUrlMap = (BiMap<String,Integer>)servletContext.getAttribute(CacheName.ITEM_ID_URL_MAP.toString());
		Integer itemId = itemIdUrlMap.get(urlRewrite);
		Item item = itemService.getItem(itemId);
		List<Comment> comments = commentService.findCommentsByItemId(itemId);
		return detail(request,currentSite,item, comments);
	}

	
	private ModelAndView detail(HttpServletRequest request,Site currentSite,Item item, List<Comment> comments) {
		List<UploadPic> images = jsonTranToPic(item.getImages());
		Category category = categoryService.getCategory(item.getCategoryId());
		List<Item> itemList = itemService.findItemByCategoryId(category.getId());
		item.setPoint(PointProvider.getSimplePoint(item));
		request.setAttribute("comments", comments);
		request.setAttribute("item", item);
		request.setAttribute("category", category);
		request.setAttribute("itemList", itemList);
		item.setItemImage(images);
		return new ModelAndView(WebUtils.themesView(request, currentSite, "product/detail"));
		
	}
	
	private List<UploadPic> jsonTranToPic(String json) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<UploadPic>>() {}.getType();

		List<UploadPic> images = gson.fromJson("[" +json + "]", type);
		
		for(int i = 0; i < images.size(); i++) {
			UploadPic uploadPic = images.get(i);
			uploadPic.setUrl(Configuration.getImageDomain() + uploadPic.getUrl());
		}
		return images;
	}
	
	
}
