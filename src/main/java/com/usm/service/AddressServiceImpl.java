package com.usm.service;

import com.usm.dao.AddressDAO;
import com.usm.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAO address;

    public Address findById(Long id) {
        return address.findById(id);
    }

    public Long persist(Address entity) {
        return address.persist(entity);
    }

    public void merge(Address entity) {
        address.merge(entity);
    }

    public void remove(Address entity) {
        address.remove(entity);
    }

    public void removeById(Long id) {
        address.removeById(id);
    }

    public List<Address> getAll() {
        return address.getAll();
    }
}