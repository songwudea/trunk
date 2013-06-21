package com.babailiren.ec.lucene;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopFieldCollector;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babailiren.ec.enumeration.CacheName;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.ItemService;
import com.babailiren.ec.web.common.Configuration;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Component
public class LuceneInit {
	@Autowired
	private ItemService itemService;

	@SuppressWarnings("unchecked")
	public List<LuceneItem> tranLuceneItems(List<Item> itemList,
			ServletContext context) {

		final Map<Integer, Brand> brandByPK = (Map<Integer, Brand>) context
				.getAttribute(CacheName.BRAND_BY_PK.toString());
		final Map<Integer, Category> categoryByPK = (Map<Integer, Category>) context
				.getAttribute(CacheName.CATEGORY_BY_ID.toString());
		final Map<Integer, List<PriceFilter>> priceRangeBySiteId = (Map<Integer, List<PriceFilter>>) context
				.getAttribute(CacheName.PRICE_RANGE_BY_SITEID.toString());
		Collection<LuceneItem> transform = Collections2.transform(itemList,
				new Function<Item, LuceneItem>() {
					@Override
					public LuceneItem apply(Item item) {
						LuceneItem li = new LuceneItem();
						BeanUtils.copyProperties(item, li);
						// 设置分类
						if (item.getCategoryId() != null) {
							Category category = categoryByPK.get(item
									.getCategoryId());
							setCtg(category, li);
						}
						// 设置品牌
						if (li.getBrandId() != null) {
							li.setBrandName(brandByPK.get(li.getBrandId())
									.getName());
						}
						// 设置价格区间
						List<PriceFilter> list = priceRangeBySiteId.get(li
								.getSiteId());
						final Integer price = li.getPrice();
						if (list != null && list.size() > 0) {
							PriceFilter find = Iterables.find(list,
									new Predicate<PriceFilter>() {
										@Override
										public boolean apply(PriceFilter pf) {
											if (pf.getRangeMin() != null
													&& pf.getRangeMin() * 100 > price) {
												return false;
											}
											if (pf.getRangeMax() != null
													&& pf.getRangeMax() * 100 <= price) {
												return false;
											}
											return true;
										}
									});
							li.setPriceRange(find.toString());
						}
						return li;
					}
				});

		return Lists.newArrayList(transform);
	}

	/**
	 * 核心搜索器
	 * 
	 * @param product
	 * @return
	 * @throws ParseException
	 */
	public BooleanQuery searchCond(LuceneSearchItem item) throws ParseException {
		BooleanQuery booleanQuery = new BooleanQuery();
		/** 商品名字 **/
		String name = item.getName();
		if (StringUtils.isNotEmpty(name)) {
			Term term = new Term("name", "*" + name + "*");
			WildcardQuery query = new WildcardQuery(term);
			booleanQuery.add(query, BooleanClause.Occur.MUST);
		}

		/** 根据品牌id **/
		Integer brandId = item.getBrandId();
		if (brandId != null) {
			Term term = new Term("brand_id", String.valueOf(brandId));
			TermQuery query = new TermQuery(term);
			booleanQuery.add(query, BooleanClause.Occur.MUST);
		}
		
//		Integer siteId = item.getSiteId();
//		if(siteId != null) {
//			Term term = new Term("site_id", String.valueOf(siteId));
//			TermQuery query = new TermQuery(term);
//			booleanQuery.add(query, BooleanClause.Occur.MUST);
//		}
		
		return booleanQuery;
	}
	
	/**
	 * 
	 * @param searchType
	 *            查询类别
	 * @param searchKey
	 *            查询参数
	 * @param untype
	 *            过滤条件
	 * @param catalogid
	 *            分类查询
	 * @return
	 */
	public int getPageTotalCount(LuceneSearchItem item) {
		int totalCount = 0;
		try {
			// TODO　==替换回来
			File file = new File("D:\\workspace\\ltxstore\\luceneIndex");
			Directory dir = FSDirectory.open(file);
			IndexReader reader = IndexReader.open(dir);
			IndexSearcher searcher = new IndexSearcher(reader);
			BooleanQuery booleanQuery = searchCond(item);
			TopScoreDocCollector topCollector = TopScoreDocCollector.create(
					searcher.maxDoc(), false);
			searcher.search(booleanQuery, topCollector);
			ScoreDoc[] docs = topCollector.topDocs(0).scoreDocs;
			totalCount = docs.length;
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception: " + e.getMessage());
		}
		return totalCount;
	}

	/**
	 * 
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            总页数
	 * @param query
	 *            Query
	 * @param searcher
	 *            Searcher
	 * @param searcherFlag
	 *            排序规则 true正序 false倒叙
	 * @param sortRules
	 *            排序
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Page<LuceneSearchItem> getPageQuery(int pageNo, int pageSize, Query query,
			IndexSearcher searcher) {
		List<LuceneSearchItem> result = new ArrayList<LuceneSearchItem>();
		try {
			
			/** 得到查询结果的总记录数 **/
			Sort sort = new Sort(new SortField("price", SortField.LONG, true));
//			topCollector = TopFieldCollector.create(sort, searcher.maxDoc(),
//					true, true, true, false);
			
			/** 得到查询结果的总记录数 **/
			// TopScoreDocCollector topCollector = TopScoreDocCollector.create(10, false);
			TopFieldCollector topCollector = TopFieldCollector.create(sort, searcher.maxDoc(),
					true, true, true, false);
			
			searcher.search(query, topCollector);
			/** 查询当页的记录 **/
			ScoreDoc[] docs = topCollector.topDocs((pageNo - 1) * pageSize,
					pageSize).scoreDocs;
			
			for (ScoreDoc scdoc : docs) {
				try {
					Document doc = searcher.doc(scdoc.doc);
					LuceneSearchItem searchItem = new LuceneSearchItem();
					searchItem.setId(Integer.parseInt(doc.get("item_id")));
					searchItem.setSiteId(Integer.parseInt(doc.get("site_id")));
					searchItem.setName(doc.get("name"));
					searchItem.setBookedQuantity(Integer.parseInt(doc
							.get("booked_quantity")));
					
					searchItem.setBrandId(NumberUtils.toInt(doc.get("brand_id"), 0));
					searchItem.setImageUrl(doc.get("image_url"));
					// item.setExpireOn(new Date(doc.get("expire_on")));
					searchItem.setMarketPrice(Integer.parseInt(doc
							.get("market_price")));
					searchItem.setSellable(Boolean.parseBoolean(doc.get("sellable")));
					searchItem.setShortDesc(doc.get("short_desc"));
					searchItem.setUpcCode(doc.get("upc_code"));
					searchItem.setSkuCode(doc.get("sku_code"));
					searchItem.setRating(Integer.parseInt(doc.get("rating")));
					searchItem.setRatingCounter(Integer.parseInt(doc
							.get("rating_counter")));
					searchItem.setPrice(Integer.parseInt(doc.get("price")));
//					item.setPublishOn(new Date(doc.get("publish_on")));
					result.add(searchItem);
				} catch (CorruptIndexException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Page<LuceneSearchItem> page = new Page<LuceneSearchItem>();
			page.setResult(result);
			page.setTotalItems(result.size());
			return page;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setCtg(Category category, LuceneItem li) {
		if (category == null) {
			return;
		}
		Integer level = category.getLevel();
		level += 1;
		try {
			org.apache.commons.beanutils.BeanUtils.setProperty(li, "ctgId"
					+ level, category.getId());
			org.apache.commons.beanutils.BeanUtils.setProperty(li, "ctgName"
					+ level, category.getName());
			org.apache.commons.beanutils.BeanUtils.setProperty(li, "ctgPath"
					+ level, category.getPath());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCtg(category.getParentCategory(), li);
	}

	/**
	 * 添加lucene索引
	 * 
	 * @param context
	 */
	public void addIndex(ServletContext context) {
		List<Item> itemList = itemService.findAll();
		List<LuceneItem> liList = tranLuceneItems(itemList, context);
		try {

			IndexWriter indexWriter = getIndexWriter();
			for (LuceneItem li : liList) {
				indexWriter.addDocument(modifyIndex(li));
			}
			indexWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对索引进行更新，状态为可订购的商品为进行索引更新，对于不可订购的商品进行索引删除
	 * 
	 * @param productView
	 */
	public Document modifyIndex(LuceneItem lucenetItem) {
		// Field.Index.ANALYZED:分词建索引
		// Field.Index.NOT_ANALYZED:分词不创建建索引

		Document document = new Document();
		Field itemId = new Field("item_id",
				String.valueOf(lucenetItem.getId()), Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field siteId = new Field("site_id", String.valueOf(lucenetItem
				.getSiteId()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field name = new Field("name", StringUtils.trimToEmpty(lucenetItem
				.getName()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field shortDesc = new Field("short_desc",
				StringUtils.trimToEmpty(lucenetItem.getShortDesc()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field upcCode = new Field("upc_code",
				StringUtils.trimToEmpty(lucenetItem.getUpcCode()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field skuCode = new Field("sku_code",
				StringUtils.trimToEmpty(lucenetItem.getSkuCode()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field rating = new Field("rating", String.valueOf(lucenetItem
				.getRating()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ratingCounter = new Field("rating_counter",
				String.valueOf(lucenetItem.getRatingCounter()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field bookedQuantity = new Field("booked_quantity",
				String.valueOf(lucenetItem.getBookedQuantity()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field marketPrice = new Field("market_price",
				String.valueOf(lucenetItem.getMarketPrice()), Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field price = new Field("price",
				String.valueOf(lucenetItem.getPrice()), Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field sellable = new Field("sellable", String.valueOf(lucenetItem
				.isSellable()), Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 日期==修改
		Field publishOn = new Field("publish_on", String.valueOf(lucenetItem
				.getPublishOn()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field expireOn = new Field("expire_on", String.valueOf(lucenetItem
				.getExpireOn()), Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 图片
		Field imageUrl = new Field("image_url",
				StringUtils.trimToEmpty(lucenetItem.getImageUrl()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field imageAlt = new Field("image_alt",
				StringUtils.trimToEmpty(lucenetItem.getImageAlt()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 分类
		Field ctgName1 = new Field("ctg_name1",
				StringUtils.trimToEmpty(lucenetItem.getCtgName1()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgName2 = new Field("ctg_name2",
				StringUtils.trimToEmpty(lucenetItem.getCtgName2()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgName3 = new Field("ctg_name3",
				StringUtils.trimToEmpty(lucenetItem.getCtgName3()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 分类id
		Field ctgId1 = new Field("ctg_id1", String.valueOf(lucenetItem
				.getCtgId1()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgId2 = new Field("ctg_id2", String.valueOf(lucenetItem
				.getCtgId2()), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgId3 = new Field("ctg_id3", String.valueOf(lucenetItem
				.getCtgId3()), Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 分类path
		Field ctgPath1 = new Field("ctg_path1",
				StringUtils.trimToEmpty(lucenetItem.getCtgPath1()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgPath2 = new Field("ctg_path2",
				StringUtils.trimToEmpty(lucenetItem.getCtgPath2()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ctgPath3 = new Field("ctg_path3",
				StringUtils.trimToEmpty(lucenetItem.getCtgPath3()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 品牌
		Field brandName = new Field("brand_name",
				StringUtils.trimToEmpty(lucenetItem.getBrandName()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field brandId = new Field("brand_id", String.valueOf(lucenetItem
				.getBrandId()), Field.Store.YES, Field.Index.NOT_ANALYZED);

		// 价格区间
		Field priceRange = new Field("price_range",
				StringUtils.trimToEmpty(lucenetItem.getPriceRange()),
				Field.Store.YES, Field.Index.NOT_ANALYZED);

		document.add(itemId);
		document.add(siteId);
		document.add(name);
		document.add(shortDesc);
		document.add(upcCode);
		document.add(skuCode);
		document.add(rating);
		document.add(ratingCounter);
		document.add(bookedQuantity);
		document.add(marketPrice);
		document.add(price);
		document.add(sellable);
		document.add(publishOn);
		document.add(expireOn);
		document.add(imageUrl);
		document.add(imageAlt);
		document.add(ctgName1);
		document.add(ctgName2);
		document.add(ctgName3);
		document.add(ctgId1);
		document.add(ctgId2);
		document.add(ctgId3);
		document.add(ctgPath1);
		document.add(ctgPath2);
		document.add(ctgPath3);
		document.add(brandName);
		document.add(brandId);
		document.add(priceRange);
		return document;

	}

	private IndexWriter getIndexWriter() {
		try {
			Directory dir = FSDirectory.open(new File(Configuration
					.getLuceneIndexPath()));
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36,
					new StandardAnalyzer(Version.LUCENE_36));
			return new IndexWriter(dir, config);
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param searchType
	 *            查询类别
	 * @param searchKey
	 *            查询参数
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            总页数
	 * @param untype
	 *            过滤条件
	 * @param catalogid
	 *            分类查询
	 * @param searcherFlag
	 *            排序规则 true正序 false倒叙
	 * @param sortRules
	 *            排序
	 * @return
	 */
	public Page<LuceneSearchItem> search(int pageNo, int pageSize, LuceneSearchItem item) {
		Page<LuceneSearchItem> page = null;
		try {
			File file = new File("D:\\workspace\\ltxstore\\luceneIndex");
			Directory dir = FSDirectory.open(file);
			IndexReader reader = IndexReader.open(dir);
			IndexSearcher searcher = new IndexSearcher(reader);
			BooleanQuery booleanQuery = searchCond(item);
			page = getPageQuery(pageNo, pageSize, booleanQuery, searcher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	
	// TODO 输入和输出类
	// TODO 排序字段
	// TODO 分页留位置给我
	// TODO 
	public static void main(String[] args) throws IOException, ParseException {
		LuceneInit luceneInit = new LuceneInit();
		LuceneSearchItem item1 = new LuceneSearchItem();
		item1.setName("商品");
		Page<LuceneSearchItem> page = luceneInit.search(1, 10, item1);
		
		int totalCount = luceneInit.getPageTotalCount(item1);
		List<LuceneSearchItem> items = page.getResult();
		for(LuceneSearchItem item : items) {
			System.out.println(item.getId());
			System.out.println(item.getName());
			System.out.println(item.getShortDesc());
			System.out.println(item.getPrice());
			System.out.println("========================================");
		}
		
		System.out.println(totalCount);

		// 剃毛器
		// Item item = new Item();
		// item.setName("剃毛器");
		// search(1, 10, item);

		// Term term = new Term("item_id", "1");
		// TermQuery luceneQuery = new TermQuery(term);
		// TopFieldCollector collector = TopFieldCollector.create(null,
		// searcher.maxDoc(),
		// true, true, true, false);

		// searcher.search(luceneQuery, null, collector);
		// ScoreDoc[] docs = collector.topDocs().scoreDocs;
		// System.out.println(docs.length);

//		File file = new File("D:\\workspace\\ltxstore\\luceneIndex");
//		Directory dir = FSDirectory.open(file);
//		IndexSearcher searcher = new IndexSearcher(dir);
//		IndexReader reader = searcher.getIndexReader();
//		TermEnum enumeration = reader.terms();
//		while (enumeration.next()) {
//			Term term = enumeration.term();
//			System.out.println(term.field() + ":" + term.text());
//			// invoke the other methods in TermEnum
//		}

//		File file = new File("D:\\workspace\\ltxstore\\luceneIndex");
//		Directory dir = FSDirectory.open(file);
//		IndexSearcher searcher = new IndexSearcher(dir);
//
//		BooleanQuery booleanQuery = new BooleanQuery();
//
//		Term term = new Term("name", "*商品*");
//		WildcardQuery query = new WildcardQuery(term);
//		booleanQuery.add(query, BooleanClause.Occur.MUST);
//		TopScoreDocCollector results = TopScoreDocCollector.create(10, false);
//		searcher.search(booleanQuery, results);
//
//		ScoreDoc[] hits = results.topDocs().scoreDocs;
//		for (int i = 0; i < hits.length; i++) {
//			int docId = hits[i].doc;
//			Document doc = searcher.doc(docId); // 查找原文档
//			String text = doc.get("name"); 
//			System.out.println(text);
//		}
	}
}
