package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Newsfeed;

@Repository("newsfeeDAO")
public class NewsfeedDAOImpl implements NewsfeedDAO {
	
	@Autowired
	private SessionFactory  sessionFactory;
	public NewsfeedDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveorUpdate(Newsfeed newsfeed) {
		sessionFactory.getCurrentSession().saveOrUpdate(newsfeed);

	}

	@Transactional
	public void delete(int newsfeedid) {
		Newsfeed newsfeedToDelete = new Newsfeed();
		newsfeedToDelete.setNewsfeedid(newsfeedid);
		sessionFactory.getCurrentSession().delete(newsfeedToDelete);
	}

	@Transactional
	public Newsfeed get(int newsfeedid) {
		String hql = "from User where newsfeedid=" + "'" + newsfeedid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Newsfeed> listNewsfeed = (List<Newsfeed>) query.list();

		if (listNewsfeed != null && !listNewsfeed.isEmpty()) {
			return listNewsfeed.get(0);
		}
	
		return null;
	}

	@Transactional
	public List<Newsfeed> list() {
		@SuppressWarnings("unchecked")
		List<Newsfeed> list = (List<Newsfeed>) sessionFactory.getCurrentSession().createCriteria(Newsfeed.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
