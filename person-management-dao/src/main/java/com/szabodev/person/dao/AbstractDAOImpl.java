package com.szabodev.person.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {

    private Class<T> entityClass;
    private static final Logger logger = LoggerFactory.getLogger(AbstractDAOImpl.class);

    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract SessionFactory sessionFactory();

    @SuppressWarnings("unchecked")
    @Override
    public Integer save(final T o) {
        logger.debug("saving Entity: " + o);
        return (Integer) sessionFactory().getCurrentSession().save(o);
    }

    @Override
    public void delete(final Object object) {
        logger.debug("delete Entity: " + object);
        sessionFactory().getCurrentSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(final Integer id) {
        logger.debug("searching entity with id: " + id);
        return (T) sessionFactory().getCurrentSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T merge(T o) {
        logger.debug("merging Entity: " + o);
        return (T) sessionFactory().getCurrentSession().merge(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        logger.debug("saveOrUpdate Entity: " + o);
        sessionFactory().getCurrentSession().saveOrUpdate(o);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        logger.debug("list Entities");
        Session session = sessionFactory().getCurrentSession();
        Criteria crit = session.createCriteria(entityClass);
        return crit.list();
    }
}
