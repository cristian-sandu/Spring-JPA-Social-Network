package com.usm.dao;

import com.usm.model.User;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
public interface UserDAO extends BaseDAO<User> {
    User findUserByUsername(String username);
}