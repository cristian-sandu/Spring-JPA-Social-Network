package com.usm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 * Created by csandu on 04.04.2017.
 */
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class AbstractNamedEntity extends AbstractBaseModel {

    @Column(nullable = false, unique = false, length = 300)
    private String name;

    public AbstractNamedEntity() {
    }
}