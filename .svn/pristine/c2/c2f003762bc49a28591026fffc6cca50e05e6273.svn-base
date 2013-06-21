package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Content;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "contents")
public class ContentDao extends JdbcEntityDao<Content, Integer> {
	
	public List<Content> findParentContent(Integer siteId,Integer id) {
		//String sql = " select * from contents where contents.parent_id is null and site_id = ? ";
		String sql="select * from contents where site_id =? and id <> ? and parent_id <> ?";
		return this.find(sql, siteId,id,id);
	}
	
	public Page<Content> findContentPage(Page<Content> page, Content content) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where type_id = ?");
		page = findPage(page, sb.toString(),content.getTypeId());
		return page;
	}
	/**
	 * 查找顶级内容
	 * zq
	 */
	public Page<Content> findContentPage(Page<Content> page,String typeId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where parent_id= ?");
		page = findPage(page, sb.toString(),typeId);
		return page;
	}
	/**
	 * 通过parentId递归查询出所有的子目录
	 * @param urlRewrite
	 * @return
	 */
	public List<Content> getContentByParentId(Integer parentId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where parent_id = ?");
		return find(sb.toString(), parentId);
	}
	public List<Content> findContentByType(Integer typeId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where type_id = ? and parent_id is null order by id asc");
		
		return find(sb.toString(),typeId);
	}
	
	public List<Content> findContentByParent(Integer parentId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where parent_id = ? order by id asc");
		
		return find(sb.toString(),parentId);
	}
	
	public Page<Content> findContentPageBySiteId(Page<Content> page, Content content) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where site_id = ?");
		page = findPage(page, sb.toString(),content.getSiteId());
		return page;
	}

	public Content getContentByPath(String urlRewrite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contents where url_rewrite = ?");
		return get(sb.toString(), urlRewrite);
	}
	
	//查询有没有子目录
	public Content getByContent(Integer parentId) {
			StringBuffer sb = new StringBuffer();
			sb.append(" select * from contents where parent_id = ?");
			return get(sb.toString(), parentId);
		}
}
