package com.usm.service;

import com.usm.model.Specialization;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface SpecializationService {
    Specialization findById(Long id);

    Long persist(final Specialization entity);

    void merge(final Specialization entity);

    void remove(final Specialization entity);

    void removeById(final Long id);

    List<Specialization> getAll();
}