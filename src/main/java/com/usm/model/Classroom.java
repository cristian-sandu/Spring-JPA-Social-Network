package com.usm.model;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_CLASSROOM")
@AttributeOverride(name = "id", column = @Column(name = "classroom_id"))
public class Classroom extends AbstractBaseModel {

    @Column(length = 100, nullable = false)
    private String number;

    public Classroom() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Classroom classroom = (Classroom) o;

        return number.equals(classroom.number);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "number='" + number + '\'' +
                '}';
    }
}
