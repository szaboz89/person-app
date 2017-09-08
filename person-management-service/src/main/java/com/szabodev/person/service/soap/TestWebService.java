package com.szabodev.person.service.soap;

import com.szabodev.person.business.PersonAppConfiguration;
import com.szabodev.person.service.PersonService;
import com.szabodev.person.service.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@SuppressWarnings("unused")
@Service
@WebService(serviceName = "testWebService")
public class TestWebService {

    private PersonAppConfiguration personAppConfiguration;

    private PersonService personService;

    @WebMethod(exclude = true)
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @WebMethod(exclude = true)
    @Autowired
    public void setPersonAppConfiguration(PersonAppConfiguration personAppConfiguration) {
        this.personAppConfiguration = personAppConfiguration;
    }

    @WebMethod
    public void loadConfiguration() {
        personAppConfiguration.loadProperties();
    }

    @WebMethod
    public String getProperty(String propertyName) {
        return personAppConfiguration.getProperty(propertyName);
    }

    @WebMethod
    public void addPerson(PersonDTO p) {
        personService.addPerson(p);
    }

    @WebMethod
    public List<PersonDTO> listPersons() {
        return personService.listPersons();
    }

    @WebMethod
    public void updatePerson(PersonDTO p) {
        personService.updatePerson(p);
    }

    @WebMethod
    public void deletePerson(PersonDTO p) {
        personService.deletePerson(p);
    }

}