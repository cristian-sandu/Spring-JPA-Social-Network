package com.usm.dao.impl;

import com.usm.dao.ClassroomDAO;
import com.usm.model.Classroom;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("classroomDAO")
public class ClassroomDAOImpl extends AbstractBaseDAO<Classroom> implements ClassroomDAO {
    @Override
    public Classroom findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Classroom entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Classroom entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Classroom entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Classroom> getAll() {
        return super.getAll();
    }
}