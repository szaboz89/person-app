package com.szabodev.person.service;


import com.szabodev.person.service.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    void addPerson(PersonDTO p);

    List<PersonDTO> listPersons();

    void updatePerson(PersonDTO p);

    void deletePerson(PersonDTO p);

}