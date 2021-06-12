package com.person.xml.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class PersonTag {

	@XmlAttribute(name = "name")
	String name;
	@XmlElement(name = "address")
	String address;
	@XmlElement(name = "phonenumber")
	String phonenumber;
	@XmlElement(name = "salary")
	String salary;
	@XmlElement(name = "pension")
	String pension;
	
	public PersonTag() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getSalary() {
		return salary;
	}

	public String getPension() {
		return pension;
	}
	
	@Override
	public String toString() {
		return "PersonTag [name=" + name + ", address=" + address + ", phonenumber=" + phonenumber + ", salary=" + salary
				+ ", pension=" + pension + "]";
	}
	
}
