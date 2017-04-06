package com.usm.service;

import com.usm.dao.FacultyDAO;
import com.usm.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("facultyService")
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyDAO faculty;

    public Faculty findById(Long id) {
        return faculty.findById(id);
    }

    public Long persist(Faculty entity) {
        return faculty.persist(entity);
    }

    public void merge(Faculty entity) {
        faculty.merge(entity);
    }

    public void remove(Faculty entity) {
        faculty.remove(entity);
    }

    public void removeById(Long id) {
        faculty.removeById(id);
    }

    public List<Faculty> getAll() {
        return faculty.getAll();
    }
}