package com.babailiren.ec.web.filter;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.web.common.WebCache;
import com.google.common.base.Splitter;

public class SiteForwardFilter implements Filter {

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
/*		System.out.println(request.getQueryString());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getContextPath());*/
		String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
		//System.out.println(url);
		

		ServletContext servletContext = request.getSession().getServletContext();
		WebCache webCache = (WebCache)WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getBean("webCache");
		Map<String, Site> siteByDomain = webCache.getSiteMapByDomain(servletContext);

		//default site
		String domain = "";
		//通过域名查找SITE
		URL u = new URL(request.getRequestURL().toString());
		String queryString = request.getQueryString();

		// System.out.println(u.getQuery());
		String remoteHost = u.getHost();
		Site site = siteByDomain.get(remoteHost);
		if(site == null) {
			//通过路径查找SITE
			Iterable<String> split = Splitter.on("/").omitEmptyStrings().split(url);
			if(split.iterator().hasNext()) {
				domain = split.iterator().next();
			}
			site = siteByDomain.get(domain);
			//找不到，加载默认SITE
			if(site == null) {
				site = siteByDomain.get(domain);
			} else {
				//通过路径获取的site 要重新处理URL
				url = url.replace("/"+domain, "");
			}
		} else {
			domain = remoteHost;
		}
		String query = queryString == null?"":queryString;
		if(site != null) {
			query = "site="+domain+(StringUtils.isBlank(query)?"":"&"+query);
			String string = url+(StringUtils.isBlank(query)?"":"?"+query);
//			System.out.println(string);
			request.getRequestDispatcher(string).forward(req, resp);
		} else {
			chain.doFilter(req, resp);
		}

	}


	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
