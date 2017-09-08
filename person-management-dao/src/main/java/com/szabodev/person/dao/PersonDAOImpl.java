package com.szabodev.person.dao;

import com.szabodev.person.model.Person;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl extends AbstractDAOImpl implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public PersonDAOImpl() {
        super(Person.class);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public SessionFactory sessionFactory() {
        return this.sessionFactory;
    }
}
