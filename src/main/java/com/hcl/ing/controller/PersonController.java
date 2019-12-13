package com.hcl.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.enity.Person;
import com.hcl.ing.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@Qualifier(value = "personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person) {
		if (person.getId() == 0) {
			// new person add it
			this.personService.addPerson(person);
			return "Person added successfully!!";
		} else {
			// existing person, update
			this.personService.updatePerson(person);
			return "Person updated successfully!!";
		}

	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") long id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("list of persons", this.personService.listPersons());
		return "Perosn updated successfully!!!";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPerson(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("list of Person", this.personService.listPersons());
		return "List of Person ";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") long id) {
		this.personService.deletePerson(id);
		return "Person deleted Successfully!!";
	}

}
