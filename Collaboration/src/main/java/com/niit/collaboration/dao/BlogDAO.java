package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {

public void saveorUpdate(Blog blog);
	
	public void delete (int blogid);
	
	public Blog get(int blogid);

	public List<Blog> list();

}
