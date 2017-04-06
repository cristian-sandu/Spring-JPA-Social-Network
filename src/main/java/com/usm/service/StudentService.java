package com.usm.service;

import com.usm.model.Student;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface StudentService {
    Student findById(Long id);

    Long persist(final Student entity);

    void merge(final Student entity);

    void remove(final Student entity);

    void removeById(final Long id);

    List<Student> getAll();
}