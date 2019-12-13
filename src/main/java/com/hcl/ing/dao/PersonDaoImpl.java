package com.hcl.ing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hcl.ing.enity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person saved successfully!!!, Person Details = " + person);

	}

	public void updatePerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("Person updated successfully!!!, Person Details = " + person);

	}

	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personList = session.createQuery("from Person").list();
		for (Person person : personList) {
			logger.info("Person list:" + person);
		}
		return personList;
	}

	public Person getPersonById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Long(id));
		logger.info("Person loaded successfully, Person details = " + person);
		return person;
	}

	public void deletePerson(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Long(id));
		if (null != person) {
			session.delete(person);
		}
		logger.info("Person deleted successfully!!, Person Details = " + person);
	}

}
