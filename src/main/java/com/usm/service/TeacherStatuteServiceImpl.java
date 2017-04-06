package com.usm.service;

import com.usm.dao.TeacherDAO;
import com.usm.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("teacherStatuteService")
@Transactional
public class TeacherStatuteServiceImpl implements TeacherService {

    @Autowired
    TeacherDAO teacher;

    public Teacher findById(Long id) {
        return teacher.findById(id);
    }

    public Long persist(Teacher entity) {
        return teacher.persist(entity);
    }

    public void merge(Teacher entity) {
        teacher.merge(entity);
    }

    public void remove(Teacher entity) {
        teacher.remove(entity);
    }

    public void removeById(Long id) {
        teacher.removeById(id);
    }

    public List<Teacher> getAll() {
        return teacher.getAll();
    }
}