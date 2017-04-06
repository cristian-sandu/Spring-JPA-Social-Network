package com.usm.dao.impl;

import com.usm.dao.GenderDAO;
import com.usm.model.Gender;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("genderDAO")
public class GenderDAOImpl extends AbstractBaseDAO<Gender> implements GenderDAO {
    @Override
    public Gender findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Gender entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Gender entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Gender entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Gender> getAll() {
        return super.getAll();
    }
}
