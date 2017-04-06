package com.usm.service;

import com.usm.dao.BuildingDAO;
import com.usm.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by csandu on 05.04.2017.
 */
@Service("buildingService")
@Transactional
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingDAO building;

    public Building findById(Long id) {
        return building.findById(id);
    }

    public Long persist(Building entity) {
        return building.persist(entity);
    }

    public void merge(Building entity) {
        building.merge(entity);
    }

    public void remove(Building entity) {
        building.remove(entity);
    }

    public void removeById(Long id) {
        building.removeById(id);
    }

    public List<Building> getAll() {
        return building.getAll();
    }
}