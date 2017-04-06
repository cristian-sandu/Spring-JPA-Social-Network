package com.usm.dao.impl;

import com.usm.dao.UniversityDAO;
import com.usm.model.University;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("universityDAO")
public class UniversityDAOImpl extends AbstractBaseDAO<University> implements UniversityDAO {
    @Override
    public University findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(University entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(University entity) {
        super.merge(entity);
    }

    @Override
    public void remove(University entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<University> getAll() {
        return super.getAll();
    }
}