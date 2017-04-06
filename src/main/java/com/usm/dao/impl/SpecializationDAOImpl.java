package com.usm.dao.impl;

import com.usm.dao.SpecializationDAO;
import com.usm.model.Specialization;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("specializationDAO")
public class SpecializationDAOImpl extends AbstractBaseDAO<Specialization> implements SpecializationDAO {
    @Override
    public Specialization findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Specialization entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Specialization entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Specialization entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Specialization> getAll() {
        return super.getAll();
    }
}