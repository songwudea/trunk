package com.babailiren.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.ContentType;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.ContentTypeDao;

@Service
public class ContentTypeService {
	
	@Autowired
	private ContentTypeDao contentTypeDao;

	public ContentType getByPK(Integer pk) {
		return contentTypeDao.getByPK(pk);
	}
	
	public Page<ContentType> list(Page<ContentType> page, ContentType contentType) {
		return contentTypeDao.findContentTypePage(page, contentType);
	}
	
	public ContentType save(ContentType contentType) {
		return contentTypeDao.add(contentType);
	}
	
	public int[] update(ContentType contentType) {
		ContentType[]contentTypes = {contentType};
		return contentTypeDao.update(contentTypes);
	}
}
