package com.RestExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestExample.dao.ForumDao;
import com.RestExample.model.Forum;
@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumDao forumDao;

	public ForumDao getForumDao() {
		return forumDao;
	}
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}


	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		return forumDao.getAllForums();
	}
	
	public Forum getForumById(int id) {
		// TODO Auto-generated method stub
		return getForumById(id);
	}

	public void saveForum(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.saveForum(forum);;
	}

	public Forum updateForum(int id, Forum forum) {
		// TODO Auto-generated method stub
		return forumDao.updateForum(id, forum);
	}

	public void deletForum(int id) {
		// TODO Auto-generated method stub
		forumDao.deletForum(id);		
	}

}
