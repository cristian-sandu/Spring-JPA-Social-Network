package com.usm.service;

import com.usm.dao.StudentDAO;
import com.usm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO student;

    public Student findById(Long id) {
        return student.findById(id);
    }

    public Long persist(Student entity) {
        return student.persist(entity);
    }

    public void merge(Student entity) {
        student.merge(entity);
    }

    public void remove(Student entity) {
        student.remove(entity);
    }

    public void removeById(Long id) {
        student.removeById(id);
    }

    public List<Student> getAll() {
        return student.getAll();
    }
}