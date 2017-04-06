package com.usm.service;

import com.usm.model.User;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
public interface UserService {
    User findById(Long id);

    Long persist(final User entity);

    void merge(final User entity);

    void remove(final User entity);

    void removeById(final Long id);

    List<User> getAll();

    User findUserByUsername(String username);
}