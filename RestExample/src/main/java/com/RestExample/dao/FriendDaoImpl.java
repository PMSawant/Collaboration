package com.RestExample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestExample.model.Friend;
@SuppressWarnings("deprecation")
@Repository
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	@Transactional
	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend");
		List<Friend> friends=query.list();
		session.close();
		return friends;
	}

	@Transactional
	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,id);
		session.close();
		return friend;
	}

	@Transactional
	public void saveFriend(Friend friend) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(friend);
		 //session.flush();
		 session.getTransaction().commit();
		 session.close();
		
	}

	@Transactional
	public Friend updateFriend(int id, Friend friend) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Friend currentFriend=(Friend)session.get(Friend.class,id);
		if(currentFriend==null)
			return null;
		session.update(Friend.class);
		Friend updateFriend=(Friend)session.get(Friend.class, id); 
		//session.flush();
		session.getTransaction().commit();
		session.close();
		return updateFriend;
	}

	@Transactional
	public void deletFriend(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Friend friend=(Friend)session.get(Friend.class, id);
		session.delete(friend);
		session.getTransaction().commit();
		session.close();
		
	}

}
