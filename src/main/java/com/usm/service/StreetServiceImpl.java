package com.usm.service;

import com.usm.dao.StreetDAO;
import com.usm.model.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csandu on 05.04.2017.
 */
@Service("streetService")
@Transactional
public class StreetServiceImpl implements StreetService {

    @Autowired
    StreetDAO street;

    public Street findById(Long id) {
        return street.findById(id);
    }

    public Long persist(Street entity) {
        return street.persist(entity);
    }

    public void merge(Street entity) {
        street.merge(entity);
    }

    public void remove(Street entity) {
        street.remove(entity);
    }

    public void removeById(Long id) {
        street.removeById(id);
    }

    public List<Street> getAll() {
        return street.getAll();
    }
}