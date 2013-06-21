package com.babailiren.ec.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Content;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.ContentDao;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

@Service
public class ContentService {
	//List<Content> contentList=new ArrayList<Content>();
	@Autowired
	private ContentDao contentDao;

	public Content getByPK(Integer pk) {
		return contentDao.getByPK(pk);
	}
	
	public Content getByContent(Integer pk) {
		return contentDao.getByContent(pk);
	}
	public List<Content> findParentContent(Integer siteId,Integer id) {
		return contentDao.findParentContent(siteId,id);
	}
	
	public List<Content> findContentByType(Integer typeId) {
		List<Content> findContentByType = contentDao.findContentByType(typeId);
		for(Content c : findContentByType) {
			if(c.getId() != null) {
				c.setChildren(contentDao.findContentByParent(c.getId()));
			}
		}
		return findContentByType;
	}
	
	public List<Content> findByPK(Integer[] pk) {
		return contentDao.findByPK(pk);
	}
	
	/*public Page<Content> list(Page<Content> page, Content content) {
		return contentDao.findContentPage(page, content);
	}*/
	/**
	 * 查找顶级内容
	 * zq
	 */
	public Page<Content> list(Page<Content> page,String typeId) {
		return contentDao.findContentPage(page,typeId);
	}
	/**
	 * 通过parentId查询出所有的子目录
	 * @param urlRewrite
	 * @return
	 */
	public List<Content> getContentByParentId(Integer parentId) {
		List<Content> contentList = Lists.newArrayList();
		List<Content> list = contentDao.getContentByParentId(parentId);
		for (Content c : list) {
			contentList.add(c);
			list = getContentByParentId(c.getId());
			contentList = getReturn(list,contentList);
		}
		return contentList;
	}
	
	@SuppressWarnings("unused")
	private List<Content> filterCategory(final Integer parentId, Collection<Content> contentList) {
		Collection<Content> topContents = Collections2.filter(contentList,
				new Predicate<Content>() {
					@Override
					public boolean apply(Content input) {
						return input.getParentId() == parentId;
					}
				});
		List<Content> filtedList = Lists.newArrayList();
		filtedList.addAll(topContents);
		return filtedList;
	}
	/**
	 * 查询出所有的父节点的
	 * @param parentId
	 * @return
	 */
	public List<Content> treeContent(Integer parentId) {
		List<Content> contentList= this.getContentByParentId(parentId);
		List<Content> contentss = filterContentList(contentList, parentId);
		return contentss;
		/*for (Content c : contentList) {
			c.setChildren(filterCategory(c.getId(), contentList));
		}
		return filterCategory(0, contentList);*/
	}
	public List<Content> findChildById(Integer id){
		List<Content> contentList= this.getContentByParentId(id);
		if(contentList != null  &&  contentList.size() > 0)
			return contentList;
		else 
			return null;
	}
	/**
	 * 将得到的list拼装成一个新的包含子目录的list
	 * @return
	 */
	private List<Content> filterContentList(List<Content> contentList,Integer parentId){
		List<Content> contents=Lists.newArrayList();
		for (Content content : contentList) {
			if (content.getParentId() == parentId) {
				contents.add(content);
			}
		}
		for (Content content : contents) {
			List<Content> list=filterChildList(contentList,content.getId());
			content.setChildren(list);
		}
		return contents;
	}
	
	private List<Content> filterChildList(List<Content>  contentList,Integer id){
		List<Content> list=Lists.newArrayList();
		for (Content content : contentList) {
				if (id == content.getParentId()) {
					list.add(content);
			}
		}
		return list;
	}
	
	public List<Content> getReturn(List<Content> list,List<Content> contentList){
		for (Content c : list) {
			contentList.add(c);
		}
		return contentList;
	}
	public Page<Content> findContentBySiteId(Page<Content> page, Content content) {
		return contentDao.findContentPageBySiteId(page, content);
	}
	
	public Content save(Content content) {
		return contentDao.add(content);
	}
	
	public int[] update(Content content) {
		Content[]contents = {content};
		return contentDao.update(contents);
	}
	
	public Content getContentByPath(String urlRewrite) {
		return contentDao.getContentByPath(urlRewrite);
	}

	public void delete(String idList){
		contentDao.delete(idList);
	}

	
}
