package com.usm.service;

import com.usm.model.Classroom;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface ClassroomService {
    Classroom findById(Long id);

    Long persist(final Classroom entity);

    void merge(final Classroom entity);

    void remove(final Classroom entity);

    void removeById(final Long id);

    List<Classroom> getAll();
}