package com.usm.service;

import com.usm.dao.ClassroomDAO;
import com.usm.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomDAO classroom;

    public Classroom findById(Long id) {
        return classroom.findById(id);
    }

    public Long persist(Classroom entity) {
        return classroom.persist(entity);
    }

    public void merge(Classroom entity) {
        classroom.merge(entity);
    }

    public void remove(Classroom entity) {
        classroom.remove(entity);
    }

    public void removeById(Long id) {
        classroom.removeById(id);
    }

    public List<Classroom> getAll() {
        return classroom.getAll();
    }
}