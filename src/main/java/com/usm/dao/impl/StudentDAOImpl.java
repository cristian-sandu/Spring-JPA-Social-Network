package com.usm.dao.impl;

import com.usm.dao.StudentDAO;
import com.usm.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("studentDAO")
public class StudentDAOImpl extends AbstractBaseDAO<Student> implements StudentDAO {
    @Override
    public Student findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Student entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Student entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Student entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Student> getAll() {
        return super.getAll();
    }
}