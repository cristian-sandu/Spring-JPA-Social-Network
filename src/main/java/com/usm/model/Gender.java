package com.usm.model;

import com.usm.model.enums.GendersType;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_GENDER")
@AttributeOverride(name = "id", column = @Column(name = "gender_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Gender.getAll", query = "from  Gender")
        })
public class Gender extends AbstractBaseModel {

    /*ENUMS !!!!!!!!!!
    * THREAD SAFE AND MANY OTHER GOOD THINGS*/
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private GendersType gendersType;

    public Gender() {
    }

    public GendersType getGendersType() {
        return gendersType;
    }

    public void setGendersType(GendersType gendersType) {
        this.gendersType = gendersType;
    }

}