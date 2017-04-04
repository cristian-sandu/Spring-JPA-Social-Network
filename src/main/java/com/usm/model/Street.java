package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "T_STREET")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "street_id")),
        @AttributeOverride(name = "name", column = @Column(name = "street_name"))
})
public class Street extends AbstractNamedEntity {

    @Column(nullable = false)
    private String street_number;

    @Column(nullable = true, unique = false)
    private String post_code;

    public Street() {
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Street street = (Street) o;

        if (!street_number.equals(street.street_number)) return false;
        return post_code.equals(street.post_code);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + street_number.hashCode();
        result = 31 * result + post_code.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StreetDAO{" +
                ", street_number='" + street_number + '\'' +
                ", post_code='" + post_code + '\'' +
                '}';
    }
}