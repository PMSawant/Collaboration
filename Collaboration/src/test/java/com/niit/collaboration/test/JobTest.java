package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

public class JobTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");
		
		Job job = (Job) context.getBean("job");
		
		jobDAO.saveorUpdate(job);
		

	}
}

