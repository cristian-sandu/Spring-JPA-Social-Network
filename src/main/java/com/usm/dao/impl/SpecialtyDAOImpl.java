package com.usm.dao.impl;

import com.usm.dao.SpecialtyDAO;
import com.usm.model.Specialty;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("specialtyDAO")
public class SpecialtyDAOImpl extends AbstractBaseDAO<Specialty> implements SpecialtyDAO {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Specialty entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Specialty entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Specialty entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Specialty> getAll() {
        return super.getAll();
    }
}