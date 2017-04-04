package com.usm.dao.impl;

/*
 * Created by csandu on 29.03.2017.
 */

import com.usm.dao.BaseDAO;
import com.usm.model.AbstractBaseModel;
import org.hibernate.jpa.HibernateEntityManager;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractBaseDAO<T extends AbstractBaseModel> implements BaseDAO<T> {

    @PersistenceContext
    public HibernateEntityManager entityManager;

    private Class<T> entityType;

    @SuppressWarnings("unchecked")
    public AbstractBaseDAO() {
        this.entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public AbstractBaseDAO(Class<T> entityType) {
        this.entityType = entityType;
    }

    public T findById(Long id) {
        return entityManager.find(entityType, id);
    }

    public Long persist(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity.getId();
    }

    public void merge(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public void removeById(Long id) {
        T entity = findById(id);
        if (entity.getId() != null) {
            entityManager.remove(entity);
        } else
            throw new EntityNotFoundException("Entity with id << " + id + " >> is not found");
    }

    public List<T> getAll() {
        return entityManager.getNamedQuery("user.getAll").getResultList();
    }
}