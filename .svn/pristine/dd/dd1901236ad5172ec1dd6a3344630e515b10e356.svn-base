package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Link;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "links")
public class LinkDao extends JdbcEntityDao<Link, Integer> {

	public Page<Link> findLinkPageBySiteId(Page<Link> page, Link Link) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from links where site_id = ?");
		page = findPage(page, sb.toString(), Link.getSiteId());
		return page;
	}

}
