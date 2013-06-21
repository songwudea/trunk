package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Link;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.LinkDao;

@Service
public class LinkService {
	@Autowired
	private LinkDao linkDao;

	public Link getByPK(Integer pk) {
		return linkDao.getByPK(pk);
	}
	
	public List<Link> findByPK(Integer[] pk) {
		return linkDao.findByPK(pk);
	}
	
	public Page<Link> findLinkBySiteId(Page<Link> page, Link Link) {
		return linkDao.findLinkPageBySiteId(page, Link);
	}
	
	public Link save(Link link) {
		return linkDao.add(link);
	}
	
	public int[] update(Link link) {
		Link[]links = {link};
		return linkDao.update(links);
	}

}
