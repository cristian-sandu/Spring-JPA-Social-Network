package com.usm.service;

import com.usm.model.Teacher;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface TeacherService {
    Teacher findById(Long id);

    Long persist(final Teacher entity);

    void merge(final Teacher entity);

    void remove(final Teacher entity);

    void removeById(final Long id);

    List<Teacher> getAll();
}