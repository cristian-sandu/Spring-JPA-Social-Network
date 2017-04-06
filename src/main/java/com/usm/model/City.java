package com.usm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_CITY")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "city_id")),
        @AttributeOverride(name = "name", column = @Column(name = "city_name"))
})
@NamedQueries
        ({
                @NamedQuery(name = "City.getAll", query = "from  City")
        })
public class City extends AbstractNamedEntity {

    /*Bidirectional ManyToOne mapping, that's the owning side
    * Many cities can be a part of the same country*/
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public City() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}