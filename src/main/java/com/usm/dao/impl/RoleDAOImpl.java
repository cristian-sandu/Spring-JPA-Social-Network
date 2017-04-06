package com.usm.dao.impl;

import com.usm.dao.RoleDAO;
import com.usm.model.Role;
import com.usm.model.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("roleDAO")
public class RoleDAOImpl extends AbstractBaseDAO<Role> implements RoleDAO {

    @Override
    public Role findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Role entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Role entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Role entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Role> getAll() {
        return super.getAll();
    }

}