package com.usm.service;

import com.usm.model.Street;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface StreetService {
    Street findById(Long id);

    Long persist(final Street entity);

    void merge(final Street entity);

    void remove(final Street entity);

    void removeById(final Long id);

    List<Street> getAll();
}