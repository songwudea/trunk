package com.babailiren.ec.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.babailiren.ec.lucene.LuceneInit;
import com.babailiren.ec.web.common.Configuration;
import com.babailiren.ec.web.common.WebCache;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		WebCache webCache = (WebCache)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("webCache");
		//站点信息
		webCache.initSite(context);
		//模板索引
		webCache.initTemplate(context);
		//初始化分类树
		webCache.initCategory(context);
		// 初始化分类属性
		webCache.initCategoryAttr(context);
		// 初始化品牌
		webCache.initBrand(context);
		// 初始化价格区域
		webCache.initPriceRange(context);
		
		
		webCache.initItemIdUrlMap(context);
		//配置初始化
		Configuration.init();
		//其他初始化都完成后 才做Lucene的初始化
		LuceneInit luceneInit = (LuceneInit)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("luceneInit");
		luceneInit.addIndex(context);
	}
	
}
