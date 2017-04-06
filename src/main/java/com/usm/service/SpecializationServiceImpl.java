package com.usm.service;

import com.usm.dao.SpecializationDAO;
import com.usm.model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("specializationService")
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    SpecializationDAO specialization;

    public Specialization findById(Long id) {
        return specialization.findById(id);
    }

    public Long persist(Specialization entity) {
        return specialization.persist(entity);
    }

    public void merge(Specialization entity) {
        specialization.merge(entity);
    }

    public void remove(Specialization entity) {
        specialization.remove(entity);
    }

    public void removeById(Long id) {
        specialization.removeById(id);
    }

    public List<Specialization> getAll() {
        return specialization.getAll();
    }
}