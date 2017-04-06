package com.usm.service;

import com.usm.dao.SpecialtyDAO;
import com.usm.model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
@Service("specialtyService")
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    SpecialtyDAO specialty;

    public Specialty findById(Long id) {
        return specialty.findById(id);
    }

    public Long persist(Specialty entity) {
        return specialty.persist(entity);
    }

    public void merge(Specialty entity) {
        specialty.merge(entity);
    }

    public void remove(Specialty entity) {
        specialty.remove(entity);
    }

    public void removeById(Long id) {
        specialty.removeById(id);
    }

    public List<Specialty> getAll() {
        return specialty.getAll();
    }
}