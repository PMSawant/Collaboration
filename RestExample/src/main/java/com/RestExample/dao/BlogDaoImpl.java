package com.RestExample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestExample.model.Blog;

@SuppressWarnings("deprecation")
@Repository
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
			
	@Transactional
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> blogs=query.list();
		session.close();
		return blogs;		
	}

	@Transactional
	public Blog getBlogById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class,id);
		session.close();
		return blog;
	}

	@Transactional
	public void saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(blog);
		 //session.flush();
		 session.getTransaction().commit();
		 session.close();
	}

	@Transactional
	public Blog updateBlog(int id, Blog blog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Blog currentBlog=(Blog)session.get(Blog.class,id);
		if(currentBlog==null)
			return null;
		session.update(Blog.class);
		Blog updateBlog=(Blog)session.get(Blog.class, id); 
		//session.flush();
		session.getTransaction().commit();
		session.close();
		return updateBlog;

	}

	@Transactional
	public void deletBlog(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Blog blog=(Blog)session.get(Blog.class, id);
		session.delete(blog);
		session.getTransaction().commit();
		session.close();
	}

}
