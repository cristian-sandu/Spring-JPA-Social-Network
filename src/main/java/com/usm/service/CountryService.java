package com.usm.service;

import com.usm.model.Country;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface CountryService {
    Country findById(Long id);

    Long persist(final Country entity);

    void merge(final Country entity);

    void remove(final Country entity);

    void removeById(final Long id);

    List<Country> getAll();
}
