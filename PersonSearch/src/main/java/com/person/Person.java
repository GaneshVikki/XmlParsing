package com.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	private Long id;
	private String name;
	private String address;
	private String phonenumber;
	private String salary;
	private String pension;
	
	protected Person() {
	}

	public Person(String name, String address, String phonenumber, String salary, String pension) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.salary = salary;
		this.pension = pension;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPension() {
		return pension;
	}

	public void setPension(String pension) {
		this.pension = pension;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", phonenumber=" + phonenumber
				+ ", salary=" + salary + ", pension=" + pension + "]";
	}

	
}
