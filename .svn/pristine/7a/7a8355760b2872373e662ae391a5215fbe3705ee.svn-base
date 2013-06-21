package com.babailiren.ec.model;

public class PriceFilter implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer siteId;
	private Integer categoryId;
	private Integer rangeMin;
	private Integer rangeMax;

	
	@Override
	public String toString() {
		if(rangeMin == null && rangeMax == null) {
			throw new IllegalArgumentException("rangeMin and rangeMax can't be null");
		}
		if(rangeMax == null) {
			return ">"+rangeMin;
		}
		if(rangeMin == null) {
			return "<"+rangeMax;
		}
		return rangeMin+ "-" + rangeMax;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(Integer rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Integer getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Integer rangeMax) {
		this.rangeMax = rangeMax;
	}

}
