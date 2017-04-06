package com.usm.service;

/*
 * Created by csandu on 05.04.2017.
 */

import com.usm.model.Address;

import java.util.List;

public interface AddressService {
    Address findById(Long id);

    Long persist(final Address entity);

    void merge(final Address entity);

    void remove(final Address entity);

    void removeById(final Long id);

    List<Address> getAll();
}
