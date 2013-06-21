package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.SortAttrEnum;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.web.vo.FilterAttr;
import com.babailiren.ec.web.vo.Price;

/**
 * 用于生成 url后的属性
 * 
 * @author xuyang
 * 
 */
@Service
public class FilterAttrService {

	/**
	 * 创建url过滤条件模版
	 * 
	 * @param attrCount
	 * @return
	 */
	public String createBaseUrl(Integer attrCount) {
		String val = "0-0-0-0-0";

		for (int i = 0; i < attrCount; i++) {
			val += "-0";
		}

		// 加入其他属性
		val += "-1";
		return val;
	}

	/**
	 * 生成 其他属性
	 * 
	 * @return
	 */
	public FilterAttr otherAttr(String template, Integer attrCount, String val) {
		FilterAttr attr = new FilterAttr();
		attr.setFilterName("排序");
		attr.setCheckVal(val);
		for (SortAttrEnum e : SortAttrEnum.values()) {
			String url = createUrl(template, Constants.PRICE_ATTR + attrCount + 1, String.valueOf(e.id));
			attr.getUrls().add(appendHtml(url));
			attr.getIds().add(String.valueOf(e.id));
			attr.getFilterValue().add(e.name);
		}
		return attr;
	}

	/**
	 * 生成品牌的URL
	 * 
	 * @param category
	 * @param baseTemplate
	 */
	public FilterAttr brandurl(List<Brand> brands, String template, String val) {
		FilterAttr attr = new FilterAttr();
		attr.setFilterName("品牌");
		String all = createUrl(template, Constants.BRAND_ATTR, "0");
		attr.getUrls().add(appendHtml(all));
		attr.getIds().add("0");
		attr.getFilterValue().add(Constants.ALL);
		attr.setCheckVal(val);

		for (Brand brand : brands) {
			String url = createUrl(template, Constants.BRAND_ATTR, String
					.valueOf(brand.getId()));
			attr.getUrls().add(appendHtml(url));
			attr.getIds().add(String.valueOf(brand.getId()));
			attr.getFilterValue().add(brand.getName());
		}
		return attr;
	}

	/**
	 * 生成 分类的url参数
	 * 
	 * @param category
	 * @param template
	 * @return
	 */
	public String categoryurl(Category category, String template) {

		String topId = "0";
		String secId = "0";
		String thirdId = "0";

		// 算级别
		if (category.getLevel() == 0) {
			topId = String.valueOf(category.getId());
		}
		if (category.getLevel() == 1) {
			Category parentCategory = category.getParentCategory();
			topId = String.valueOf(parentCategory.getId());
			secId = String.valueOf(category.getId());

		}
		if (category.getLevel() == 2) {
			thirdId = String.valueOf(category.getId());
			secId = String.valueOf(category.getParentId());
			topId = String.valueOf(category.getParentCategory()
					.getParentCategory().getId());
		}

		String text = createUrl(template, Constants.FIRST_CATEGORY, topId);
		text = createUrl(text, Constants.SECEND_CATEGORY, secId);
		;
		text = createUrl(text, Constants.THIRD_CATEGORY, thirdId);

		// 设置其他属性

		return text;
	}

	/**
	 * 生成 价格区间
	 * 
	 * @param list
	 * @param baseTemplate
	 * @return
	 */
	public FilterAttr priceurl(List<Price> list, String template, String val) {
		FilterAttr attr = new FilterAttr();
		attr.setFilterName("价格");
		attr.setCheckVal(val);
		List<Price> prices = new ArrayList<Price>();
		Price price = new Price();
		price.setId(1);
		price.setPrice("1-100");
		prices.add(price);
		price = new Price();
		price.setId(2);
		price.setPrice("200-300");
		prices.add(price);
		price = new Price();
		price.setId(3);
		price.setPrice("400-600");
		prices.add(price);
		attr.setFilterName("价格");

		String all = createUrl(template, Constants.PRICE_ATTR, "0");
		attr.getUrls().add(appendHtml(all));
		attr.getFilterValue().add(Constants.ALL);
		attr.getIds().add("0");
		for (int i = 0; i < prices.size(); i++) {
			String url = createUrl(template, Constants.PRICE_ATTR, String
					.valueOf(prices.get(i).getId()));
			attr.getUrls().add(appendHtml(url));
			attr.getFilterValue().add(prices.get(i).getPrice());
			attr.getIds().add(String.valueOf(prices.get(i).getId()));
		}
		return attr;
	}

	/**
	 * 属性
	 * 
	 * @param category
	 * @param baseTemplate
	 * @return 5
	 */
	public List<FilterAttr> attrurl(List<CategoryAttribute> attrs,
			String template, Object... val) {

		List<FilterAttr> list = new ArrayList<FilterAttr>();
		for (int i = 0; i < attrs.size(); i++) {
			CategoryAttribute categoryAttribute = attrs.get(i);
			String[] options = categoryAttribute.getOptions().split("\\|\\|");
			FilterAttr attr = new FilterAttr();
			attr.setFilterName(categoryAttribute.getName());

			Integer postion1 = i + 5;
			String all = createUrl(template, postion1, "0");
			attr.getUrls().add(appendHtml(all));
			attr.getFilterValue().add(Constants.ALL);
			attr.getIds().add("0");

			for (int j = 0; j < options.length; j++) {
				int postion = j + 1;
				String attrUrl = createUrl(template, i + 5, String
						.valueOf(postion));
				if (val.length == 0) {
					attr.setCheckVal("0");
				} else {
					attr.setCheckVal(String.valueOf(val[i]));
				}
				attr.getIds().add(String.valueOf(postion));
				attr.getFilterValue().add(options[j]);
				attr.getUrls().add(appendHtml(attrUrl));
			}
			list.add(attr);
		}
		return list;
	}

	private String appendHtml(String url) {
		return url + ".html";
	}

	private String createUrl(String url, int index, String val) {
		String[] value = url.split("-");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			if (i == index) {
				sb.append(val);
			} else {
				sb.append(value[i]);
			}

			if (i < value.length - 1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}

}
