package com.RestExample.dao;

import java.util.List;

import com.RestExample.model.Blog;

public interface BlogDao {
	
	List<Blog> getAllBlogs();
	Blog getBlogById (int id);
	void saveBlog(Blog blog);
	Blog updateBlog(int id, Blog blog);
	void deletBlog(int id);	

}
