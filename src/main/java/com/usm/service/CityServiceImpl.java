package com.usm.service;

import com.usm.dao.CityDAO;
import com.usm.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityDAO city;

    public City findById(Long id) {
        return city.findById(id);
    }

    public Long persist(City entity) {
        return city.persist(entity);
    }

    public void merge(City entity) {
        city.merge(entity);
    }

    public void remove(City entity) {
        city.remove(entity);
    }

    public void removeById(Long id) {
        city.removeById(id);
    }

    public List<City> getAll() {
        return city.getAll();
    }
}
