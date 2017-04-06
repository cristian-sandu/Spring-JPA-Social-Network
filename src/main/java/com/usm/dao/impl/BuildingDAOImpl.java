package com.usm.dao.impl;

import com.usm.dao.BuildingDAO;
import com.usm.model.Building;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by csandu on 04.04.2017.
 */
@Repository("buildingDAO")
public class BuildingDAOImpl extends AbstractBaseDAO<Building> implements BuildingDAO {
    @Override
    public Building findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Long persist(Building entity) {
        return super.persist(entity);
    }

    @Override
    public void merge(Building entity) {
        super.merge(entity);
    }

    @Override
    public void remove(Building entity) {
        super.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

    @Override
    public List<Building> getAll() {
        return super.getAll();
    }
}