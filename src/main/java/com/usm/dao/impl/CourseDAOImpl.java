package com.usm.dao.impl;

import com.usm.dao.CourseDAO;
import com.usm.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("courseDAO")
public class CourseDAOImpl extends AbstractBaseDAO<Course> implements CourseDAO {
    @Override
    public Course findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Course entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Course entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Course entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Course> getAll() {
        return super.getAll();
    }
}