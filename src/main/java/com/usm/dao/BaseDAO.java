package com.usm.dao;

/*
 * Created by csandu on 29.03.2017.
 */

import com.usm.model.AbstractBaseModel;

import java.util.List;

public interface BaseDAO<T extends AbstractBaseModel> {

    //    No access modifiers, default package acces !

    T findById(Long id);

    Long persist(final T entity);

    void merge(final T entity);

    void remove(final T entity);

    void removeById(final Long id);

    List<T> getAll();

}