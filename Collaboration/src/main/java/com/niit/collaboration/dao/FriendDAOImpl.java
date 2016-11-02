package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Friend;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {
	

	@Autowired
	private SessionFactory  sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveorUpdate(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		
	}

	@Transactional
	public void delete(int friendid) {
		Friend friendToDelete = new Friend();
		friendToDelete.setFriendid(friendid);
		sessionFactory.getCurrentSession().delete(friendToDelete);	
	}

	@Transactional
	public Friend get(int friendid) {
		String hql = "from User where friendid=" + "'" + friendid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();

		if (listFriend != null && !listFriend.isEmpty()) {
			return listFriend.get(0);
		}
		return null;
	}
	@Transactional
	public List<Friend> list() {
		@SuppressWarnings("unchecked")
		List<Friend> list = (List<Friend>) sessionFactory.getCurrentSession().createCriteria(Friend.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
