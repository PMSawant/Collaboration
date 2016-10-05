package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	
	@Autowired
	private SessionFactory  sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public void saveorUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);		
	}

	@Transactional
	public void delete(int blogid) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogid(blogid);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}

	@Transactional
	public Blog get(int blogid) {
		String hql = "from User where blogid=" + "'" + blogid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}


	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	
	}
}
