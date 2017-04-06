package com.usm.service;

import com.usm.model.Gender;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface GenderService {
    Gender findById(Long id);

    Long persist(final Gender entity);

    void merge(final Gender entity);

    void remove(final Gender entity);

    void removeById(final Long id);

    List<Gender> getAll();
}