package com.hcl.ing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ing.dao.PersonDao;
import com.hcl.ing.enity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Transactional
	public void addPerson(Person person) {
		this.personDao.addPerson(person);
	}

	@Transactional
	public void updatePerson(Person person) {
		this.personDao.updatePerson(person);
	}

	@Transactional
	public List<Person> listPersons() {

		return this.personDao.listPersons();
	}

	@Transactional
	public Person getPersonById(long id) {

		return this.personDao.getPersonById(id);
	}

	@Transactional
	public void deletePerson(long id) {
		this.personDao.deletePerson(id);

	}

}
