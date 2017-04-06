package com.usm.service;

import com.usm.dao.GroupDAO;
import com.usm.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDAO group;

    public Group findById(Long id) {
        return group.findById(id);
    }

    public Long persist(Group entity) {
        return group.persist(entity);
    }

    public void merge(Group entity) {
        group.merge(entity);
    }

    public void remove(Group entity) {
        group.remove(entity);
    }

    public void removeById(Long id) {
        group.removeById(id);
    }

    public List<Group> getAll() {
        return group.getAll();
    }
}