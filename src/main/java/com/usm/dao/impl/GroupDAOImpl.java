package com.usm.dao.impl;

import com.usm.dao.GroupDAO;
import com.usm.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("groupDAO")
public class GroupDAOImpl extends AbstractBaseDAO<Group> implements GroupDAO {
    @Override
    public Group findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Group entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Group entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Group entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Group> getAll() {
        return super.getAll();
    }
}