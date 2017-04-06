package com.usm.dao.impl;

import com.usm.dao.TeacherDAO;
import com.usm.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("teacherDAO")
public class TeacherDAOImpl extends AbstractBaseDAO<Teacher> implements TeacherDAO {
    @Override
    public Teacher findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Teacher entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Teacher entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Teacher entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return super.getAll();
    }
}