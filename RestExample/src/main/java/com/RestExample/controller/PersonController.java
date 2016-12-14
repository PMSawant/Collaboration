package com.RestExample.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.RestExample.model.Person;
import com.RestExample.services.PersonService;

@RestController
public class PersonController {
@Autowired
private PersonService personService;

public PersonService getPersonService() {
	return personService;
}

public void setPersonService(PersonService personService) {
	this.personService = personService;
}
//http://localhost:8080/crudsampleapi/person - REST endpoint
//HTTp method GET
//Jackson - convert the list of person to JSON
@RequestMapping(value="/person",method=RequestMethod.GET)
public @ResponseBody List<Person> getAllPersons(){
	System.out.println(personService.getAllPersons());
	System.out.println("calling list method");
	return personService.getAllPersons();
}
@RequestMapping(value="/person/{id}",method=RequestMethod.GET)
public ResponseEntity<Person> getPersonById(@PathVariable(value="id") int id){
	Person person=personService.getPersonById(id);
	if(person==null)
		return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<Person>(person,HttpStatus.OK);
}

@RequestMapping(value="/person",method=RequestMethod.POST)
//RequestBody - to convert JSON data to java object
//ResponseBody -> servet to client
//RequestBody -> client to server
public ResponseEntity<Void> createPerson(@RequestBody Person person,
		UriComponentsBuilder build){
	personService.savePerson(person);
	HttpHeaders headers=new HttpHeaders();
	//http://localhost:8080/appname/person/210
	URI urilocation=
			build.path("/person/")
			.path(String.valueOf(person.getPersonId()))
			.build()
			.toUri();
	headers.setLocation(urilocation);
	return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
}


@RequestMapping(value="/person/{id}",method=RequestMethod.PUT)
public @ResponseBody ResponseEntity<Person> updatePerson(
		@PathVariable int id,@RequestBody Person person){
	//person -> from client
	//updatedPerson -> from database 
	Person updatedPerson=personService.updatePerson(id, person);
	if(person==null)
		return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<Person>(updatedPerson,HttpStatus.OK);
	
	
}

@RequestMapping(value={"/person/{id}"},method={RequestMethod.DELETE})
public ResponseEntity<Void> deletePerson(@PathVariable int id){

	Person person=personService.getPersonById(id);
	if(person==null)
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	personService.deletePerson(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
	
	
}
}

