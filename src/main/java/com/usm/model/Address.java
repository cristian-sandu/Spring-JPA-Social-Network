package com.usm.model;

import javax.persistence.*;
import java.io.Serializable;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_ADRESS")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
public class Address extends AbstractBaseModel {

    /*Unidirectional ManyToOne Mapping, that's the owning side
    * Many Addresses can have the same city*/
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    /* Unidirectional ManyToOne Mapping, that's the owning side
    * Many Addresses can have the same street*/
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    public Address() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Address address = (Address) o;

        if (!city.equals(address.city)) return false;
        return street.equals(address.street);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", street=" + street +
                '}';
    }
}