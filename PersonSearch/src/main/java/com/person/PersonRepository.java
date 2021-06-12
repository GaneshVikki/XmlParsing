package com.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
//	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//			+ " OR p.brand LIKE %?1%"
//			+ " OR p.madein LIKE %?1%"
//			+ " OR CONCAT(p.price, '') LIKE %?1%")
	@Query("SELECT p FROM Person p WHERE CONCAT(p.name, ' ', p.address, ' ', p.phonenumber, ' ', p.salary, ' ', p.pension) LIKE %?1%")
	public List<Person> search(String keyword);
}
