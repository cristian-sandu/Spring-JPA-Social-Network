package com.usm.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        City city = (City) o;

        return country.equals(city.country);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                ", country=" + country +
                '}';
    }
}