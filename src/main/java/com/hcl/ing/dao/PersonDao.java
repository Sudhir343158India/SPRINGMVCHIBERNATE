package com.hcl.ing.dao;

import java.util.List;

import com.hcl.ing.enity.Person;

public interface PersonDao {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(long id);

	public void deletePerson(long id);

}
