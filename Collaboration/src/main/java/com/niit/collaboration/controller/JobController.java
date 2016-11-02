package com.niit.collaboration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

@RestController
public class JobController {

	private static final Logger Logger =
			LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private Job job;
	
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getJobs(){
	Logger.debug("Calling method getJobs");
	List<Job> list=  jobDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<Job>>(HttpStatus.OK); 
	}
	
	@GetMapping("/job/{jobid}")
	public ResponseEntity<Job> getJob(@PathVariable("jobid") int jobid) {
		Logger.debug("Calling method getJob with jobid" + jobid);
		job = jobDAO.get(jobid);
		if (job == null)
		{
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Job>(job, HttpStatus.OK);	
	}
			
	
	 @PostMapping(value="/job")
	 public ResponseEntity<Job> createJob(@RequestBody Job job){
		 Logger.debug("Cslling method createJob");
		 
		 if(jobDAO.get(job.getJobid()) == null)
		 {	 
			 jobDAO.saveorUpdate(job);
			 return new ResponseEntity<Job>(job, HttpStatus.OK);
		 }
		 return new ResponseEntity<Job>(HttpStatus.CONFLICT);
	 }
	 
	 
	 @DeleteMapping("/job/{jobid}")
	 public ResponseEntity<Job> deleteJob(@PathVariable int jobid){
		 Logger.debug("Calling method deleteBlog with the jobid" + jobid);
		 
		 if (jobDAO.get(jobid)== null){
			 return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		 }
		 jobDAO.delete(jobid);
		 return new ResponseEntity<Job>(HttpStatus.OK);
	 }	
	 
	 @PutMapping("/job/{jobid}")
	 public ResponseEntity<Job> updateJob(@PathVariable int jobid,@RequestBody Job job){
		 Logger.debug("Calling method updateBlog eith the jobid" + jobid);
		 
		 if (jobDAO.get(jobid)== null){
			 return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		 }
		 jobDAO.saveorUpdate(job);
		 return new ResponseEntity<Job>(job,HttpStatus.OK);
	 }	
}
