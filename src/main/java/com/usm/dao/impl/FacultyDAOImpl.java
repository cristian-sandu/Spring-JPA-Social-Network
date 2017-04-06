package com.usm.dao.impl;

import com.usm.dao.FacultyDAO;
import com.usm.model.Faculty;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("facultyDAO")
public class FacultyDAOImpl extends AbstractBaseDAO<Faculty> implements FacultyDAO {
    @Override
    public Faculty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Faculty entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Faculty entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Faculty entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Faculty> getAll() {
        return super.getAll();
    }
}