package com.usm.model;

import com.usm.model.enums.GendersType;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_GENDER")
@AttributeOverride(name = "id", column = @Column(name = "gender_id"))
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Gender gender = (Gender) o;

        return gendersType == gender.gendersType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + gendersType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gendersType=" + gendersType +
                '}';
    }
}