package com.babailiren.ec.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.service.BrandService;
import com.babailiren.ec.service.CategoryAttributeService;
import com.babailiren.ec.service.CategoryService;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.ComboBoxModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryAttributeService categoryAttributeService;
	
	@RequestMapping(value = "editcategorypage.html", method = RequestMethod.GET)
	public String editcategorypage(Integer categoryId, HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		Category category = categoryService.getCategory(categoryId);
		request.setAttribute("siteId", siteId);
		request.setAttribute("categoryId", categoryId);
		request.setAttribute("model", category);
		return "admin/category/editcategorypage";
	}
	
	@RequestMapping(value = "editcategorypage.html", method = RequestMethod.POST)
	public String editcategorypage(Integer categoryId, String htmlStaticPage, HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		Category category = categoryService.getCategory(categoryId);
		category.setHtmlStaticPage(htmlStaticPage);
		request.setAttribute("siteId", siteId);
		request.setAttribute("categoryId", categoryId);
		request.setAttribute("model", category);
		
		try {
			categoryService.update(category);
			request.setAttribute("message", "首页静态页面编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "首页静态页面编辑失败");
		}
		return "admin/category/editcategorypage";
	}

	@RequestMapping(value = "childCategory.html", method = RequestMethod.POST)
	public @ResponseBody
	String childCategory(Category category, HttpServletRequest request) {
		List<Category> childCategories = categoryService
				.findCategoryByPid(category);
		Integer sid = NumberUtils.toInt(request.getParameter("sid"), 0);
		Integer tid = NumberUtils.toInt(request.getParameter("tid"), 0);
		List<ComboBoxModel> list = new ArrayList<ComboBoxModel>();
		for (int i = 0; i < childCategories.size(); i++) {
			ComboBoxModel combo = new ComboBoxModel();
			combo.setId(childCategories.get(i).getId());
			combo.setText(childCategories.get(i).getName());
			if (sid == combo.getId() || tid == combo.getId()) {
				combo.setSelected(true);
			}
			list.add(combo);
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(list);
	}

	@RequestMapping(value = "rootCategory.html", method = RequestMethod.POST)
	public @ResponseBody
	String rootCategory(HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer fid = NumberUtils.toInt(request.getParameter("fid"), 0);
		List<Category> rootCategories = categoryService
				.findParentCategory(backSession.getSiteId());
		List<ComboBoxModel> list = new ArrayList<ComboBoxModel>();
		for (int i = 0; i < rootCategories.size(); i++) {
			Category category = rootCategories.get(i);
			ComboBoxModel combo = new ComboBoxModel();
			if (fid == category.getId()) {
				combo.setSelected(true);
			}
			combo.setId(category.getId());
			combo.setText(category.getName());
			list.add(combo);
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "admin/category/index";
	}

	@RequestMapping(value = "doCategoryAttribute.html", method = RequestMethod.GET)
	public String doCategoryAttribute(Category category,
			HttpServletRequest request) {
		category = categoryService.getCategory(category.getId());
		request.setAttribute("categoryModel", category);
		return "admin/category/categoryattribute";
	}

	@RequestMapping(value = "categoryView.html", method = RequestMethod.GET)
	public String categoryView(Category category, HttpServletRequest request) {
		// 1. 获取当前分类
		// 2. 递规当前分类找全上下级
		Category currCategory = categoryService.getCategory(category.getId());
		Category parentCategory = null;
		Category topCategory = null;

		// 获取当前类的brands和属性
		List<Brand> currBrands = brandService.findBrandsByCid(currCategory
				.getId());
		currCategory.setBrands(currBrands);
		List<CategoryAttribute> currCategoryAttributes = categoryAttributeService
				.findCategoryAttributeByCid(currCategory.getId());
		currCategory.setCategoryAttributes(currCategoryAttributes);

		if (currCategory.getParentId() != null) {
			parentCategory = categoryService.getCategory(currCategory
					.getParentId());
			List<Brand> parentBrands = brandService
					.findBrandsByCid(parentCategory.getId());
			parentCategory.setBrands(parentBrands);
			List<CategoryAttribute> parentCategoryAttributes = categoryAttributeService
					.findCategoryAttributeByCid(parentCategory.getId());
			parentCategory.setCategoryAttributes(parentCategoryAttributes);
			if (parentCategory.getParentId() != null) {
				request.setAttribute("parentCategory", parentCategory);
			} else {
				request.setAttribute("topCategory", parentCategory);
			}
		} else {
			request.setAttribute("topCategory", currCategory);
		}

		if (parentCategory != null) {
			if (parentCategory.getParentId() != null) {
				topCategory = categoryService.getCategory(parentCategory
						.getParentId());
				List<Brand> topBrands = brandService
						.findBrandsByCid(topCategory.getId());
				topCategory.setBrands(topBrands);
				List<CategoryAttribute> topCategoryAttributes = categoryAttributeService
						.findCategoryAttributeByCid(topCategory.getId());
				topCategory.setCategoryAttributes(topCategoryAttributes);
				request.setAttribute("topCategory", topCategory);
				request.setAttribute("currCategory", currCategory);
			} else {
				request.setAttribute("topCategory", parentCategory);
				request.setAttribute("parentCategory", currCategory);
			}
		}

		return "admin/category/view";
	}

	@RequestMapping(value = "categoryAttribute.html", method = RequestMethod.POST)
	public String categoryAttribute(CategoryAttribute categoryAttribute,
			HttpServletRequest request) {

		Validator validator = new Validator();
		validator.isNotBlankValidator(categoryAttribute.getName(), "属性名称不能为空");
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (categoryAttribute.getId() == null) {
				categoryAttribute.setCreatedAt(new Date());
				categoryAttribute.setUpdatedAt(new Date());

				if (categoryAttribute.getOptions() != null
						|| !"".equals(categoryAttribute.getOptions())) {
					categoryAttribute.setOptions(categoryAttribute.getOptions()
							.replaceAll("\r\n", "||"));
				}
				categoryAttributeService.save(categoryAttribute);
				Category category = categoryService
						.getCategory(categoryAttribute.getCategoryId());
				request.setAttribute("categoryModel", category);
				request.setAttribute("message", "分类属性增加成功");
			} else {
				// categoryAttributeService.update(categoryAttribute);
				// request.setAttribute("message", "用户信息修改成功");
			}
		}
		return "admin/category/categoryattribute";
	}

	@RequestMapping(value = "categorybrand.html", method = RequestMethod.GET)
	public String categoryBrand(Integer categoryId, HttpServletRequest request) {
		List<Brand> brands = brandService.findBrands(categoryId);
		List<Brand> checkedBrands = brandService.findBrandsByCid(categoryId);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < checkedBrands.size(); i++) {
			Brand brand = checkedBrands.get(i);
			list.add(String.valueOf(brand.getId()));
		}
		request.setAttribute("checkbrands", list);
		request.setAttribute("id", categoryId);
		request.setAttribute("brands", brands);
		return "admin/category/categorybrand";
	}

	@RequestMapping(value = "categorybrand.html", method = RequestMethod.POST)
	public String categoryBrand(Category category, HttpServletRequest request,
			Integer[] brandid) {
		Integer catId = category.getId();
		categoryService.updateCategoryId(catId);
		if (brandid != null && brandid.length > 0) {
			for (int i = 0; i < brandid.length; i++) {
				Brand brand = brandService.getBrand(brandid[i]);
				brand.setCategoryId(catId);
				brandService.update(brand);
			}
		}
		request.setAttribute("message", "品牌选取成功");
		return categoryBrand(category.getId(), request);
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(Category category, HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(category.getName(), "请填写分类名");
		String method = request.getParameter("method");
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
			return "admin/category/edit";
		}

		if ("add".equals(method)) {
			if (StringUtils.isNotEmpty(request.getParameter("pid"))) {
				category.setParentId(Integer.parseInt(request
						.getParameter("pid")));
			}
			if (StringUtils.isNotEmpty(request.getParameter("plevel"))) {
				category.setLevel(Integer.parseInt(request
						.getParameter("plevel")) + 1);
			} else {
				category.setLevel(0);
			}
			category.setCreatedAt(new Date());
			category.setSiteId(backSession.getSiteId());
			category.setUpdatedAt(new Date());
			categoryService.save(category);
			request.setAttribute("pid", request.getParameter("pid"));
			request.setAttribute("pname", request.getParameter("pname"));
			request.setAttribute("plevel", request.getParameter("plevel"));
			request.setAttribute("message", "分类增加成功");
		} else if ("edit".equals(method)) {
			category.setUpdatedAt(new Date());
			categoryService.update(category);
			request.setAttribute("pid", request.getParameter("pid"));
			request.setAttribute("pname", request.getParameter("pname"));
			request.setAttribute("plevel", request.getParameter("plevel"));
			request.setAttribute("message", "分类修改成功");
		}
		request.setAttribute("method", "add");
		return "admin/category/edit";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer categoryId,
			HttpServletRequest request) {
		String method = request.getParameter("method");
		if (method.equals("add")) {
			request.setAttribute("method", "add");
			if (categoryId != null) {
				Category category = categoryService.getCategory(categoryId);
				request.setAttribute("pid", category.getId());
				request.setAttribute("pname", category.getName());
				request.setAttribute("plevel", category.getLevel());
			}
		} else if (method.equals("edit")) {
			Category category = categoryService.getCategory(categoryId);
			request.setAttribute("pid", category.getParentId());
			request.setAttribute("pname", category.getName());
			request.setAttribute("plevel", category.getLevel());
			request.setAttribute("model", category);
			request.setAttribute("method", "edit");
		}
		return "admin/category/edit";
	}

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Category category, HttpServletRequest request,
			HttpServletResponse response) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		List<Category> firsts = categoryService.treeCategoryNoParent(backSession.getSiteId());
		Gson gson = new GsonBuilder().serializeNulls().create();
		// System.out.println(gson.toJson(firsts));
		return gson.toJson(firsts);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
}
