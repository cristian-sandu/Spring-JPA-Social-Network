package com.usm.service;

import com.usm.dao.RoleDAO;
import com.usm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDao;

    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    public Long persist(Role entity) {
        return roleDao.persist(entity);
    }

    public void merge(Role entity) {
        roleDao.merge(entity);
    }

    public void remove(Role entity) {
        roleDao.remove(entity);
    }

    public void removeById(Long id) {
        roleDao.removeById(id);
    }

    public List<Role> getAll() {
        return roleDao.getAll();
    }
}