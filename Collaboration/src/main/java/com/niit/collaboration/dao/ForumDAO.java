package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {
	
public void saveorUpdate(Forum forum);
	
	public void delete (int forumid);
	
	public Forum get(int forumid);

	public List<Forum> list();


}
