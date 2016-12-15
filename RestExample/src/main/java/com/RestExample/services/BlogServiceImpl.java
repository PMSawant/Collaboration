package com.RestExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestExample.dao.BlogDao;
import com.RestExample.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogDao getBlogDao() {
		return blogDao;
	}


	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return blogDao.getAllBlogs();
	}

	public Blog getBlogById(int id) {
		// TODO Auto-generated method stub
		return getBlogById(id);
	}

	public void saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogDao.saveBlog(blog);
	}

	public Blog updateBlog(int id, Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.updateBlog(id, blog);
	}

	public void deletBlog(int id) {
		// TODO Auto-generated method stub
		blogDao.deletBlog(id);
	}

}
