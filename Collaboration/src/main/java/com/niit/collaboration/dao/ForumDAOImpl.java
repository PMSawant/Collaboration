package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {
	

	@Autowired
	private SessionFactory  sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveorUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);	
	}

	@Transactional
	public void delete(int forumid) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumid(forumid);
		sessionFactory.getCurrentSession().delete(forumToDelete);
		
	}

	@Transactional
	public Forum get(int forumid) {
		String hql = "from User where forumid=" + "'" + forumid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) query.list();

		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}

	@Transactional
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) sessionFactory.getCurrentSession().createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
