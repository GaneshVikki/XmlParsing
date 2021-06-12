package com.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@Autowired
	private PersonService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Person> listPersons = service.listAll(keyword);
		model.addAttribute("listPersons", listPersons);
		model.addAttribute("keyword", keyword);
		return "index";
	}
}
