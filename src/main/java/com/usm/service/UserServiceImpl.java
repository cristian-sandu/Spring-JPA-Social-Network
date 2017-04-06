package com.usm.service;

import com.usm.dao.UserDAO;
import com.usm.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO user;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger rootLogger = LogManager.getRootLogger();

    public User findById(Long id) {
        return user.findById(id);
    }

    public Long persist(User entity) {
        rootLogger.info("Setting up a encoded password for User =>> " + entity.getUsername());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return user.persist(entity);
    }

    public void merge(User entity) {
        user.merge(entity);
    }

    public void remove(User entity) {
        user.remove(entity);
    }

    public void removeById(Long id) {
        user.removeById(id);
    }

    public List<User> getAll() {
        return user.getAll();
    }

    public User findUserByUsername(String username) {
        return user.findUserByUsername(username);
    }
}