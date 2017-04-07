package com.usm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_ADRESS")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Address.getAll", query = "from Address")
        })
@Data
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
}