package com.RestExample.services;

import java.util.List;

import com.RestExample.model.Forum;

public interface ForumService {
	
	List<Forum> getAllForums();
	Forum getForumById (int id);
	void saveForum(Forum forum);
	Forum updateForum(int id, Forum forum);
	void deletForum(int id);	

}
