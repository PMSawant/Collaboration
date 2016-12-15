package com.RestExample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestExample.model.Forum;

@SuppressWarnings("deprecation")
@Repository
public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forums=query.list();
		session.close();
		return forums;
	}
	@Transactional
	public Forum getForumById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Forum forum=session.get(Forum.class,id);
		session.close();
		return forum;
	}
	
	@Transactional
	public void saveForum(Forum forum) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(forum);
		 //session.flush();
		 session.getTransaction().commit();
		 session.close();		
	}
	@Transactional
	public Forum updateForum(int id, Forum forum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Forum currentForum=(Forum)session.get(Forum.class,id);
		if(currentForum==null)
			return null;
		session.update(Forum.class);
		Forum updateForum=(Forum)session.get(Forum.class, id); 
		//session.flush();
		session.getTransaction().commit();
		session.close();
		return updateForum;
	}
	@Transactional
	public void deletForum(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Forum forum=(Forum)session.get(Forum.class, id);
		session.delete(forum);
		session.getTransaction().commit();
		session.close();
		
	}


}
