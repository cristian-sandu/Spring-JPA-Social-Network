package com.usm.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 * Created by csandu on 04.04.2017.
 */
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseModel {

    @Column(nullable = false, unique = false, length = 300)
    private String name;

    public AbstractNamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractNamedEntity that = (AbstractNamedEntity) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "AbstractNamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}