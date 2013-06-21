package com.babailiren.ec.web.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.babailiren.ec.enumeration.CacheName;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.Template;
import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;

public class WebUtils {

	public static String themesView(HttpServletRequest request, Site site,
			String view) {
		
		request.setAttribute("current_site", site);
		Template template = site.getTemplate();
		String path = template.getPath();
		ServletContext servletContext = request.getSession()
				.getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Collection<String>> sourceFiles = (Map<String, Collection<String>>) servletContext
				.getAttribute("sourceFiles");
		Collection<String> css = sourceFiles.get(path + "/css");
		StringBuilder cssTag = new StringBuilder();
		String p = request.getContextPath() + "/themes/" + path;
		if(css != null) {
			for (String c : css) {
				cssTag.append("<link rel=\"stylesheet\" href=\"").append(p).append(
						"/css/").append(c).append("\"  type=\"text/css\"/>\n");
			}
		}

		Collection<String> js = sourceFiles.get(path + "/js");
		StringBuilder jsTag = new StringBuilder();
		if(js != null) {
			for (String j : js) {
				jsTag.append("<script type=\"text/javascript\" src=\"").append(p)
						.append("/js/").append(j).append("\"></script>\n");
			}
		}
		request.setAttribute("path", "http://"+site.getDomain()+p);
		request.setAttribute("css", cssTag);
		request.setAttribute("js", jsTag);
		return selectThemeView(servletContext, path, view);
	}

	private static String selectThemeView(ServletContext servletContext,
			String themePath, String view) {
		String themeView = Joiner.on("/").join(
				new String[] { "themes", themePath, view });
		@SuppressWarnings("unchecked")
		List<String> jspFiles = (List<String>) servletContext
				.getAttribute("jspFiles");
		if (!jspFiles.contains(themeView+".jsp")) {
			themeView = Joiner.on("/").join(
					new String[] { "themes", "default", view });
		}
		return themeView;
	}

	public static void putSuccessMessage(String msg, HttpServletRequest request) {
		request.setAttribute("successMessage", msg);
	}

	public static void putErrorMessage(String msg, HttpServletRequest request) {
		request.setAttribute("errorMessage", msg);
	}

	public static void putNoticeMessage(String msg, HttpServletRequest request) {
		request.setAttribute("noticeMessage", msg);
	}

	public static void putInfoMessage(String msg, HttpServletRequest request) {
		request.setAttribute("infoMessage", msg);
	}

	/**
	 * 获取 分类属性 向上追溯
	 * 
	 * @param category
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public static List<CategoryAttribute> getCategoryAttrs(
			HttpServletRequest request, Category category) {
		// 
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ArrayListMultimap categories = (ArrayListMultimap) servletContext
				.getAttribute(CacheName.ATTR_BY_CATEGORY_ID.toString());
		List list = new ArrayList<CategoryAttribute>();
		if (category.getLevel() == 2) {
			Collection<Category> collection = (Collection<Category>) categories
					.get(category.getId());
			Collection<Category> collection1 = (Collection<Category>) categories
					.get(category.getParentCategory().getId());
			Collection<Category> collection2 = (Collection<Category>) categories
					.get(category.getParentCategory().getParentCategory()
							.getId());
			list.addAll(collection);
			list.addAll(collection1);
			list.addAll(collection2);
		}

		if (category.getLevel() == 1) {
			Collection<Category> collection = (Collection<Category>) categories
					.get(category.getId());
			Collection<Category> collection1 = (Collection<Category>) categories
					.get(category.getParentCategory().getId());
			list.addAll(collection);
			list.addAll(collection1);
		}

		if (category.getLevel() == 0) {
			Collection<Category> collection = (Collection<Category>) categories
					.get(category.getId());
			list.addAll(collection);
		}

		return list;
	}

	/**
	 * 获取一个站点中的分类列表（组织好上下级别）
	 * 
	 * @param request
	 * @param siteId
	 * @return
	 */
	public static Category getCategoriesBySiteId(HttpServletRequest request,
			Integer cid) {
		ServletContext servletContext = request.getSession()
				.getServletContext();
		@SuppressWarnings("unchecked")
		Map<Integer, Category> categories = (Map<Integer, Category>) servletContext
				.getAttribute(CacheName.CATEGORY_BY_ID.toString());
		return categories.get(cid);
	}

	public static Category getCategoryByPath(String path,
			HttpServletRequest request) {
		ServletContext servletContext = request.getSession()
				.getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Category> mapByPath = (Map<String, Category>) servletContext
				.getAttribute(CacheName.CATEGORY_BY_PATH.toString());
		return mapByPath.get(path);
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	public static List<Brand> getBrandByCategoryId(ServletContext context,
			Integer cid) {
		ArrayListMultimap brands = (ArrayListMultimap) context
				.getAttribute(CacheName.BRAND_BY_CATEGORY_ID.toString());
		Collection<Brand> collection = (Collection<Brand>) brands.get(cid);
		List<Brand> list = new ArrayList<Brand>(collection);
		return list;
	}

	public static Integer getUserId(HttpServletRequest request) {
		if (request.getSession().getAttribute(SessionName.USER_ID.toString()) != null) {
			return Integer.parseInt(request.getSession().getAttribute(
					SessionName.USER_ID.toString()).toString());
		}
		return null;
	}

	/**
	 * 获取 guestId
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	public static String getGuestID(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String guestId = null;
		final String guestIdName = "guestId";
		for (Cookie cookie : cookies) {
			if (guestIdName.equalsIgnoreCase(cookie.getName())) {
				guestId = cookie.getValue();
			}
		}
		if (StringUtils.isNotBlank(guestId)) {
			return guestId;
		}

		String uuid = UUID.randomUUID().toString();
		Cookie cookie = new Cookie(guestIdName, uuid);
		cookie.setPath("/");
		cookie.setMaxAge(365 * 24 * 60 * 60);
		response.addCookie(cookie);
		return uuid;
	}

}
