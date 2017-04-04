package com.usm.dao.impl;

import com.usm.dao.AddressDAO;
import com.usm.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */

@Repository
public class AddressDAOImpl extends AbstractBaseDAO<Address> implements AddressDAO {
    public AddressDAOImpl() {
        super();
    }

    public AddressDAOImpl(Class<Address> entityType) {
        super(entityType);
    }

    @Override
    public Address findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Address entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Address entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Address entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Address> getAll() {
        return super.getAll();
    }
}