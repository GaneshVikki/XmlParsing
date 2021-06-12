package com.person.xml.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salarydata")
public class PersonDataTag {
	
	@XmlElement(name = "person")
	private List<PersonTag> persons;
	
	public List<PersonTag> getEmployees() {
        return persons;
    }
	
	@Override
	public String toString() {
		return "PersonData [persons=" + persons + "]";
	}
}
