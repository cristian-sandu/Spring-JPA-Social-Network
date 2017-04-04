package com.usm.controller;

import com.usm.model.Classroom;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//---------------------------------------------------------------------//
//   Created with pleasure by Cristian on: 25-Mar-17 //
//---------------------------------------------------------------------//
@Controller
public class control {

    @PersistenceContext
    EntityManager entityManager;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String startWeb() {
        Classroom gender = new Classroom();
        gender.setNumber("sa");
        entityManager.persist(gender);
        return "login";
    }
}