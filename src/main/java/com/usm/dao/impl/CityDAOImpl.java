package com.usm.dao.impl;

import com.usm.dao.CityDAO;
import com.usm.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("cityDAO")
public class CityDAOImpl extends AbstractBaseDAO<City> implements CityDAO {
    @Override
    public City findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(City entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(City entity) {
        super.merge(entity);
    }

    @Override
    public void remove(City entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<City> getAll() {
        return super.getAll();
    }
}