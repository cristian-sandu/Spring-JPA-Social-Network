package com.usm.dao.impl;

import com.usm.dao.StreetDAO;
import com.usm.model.Street;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("streetDAO")
public class StreetDAOImpl extends AbstractBaseDAO<Street> implements StreetDAO {
    @Override
    public Street findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Street entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Street entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Street entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Street> getAll() {
        return super.getAll();
    }
}