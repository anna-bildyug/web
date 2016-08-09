package by.home.simplewebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.home.simplewebapp.model.Person;

@Controller
@RequestMapping("/persons")
public class PersonsController {

	private static List<Person> persons = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		return new ModelAndView("persons", "persons", persons);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addPerson(@ModelAttribute("person") Person person, ModelMap model) {
		persons.add(person);
		model.addAttribute("person", new Person());
	}

	@ModelAttribute("person")
	public Person getPerson() {
		return new Person();
	}
}
