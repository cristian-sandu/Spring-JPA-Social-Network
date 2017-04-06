package com.usm.service;

import com.usm.model.City;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface CityService {
    City findById(Long id);

    Long persist(final City entity);

    void merge(final City entity);

    void remove(final City entity);

    void removeById(final Long id);

    List<City> getAll();
}