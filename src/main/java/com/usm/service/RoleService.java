package com.usm.service;

import com.usm.model.Role;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
public interface RoleService {
    Role findById(Long id);

    Long persist(final Role entity);

    void merge(final Role entity);

    void remove(final Role entity);

    void removeById(final Long id);

    List<Role> getAll();
}
