package com.usm.service;

import com.usm.model.Group;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface GroupService {
    Group findById(Long id);

    Long persist(final Group entity);

    void merge(final Group entity);

    void remove(final Group entity);

    void removeById(final Long id);

    List<Group> getAll();
}