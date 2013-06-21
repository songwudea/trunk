package com.babailiren.ec.web.controller;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Content;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.PagePublish;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.service.BrandService;
import com.babailiren.ec.service.ContentService;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.service.PagePublishService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Controller
@RequestMapping("/")
public class IndexController {
	

	@Autowired
	private WebCache webCache;
	
	@Autowired
	private PagePublishService pagePublishService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private BrandService brandService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request,String site,String testString,Integer testInt) {
		
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		webCache.initSite(request.getSession().getServletContext());
		/*
		为了避免过多的判断和便于以后添加不同类型的数据，这里用比较动态的处理数据，
		一次查询出所有需要的数据后再按发布需要组织成供前台展示使用的数据集合。
		 */
		List<PagePublish> publishList = pagePublishService.findPagePublishs(currentSite.getId(), null);
		Set<Integer> contentIdList = Sets.newHashSet();
		Set<Integer> itemIdList = Sets.newHashSet();
		Set<Integer> brandIdList = Sets.newHashSet();
		ImmutableMap<String, Set<Integer>> idMap = ImmutableMap.of("contentIdList", contentIdList, "itemIdList", itemIdList, "brandIdList", brandIdList);
		for(PagePublish p : publishList) {
			Set<Integer> set = idMap.get(p.getEntityType()+"IdList");
			Iterable<String> ids = Splitter.on(',').split(p.getEntityId());
			for(String id : ids) {
				set.add(Integer.valueOf(id));
			}
		}
		
		System.out.println(Arrays.deepToString(contentIdList.toArray(new Integer[0])));
		System.out.println(Arrays.deepToString(itemIdList.toArray(new Integer[0])));
		System.out.println(Arrays.deepToString(brandIdList.toArray(new Integer[0])));
		
		List<Content> contentList = contentService.findByPK(contentIdList.toArray((new Integer[0])));
		List<Item> itemList = itemService.findByPK(itemIdList.toArray((new Integer[0])));
		List<Brand> brandList = brandService.findByPK(brandIdList.toArray((new Integer[0])));
		
		ImmutableMap<String, List<? extends Serializable>> objectMap = ImmutableMap.of("contentList", contentList, "itemList", itemList, "brandList", brandList);
		
		System.out.println(contentList.size());
		System.out.println(itemList.size());
		System.out.println(brandList.size());
		
		for(PagePublish p : publishList) {
			List<?> list = objectMap.get(p.getEntityType()+"List");
			final Iterable<String> ids = Splitter.on(',').split(p.getEntityId());
			List<Object> attr = Lists.newArrayList();
			for(Object o : list) {
				try {
					String property = BeanUtils.getProperty(o, "id");
					if(Lists.newArrayList(ids).contains(property)) {
						attr.add(o);
					}
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(p.getNameKey() +"=="+ p.getEntityId() +"---------"+ attr.size());
		}

		return WebUtils.themesView(request,currentSite,"index");
	}
	
}
