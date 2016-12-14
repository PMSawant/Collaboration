package com.RestExample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.RestExample.model.Person;
@SuppressWarnings("deprecation")
@Repository
public class PersonDaoImpl implements PersonDao{
	@Autowired
private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Person> getAllPersons() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Person");
		List<Person> persons=query.list();
		session.close();
		return persons;
	}


	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Person person=session.get(Person.class,id);
		session.close();
		return person;
	}


	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(person);
		 //session.flush();
		 session.getTransaction().commit();
		 session.close();
	}

@Transactional
	public Person updatePerson(int id, Person person) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Person currentPerson=(Person)session.get(Person.class,id);
		if(currentPerson==null)
			return null;
		session.update(Person.class);
		Person updatedPerson=(Person)session.get(Person.class, id); 
		//session.flush();
		session.getTransaction().commit();
		session.close();
		return updatedPerson;
	
	}


public void deletePerson(int id) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Person person=(Person)session.get(Person.class, id);
	session.delete(person);
	session.getTransaction().commit();
	session.close();
	
}

}