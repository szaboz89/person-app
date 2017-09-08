//package com.adev.example.dao;
//
//import Person;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Repository
//public class PersonDAOImpl2 implements PersonDAO {
//
//    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl2.class);
//
//    private List<Person> persons = new ArrayList<>();
//    private static final AtomicInteger counter = new AtomicInteger();
//
//    @Override
//    public Integer save(Object o) {
//        logger.debug("save Person: " + o);
//        Person person = (Person) o;
//        person.setId(counter.incrementAndGet());
//        persons.add(person);
//        return person.getId();
//    }
//
//    @Override
//    public void delete(Object object) {
//        logger.debug("delete: " + object);
//        Person person = (Person) object;
//        for (Iterator<Person> iter = persons.listIterator(); iter.hasNext(); ) {
//            Person actual = iter.next();
//            if (actual.getId().equals(person.getId())) {
//                iter.remove();
//            }
//        }
//    }
//
//    @Override
//    public Object get(Integer id) {
//        for (Person person : persons) {
//            if (person.getId().equals(id)) {
//                return person;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Object merge(Object o) {
//        logger.debug("merge");
//        Person person = (Person) o;
//        for (int i = 0; i < persons.size(); i++) {
//            if (persons.get(i).getId().equals(person.getId()))
//                persons.set(i, person);
//        }
//        return person;
//    }
//
//    @Override
//    public void saveOrUpdate(Object o) {
//        logger.debug("saveOrUpdate: " + o);
//        Person person = (Person) o;
//        if (person.getId() != null) {
//            logger.debug("updating..");
//            for (int i = 0; i < persons.size(); i++) {
//                if (persons.get(i).getId().equals(person.getId()))
//                    persons.set(i, person);
//            }
//        } else {
//            logger.debug("saving..");
//            person.setId(counter.incrementAndGet());
//            persons.add(person);
//        }
//
//    }
//
//    @Override
//    public List getAll() {
//        return persons;
//    }
//}