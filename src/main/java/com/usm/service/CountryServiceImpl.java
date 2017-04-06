package com.usm.service;

import com.usm.dao.CountryDAO;
import com.usm.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDAO country;

    public Country findById(Long id) {
        return country.findById(id);
    }

    public Long persist(Country entity) {
        return country.persist(entity);
    }

    public void merge(Country entity) {
        country.merge(entity);
    }

    public void remove(Country entity) {
        country.remove(entity);
    }

    public void removeById(Long id) {
        country.removeById(id);
    }

    public List<Country> getAll() {
        return country.getAll();
    }
}