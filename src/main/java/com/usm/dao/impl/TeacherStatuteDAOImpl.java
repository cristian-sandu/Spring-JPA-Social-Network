package com.usm.dao.impl;

import com.usm.dao.TeacherStatuteDAO;
import com.usm.model.TeacherStatute;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("teacherStatuteDAO")
public class TeacherStatuteDAOImpl extends AbstractBaseDAO<TeacherStatute> implements TeacherStatuteDAO {
    @Override
    public TeacherStatute findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(TeacherStatute entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(TeacherStatute entity) {
        super.merge(entity);
    }

    @Override
    public void remove(TeacherStatute entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<TeacherStatute> getAll() {
        return super.getAll();
    }
}