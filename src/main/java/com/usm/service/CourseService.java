package com.usm.service;

import com.usm.model.Course;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface CourseService {
    Course findById(Long id);

    Long persist(final Course entity);

    void merge(final Course entity);

    void remove(final Course entity);

    void removeById(final Long id);

    List<Course> getAll();
}
