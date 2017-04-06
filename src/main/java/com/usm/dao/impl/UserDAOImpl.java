package com.usm.dao.impl;

import com.usm.dao.UserDAO;
import com.usm.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */

@Repository("userDAO")
public class UserDAOImpl extends AbstractBaseDAO<User> implements UserDAO {

    private static final Logger rootLogger = LogManager.getRootLogger();

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(User entity) {

        return super.persist(entity);
    }

    @Override
    public void merge(User entity) {
        super.merge(entity);
    }

    @Override
    public void remove(User entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    public User findUserByUsername(String username) {
        Query query = entityManager.createNamedQuery("User.getUserByUsername");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        if (user != null) {
            rootLogger.info("Loading User By Username ==>> " + username);
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }
}