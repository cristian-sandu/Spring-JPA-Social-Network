package com.usm.dao.impl;

import com.usm.dao.CountryDAO;
import com.usm.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("countryDAO")
public class CountryDAOImpl extends AbstractBaseDAO<Country> implements CountryDAO {
    @Override
    public Country findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Country entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Country entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Country entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Country> getAll() {
        return super.getAll();
    }
}