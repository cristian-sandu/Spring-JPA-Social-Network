package com.usm.model;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_ADRESS")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Address.getAll", query = "from Address")
        })
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

}