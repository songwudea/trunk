package com.babailiren.ec.model;

import java.util.Date;

import com.babailiren.ec.repository.FieldIgnore;

public class Site implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer languageId;
	private Integer templateId;
	private String templateName;
	private String languageName;
	private Language language;
	private Template template;
	private String domain;
	private boolean defaultSite;
	private Date createdAt;
	private Date updatedAt;
	private String name;
	private boolean authorize;
	private Integer perPageItem;
	private String indexHtmlContent;
	
	
	public Integer getPerPageItem() {
		return perPageItem;
	}
	public void setPerPageItem(Integer perPageItem) {
		this.perPageItem = perPageItem;
	}
	@FieldIgnore
	public boolean isAuthorize() {
		return authorize;
	}
	public void setAuthorize(boolean authorize) {
		this.authorize = authorize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isDefaultSite() {
		return defaultSite;
	}
	public void setDefaultSite(boolean defaultSite) {
		this.defaultSite = defaultSite;
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	@FieldIgnore
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	@FieldIgnore
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@FieldIgnore
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@FieldIgnore
	public String getTemplateName() {
		return templateName;
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	@FieldIgnore
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndexHtmlContent() {
		return indexHtmlContent;
	}
	public void setIndexHtmlContent(String indexHtmlContent) {
		this.indexHtmlContent = indexHtmlContent;
	}
	
}
