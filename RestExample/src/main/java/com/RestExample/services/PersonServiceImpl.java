package com.RestExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestExample.dao.PersonDao;
import com.RestExample.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
private PersonDao personDao;
	
	
	public PersonDao getPersonDao() {
		return personDao;
	}


	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}


	public List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}


	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return personDao.getPersonById(id);
	}


	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		personDao.savePerson(person);
	}


	public Person updatePerson(int id, Person person) {
		// TODO Auto-generated method stub
		return personDao.updatePerson(id, person);
	}


	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		personDao.deletePerson(id);
	}

}
