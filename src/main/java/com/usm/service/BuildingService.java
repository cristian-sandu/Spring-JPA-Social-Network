package com.usm.service;

import com.usm.model.Building;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface BuildingService {
    Building findById(Long id);

    Long persist(final Building entity);

    void merge(final Building entity);

    void remove(final Building entity);

    void removeById(final Long id);

    List<Building> getAll();
}