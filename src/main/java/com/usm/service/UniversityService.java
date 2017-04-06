package com.usm.service;

import com.usm.model.University;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface UniversityService {
    University findById(Long id);

    Long persist(final University entity);

    void merge(final University entity);

    void remove(final University entity);

    void removeById(final Long id);

    List<University> getAll();
}