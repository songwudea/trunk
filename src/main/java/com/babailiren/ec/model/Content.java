package com.babailiren.ec.model;

import java.util.Date;
import java.util.List;

import com.babailiren.ec.repository.FieldIgnore;

public class Content implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer siteId;
	private Integer typeId;
	private Integer categoryId;
	private String title;
	private String content;
	private String urlRewrite;
	private String htmlTitle;
	private String metaKeywords;
	private String metaDesc;
	private Date publishOn;
	private Date expireOn;
	private boolean published;
	private Integer hitCounter;
	private String createdBy;
	private Date createdAt;
	private String updatedBy;
	private Date updatedAt;
	private Integer parentId;
	private List<Content> children;
	private String subTitle;
	private String code;
	
	
	
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	@FieldIgnore
	public List<Content> getChildren() {
		return children;
	}
	public void setChildren(List<Content> children) {
		this.children = children;
	}
	private Category category;
	private ContentType contentType;
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrlRewrite() {
		return urlRewrite;
	}
	public void setUrlRewrite(String urlRewrite) {
		this.urlRewrite = urlRewrite;
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
	public Date getPublishOn() {
		return publishOn;
	}
	public void setPublishOn(Date publishOn) {
		this.publishOn = publishOn;
	}
	public Date getExpireOn() {
		return expireOn;
	}
	public void setExpireOn(Date expireOn) {
		this.expireOn = expireOn;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	@FieldIgnore
	public Integer getHitCounter() {
		return hitCounter;
	}
	public void setHitCounter(Integer hitCounter) {
		this.hitCounter = hitCounter;
	}
	@FieldIgnore
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@FieldIgnore
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@FieldIgnore
	public ContentType getContentType() {
		return contentType;
	}
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
