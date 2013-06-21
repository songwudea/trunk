package com.babailiren.ec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.babailiren.ec.repository.FieldIgnore;
import com.google.common.collect.Lists;

public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer parentId;
	private String name;
	private String path;
	private Integer level;
	private String createdBy;
	private Date createdAt;
	private List<Brand> brands;
	private List<CategoryAttribute> categoryAttributes;
	private String headerTpl;
	private String footerTpl;
	private Integer sort;

	private String updatedBy;
	private Date updatedAt;
	private Integer siteId;
	
	private List<Category> children = new ArrayList<Category>();
	private String htmlStaticPage;
	private String code;
	
	private String htmlTitle;
	private String metaKeywords;
	private String metaDesc;
	private String urlRewrite;

	private List<Content> contentList = Lists.newArrayList();
	
	/** 存放分类属性 */
	private Map<String, List<String>> attrs = new HashMap<String, List<String>>();

	private Category parentCategory;

	public Integer getId() {
		return id;
	}

	public String getHeaderTpl() {
		return headerTpl;
	}

	public void setHeaderTpl(String headerTpl) {
		this.headerTpl = headerTpl;
	}

	public String getFooterTpl() {
		return footerTpl;
	}

	public void setFooterTpl(String footerTpl) {
		this.footerTpl = footerTpl;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@FieldIgnore
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	@FieldIgnore
	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	@FieldIgnore
	public List<CategoryAttribute> getCategoryAttributes() {
		return categoryAttributes;
	}

	public void setCategoryAttributes(List<CategoryAttribute> categoryAttributes) {
		this.categoryAttributes = categoryAttributes;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@FieldIgnore
	public List<Content> getContentList() {
		return contentList;
	}

	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}

	@FieldIgnore
	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@FieldIgnore
	public Map<String, List<String>> getAttrs() {
		return attrs;
	}

	public void setAttrs(Map<String, List<String>> attrs) {
		this.attrs = attrs;
	}

	public String getHtmlStaticPage() {
		return htmlStaticPage;
	}

	public void setHtmlStaticPage(String htmlStaticPage) {
		this.htmlStaticPage = htmlStaticPage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getHtmlTitle() {
		return htmlTitle;
	}

	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

	public String getUrlRewrite() {
		return urlRewrite;
	}

	public void setUrlRewrite(String urlRewrite) {
		this.urlRewrite = urlRewrite;
	}
	
	
}
