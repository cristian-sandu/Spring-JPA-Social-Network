package com.usm.dao.impl;

/*
 * Created by csandu on 29.03.2017.
 */

import com.usm.dao.BaseDAO;
import com.usm.model.AbstractBaseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractBaseDAO<T extends AbstractBaseModel> implements BaseDAO<T> {

    private static final Logger rootLogger = LogManager.getRootLogger();

    @PersistenceContext
    EntityManager entityManager;

    private final Class<T> entityType;

    @SuppressWarnings("unchecked")
    public AbstractBaseDAO() {
        this.entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public AbstractBaseDAO(Class<T> entityType) {
        this.entityType = entityType;
    }

    public T findById(Long id) {
        return entityManager.find(entityType, id);
    }

    public Long persist(T entity) {
        rootLogger.info(entityType.getName() + "Succesfully Persisted !!! ");
        entityManager.persist(entity);
        entityManager.flush();
        return entity.getId();
    }

    public void merge(T entity) {
        rootLogger.info(entityType.getName() + "Succesfully Updated !!! ");
        entityManager.merge(entity);
        entityManager.flush();
    }

    public void remove(T entity) {
        rootLogger.info(entityType.getName() + "Succesfully Removed !!! ");
        entityManager.remove(entity);
    }

    public void removeById(Long id) {
        T entity = findById(id);
        if (entity.getId() != null) {
            rootLogger.info(entityType.getName() + "Succesfully Removed Entity with Id " + id + " !!! ");
            entityManager.remove(entity);
        } else
            rootLogger.info(entityType.getName() + "Error in Removing Entity with Id " + id + " !!! ");
        throw new EntityNotFoundException("Entity with id << " + id + " >> is not found !!!");
    }

    public List<T> getAll() {
        rootLogger.info("Getting all entitites :" + entityType.getName());
        return entityManager.createNamedQuery(entityType.getName().substring(14) + ".getAll").getResultList();
    }
}