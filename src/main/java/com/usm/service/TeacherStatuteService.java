package com.usm.service;

import com.usm.model.TeacherStatute;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface TeacherStatuteService {
    TeacherStatute findById(Long id);

    Long persist(final TeacherStatute entity);

    void merge(final TeacherStatute entity);

    void remove(final TeacherStatute entity);

    void removeById(final Long id);

    List<TeacherStatute> getAll();
}