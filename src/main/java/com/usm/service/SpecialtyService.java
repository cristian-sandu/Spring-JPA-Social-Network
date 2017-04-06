package com.usm.service;

import com.usm.model.Specialty;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface SpecialtyService {
    Specialty findById(Long id);

    Long persist(final Specialty entity);

    void merge(final Specialty entity);

    void remove(final Specialty entity);

    void removeById(final Long id);

    List<Specialty> getAll();
}