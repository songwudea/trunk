package com.babailiren.ec.web.common;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babailiren.ec.enumeration.CacheName;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.service.BrandService;
import com.babailiren.ec.service.CategoryAttributeService;
import com.babailiren.ec.service.CategoryService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.service.PriceFilterService;
import com.babailiren.ec.service.SiteService;
import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;


@Component
public class WebCache {
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryAttributeService categoryAttributeService;
	
	@Autowired
	private BrandService brandService;
	
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PriceFilterService priceFilterService;
	
	
	public void initItemIdUrlMap(ServletContext context) {
		BiMap<String,Integer> biItemIdUrlMap = HashBiMap.create();  
		List<Item> urlRewriteItem = itemService.findUrlRewriteItem();
		for(Item item : urlRewriteItem) {
			biItemIdUrlMap.put(item.getUrlRewrite(), item.getId());
		}
		context.setAttribute(CacheName.ITEM_ID_URL_MAP.toString(), biItemIdUrlMap);
	}
	
	
	public void initPriceRange(ServletContext context) {
		List<PriceFilter> priceFilterList = priceFilterService.findAll();
		Map<Integer,List<PriceFilter>> mapBySiteId = Maps.newHashMap();
		for(PriceFilter pf : priceFilterList) {
			if(pf == null) {continue;}
			List<PriceFilter> list = Lists.newArrayList();
			if (mapBySiteId.get(pf.getSiteId())!=null) {
				list = mapBySiteId.get(pf.getSiteId());
			}
			list.add(pf);
		}
		context.setAttribute(CacheName.PRICE_RANGE_BY_SITEID.toString(), mapBySiteId);
	}
	
	
	/**
	 * 初始化 品牌
	 * @param context
	 */
	public void initBrand(ServletContext context) {
		List<Brand> brands = brandService.findAll();
		context.setAttribute(CacheName.BRAND_ALL_LIST.toString(), brands);
		
		Map<Integer,Brand> mapByPK = Maps.newHashMap();
		Multimap<Integer,Brand> map = ArrayListMultimap.create();
		for(Brand brand : brands) {
			map.put(brand.getCategoryId(), brand);
			mapByPK.put(brand.getId(), brand);
		}
		context.setAttribute(CacheName.BRAND_BY_CATEGORY_ID.toString(), map);
		context.setAttribute(CacheName.BRAND_BY_PK.toString(), mapByPK);
	}
	
	/**
	 * 初始化 分类属性
	 * @param context
	 */
	public void initCategoryAttr(ServletContext context) {
		List<CategoryAttribute> attrs = categoryAttributeService.findAttributeFilter();
		Multimap<Integer,CategoryAttribute> map = ArrayListMultimap.create();
		for(CategoryAttribute attr : attrs) {
			map.put(attr.getCategoryId(), attr);
		}
		// CacheName.ATTR_BY_CATEGORY_ID.toString()
		context.setAttribute(CacheName.ATTR_BY_CATEGORY_ID.toString(), map);
	}
	
	
	public void initCategory(ServletContext context) {
		List<Category> categories = categoryService.fullCategory();
		Map<Integer,Category> mapByPK = Maps.newHashMap();
		Map<String,Category> mapByPath = Maps.newHashMap();
		for(Category c : categories) {
			mapByPK.put(c.getId(), c);
			mapByPath.put(c.getPath(), c);
		}
		
		
		context.setAttribute(CacheName.CATEGORY_BY_PK.toString(), mapByPK);
		context.setAttribute(CacheName.CATEGORY_BY_PATH.toString(), mapByPath);
		context.setAttribute(CacheName.CATEGORY_TREE.toString(), categoryService.treeCategory());
		
		// 包含上下级关系
		context.setAttribute(CacheName.CATEGORY_BY_ID.toString(), categoryService.categories());
	}
	

	public void initSite(ServletContext context) {
		Map<String,Site> siteByDomain = Maps.newHashMap();
		
		//没用到过，先留着
		Map<Integer,Site> siteByPK = Maps.newHashMap();
		List<Site> sites = siteService.findAll();
		for(Site site : sites) {
			String domain = site.getDomain();
			if(site.isDefaultSite()) {
				domain = "";
			}
			siteByDomain.put(domain, site);
			siteByPK.put(site.getId(), site);
		}
		context.setAttribute(CacheName.SITE_BY_DOMAIN.toString(), siteByDomain);
		context.setAttribute("siteByPK", siteByPK);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Site> getSiteMapByDomain(ServletContext context) {
		Map<String,Site> siteByDomain = (Map<String,Site>)context.getAttribute(CacheName.SITE_BY_DOMAIN.toString());
		siteByDomain = (Map<String,Site>)context.getAttribute(CacheName.SITE_BY_DOMAIN.toString());
		return siteByDomain;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<Integer,Site> getSiteMapByPK(ServletContext context) {
		Map<Integer,Site> siteByPK = (Map<Integer,Site>)context.getAttribute(CacheName.SITE_BY_PK.toString());
		siteByPK = (Map<Integer,Site>)context.getAttribute(CacheName.SITE_BY_PK.toString());
		return siteByPK;
	}
	
	
	public Site getSiteByDomain(ServletContext context,String domain) {
		Map<String, Site> siteMapByDomain = getSiteMapByDomain(context);
		Site currentSite = siteMapByDomain.get(domain);
		return currentSite==null?siteMapByDomain.get(""):currentSite;
	}
	
	//读取目录时过滤svn目录
	private FilenameFilter filter = new FilenameFilter() {
		@Override
		public boolean accept(File arg0, String arg1) {
			return !".svn".equalsIgnoreCase(arg1);
		}
	};
	public void initTemplate(ServletContext context) {
		
		List<String> jspFiles = Lists.newArrayList();
		ArrayListMultimap<String,String> sourceFiles = ArrayListMultimap.create();
		File file = new File(context.getRealPath("/WEB-INF/jsp/themes"));
		for(File theme : file.listFiles(filter)) {
			if(theme.isDirectory()) {
				//作为一个主题包处理
				procTheme(theme,jspFiles,sourceFiles);
			} else {
				continue;
			}
		}
		context.setAttribute("jspFiles", jspFiles);
		Map<String, Collection<String>> asMap = sourceFiles.asMap();
		context.setAttribute("sourceFiles", asMap);
	}
	
	private void procTheme(File theme,List<String> jspFiles,ArrayListMultimap<String,String> sourceFiles) {
		for(File f : theme.listFiles(filter)) {
			if(f.isDirectory() && "css".equalsIgnoreCase(f.getName())) {
				for(File css : f.listFiles(filter)) {
					if(css.isFile()) {
						sourceFiles.put(theme.getName()+"/css",css.getName());
					}
				}
			} else if(f.isDirectory() && "js".equalsIgnoreCase(f.getName())) {
				for(File js : f.listFiles(filter)) {
					if(js.isFile()) {
						sourceFiles.put(theme.getName()+"/js",js.getName());
					}
				}
			} else if(f.isDirectory() && "images".equalsIgnoreCase(f.getName())) {
				//图片忽略 由css 统一请求
			} else {
				//其他文件和目录
				if(f.isDirectory()) {
					for(File otherFile : f.listFiles(filter)) {
						jspFiles.add(Joiner.on("/").join(new String[] {"themes",theme.getName(),f.getName(),otherFile.getName()}));
					}
				} else {
					jspFiles.add(Joiner.on("/").join(new String[] {"themes",theme.getName(),f.getName()}));
				}

			}
		}
	}
}
