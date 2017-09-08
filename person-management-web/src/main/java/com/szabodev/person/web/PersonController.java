package com.szabodev.person.web;

import com.szabodev.person.service.PersonService;
import com.szabodev.person.service.dto.PersonDTO;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@Scope(value = "request")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    private PersonDTO person;
    private List<PersonDTO> persons;

    @PostConstruct
    public void init() {
        persons = personService.listPersons();
        person = new PersonDTO();
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public List<PersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDTO> persons) {
        this.persons = persons;
    }

    public void addPerson() {
        personService.addPerson(person);
        init();
    }

    public void onRowEdit(RowEditEvent event) {
        logger.debug("onRowEdit called");
        PersonDTO editedPerson = (PersonDTO) event.getObject();
        personService.updatePerson(editedPerson);
        persons = personService.listPersons();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Person's details updated!"));
    }

    public void removePerson(PersonDTO person) {
        logger.debug("removePerson called");
        personService.deletePerson(person);
        persons = personService.listPersons();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Person's details deleted!"));
    }
}
