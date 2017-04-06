package com.usm.service;

import com.usm.dao.UniversityDAO;
import com.usm.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("universityService")
@Transactional
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityDAO university;

    public University findById(Long id) {
        return university.findById(id);
    }

    public Long persist(University entity) {
        return university.persist(entity);
    }

    public void merge(University entity) {
        university.merge(entity);
    }

    public void remove(University entity) {
        university.remove(entity);
    }

    public void removeById(Long id) {
        university.removeById(id);
    }

    public List<University> getAll() {
        return university.getAll();
    }

}