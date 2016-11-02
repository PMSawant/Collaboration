package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	private SessionFactory  sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveorUpdate(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);		
	}

	@Transactional
	public void delete(int jobid) {
		Job jobToDelete = new Job();
		jobToDelete.setJobid(jobid);
		sessionFactory.getCurrentSession().delete(jobToDelete);		
	}

	@Transactional	
	public Job get(int jobid) {
		String hql = "from User where jobid=" + "'" + jobid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>) query.list();

		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}
		return null;
	}

	@Transactional
	public List<Job> list() {
		@SuppressWarnings("unchecked")
		List<Job> list = (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
}
