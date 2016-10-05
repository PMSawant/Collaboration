package com.niit.collaboration.dao;

import com.niit.collaboration.model.Newsfeed;

public interface NewsfeedDAO {
	
public void saveorUpdate(Newsfeed newsfeed);
	
	public void delete (int newsfeedid);
	
	public Newsfeed get(int newsfeedid);

}
