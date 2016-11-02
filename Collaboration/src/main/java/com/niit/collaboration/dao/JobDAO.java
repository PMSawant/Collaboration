package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	
public void saveorUpdate(Job job);
	
	public void delete (int jobid);
	
	public Job get(int jobid);

	public List<Job> list();


}
