package com.usm.service;

import com.usm.dao.CourseDAO;
import com.usm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
* Created by csandu on 05.04.2017.
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDAO course;

    public Course findById(Long id) {
        return course.findById(id);
    }

    public Long persist(Course entity) {
        return course.persist(entity);
    }

    public void merge(Course entity) {
        course.merge(entity);
    }

    public void remove(Course entity) {
        course.remove(entity);
    }

    public void removeById(Long id) {
        course.removeById(id);
    }

    public List<Course> getAll() {
        return course.getAll();
    }
}