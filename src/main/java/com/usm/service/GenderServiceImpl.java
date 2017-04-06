package com.usm.service;

import com.usm.dao.GenderDAO;
import com.usm.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("genderService")
@Transactional
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderDAO gender;

    public Gender findById(Long id) {
        return gender.findById(id);
    }

    public Long persist(Gender entity) {
        return gender.persist(entity);
    }

    public void merge(Gender entity) {
        gender.merge(entity);
    }

    public void remove(Gender entity) {
        gender.remove(entity);
    }

    public void removeById(Long id) {
        gender.removeById(id);
    }

    public List<Gender> getAll() {
        return gender.getAll();
    }
}