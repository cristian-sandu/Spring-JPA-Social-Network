package com.usm.service;

import com.usm.model.Faculty;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface FacultyService {
    Faculty findById(Long id);

    Long persist(final Faculty entity);

    void merge(final Faculty entity);

    void remove(final Faculty entity);

    void removeById(final Long id);

    List<Faculty> getAll();
}
