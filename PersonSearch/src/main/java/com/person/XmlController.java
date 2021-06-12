package com.person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.atteo.xmlcombiner.XmlCombiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.person.xml.pojo.PersonDataTag;
import com.person.xml.pojo.PersonTag;

@RestController
public class XmlController {
	
	@Autowired
	private PersonService service;
	
	@RequestMapping("/xml/merge")
	public void xmlMerge() {
		// create combiner
		XmlCombiner combiner = null;

		try {
			combiner = new XmlCombiner("name");

			// combine files
			combiner.combine(Paths.get("E:\\GANESH\\Studies\\OpenProject\\First.xml"));
			combiner.combine(Paths.get("E:\\GANESH\\Studies\\OpenProject\\Second.xml"));

			// store the result
			combiner.buildDocument(Paths.get("E:\\GANESH\\Studies\\OpenProject\\Final.xml"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/xml/insert")
	public void xmlInsert() throws JAXBException {
		File file = new File("E:\\GANESH\\Studies\\OpenProject\\Final.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(PersonDataTag.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		PersonDataTag personsTag = (PersonDataTag) jaxbUnmarshaller.unmarshal(file);
		List<Person> persons = new ArrayList<>();
		for(PersonTag p : personsTag.getEmployees()) {
			persons.add(new Person(p.getName(), p.getAddress(), p.getPhonenumber(), p.getSalary(), p.getPension()));
		}
		service.insert(persons);
	}

}
