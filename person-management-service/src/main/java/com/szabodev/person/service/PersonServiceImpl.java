package com.szabodev.person.service;

import com.szabodev.person.dao.PersonDAO;
import com.szabodev.person.model.Person;
import com.szabodev.person.service.dto.PersonDTO;
import com.szabodev.person.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addPerson(PersonDTO p) {
        Person person = PersonMapper.INSTANCE.toEntity(p);
        this.personDAO.saveOrUpdate(person);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonDTO> listPersons() {
        List<Person> all = this.personDAO.getAll();
        return PersonMapper.INSTANCE.toDTOs(all);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updatePerson(PersonDTO p) {
        Person person = PersonMapper.INSTANCE.toEntity(p);
        this.personDAO.saveOrUpdate(person);
    }

    @Override
    public void deletePerson(PersonDTO p) {
        Person person = PersonMapper.INSTANCE.toEntity(p);
        this.personDAO.delete(person);
    }

}
