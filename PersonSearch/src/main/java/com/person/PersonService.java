package com.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repo;
	
	public List<Person> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return null;
	}
	
	public void insert(List<Person> persons) {
		repo.saveAll(persons);
	}
}
