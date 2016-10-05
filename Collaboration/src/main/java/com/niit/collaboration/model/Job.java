package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="JOB")
@Component
public class Job {

	@Id
	@Column(name="jobid")
	private int jobid;

	@Column(name="mailid")
	private String mailid;
	
	@Column(name="job_description")
	private String job_description;
	
	@Column(name="job_requirements")
	private String job_requirements;
	
	@Column(name="date_of_creation")
	private Date date_of_creation;
	
	@Column(name="company")
	private String company;

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getJob_requirements() {
		return job_requirements;
	}

	public void setJob_requirements(String job_requirements) {
		this.job_requirements = job_requirements;
	}

	public Date getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_cretion(Date date_of_cretion) {
		this.date_of_creation = date_of_cretion;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	

}
