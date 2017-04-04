package com.usm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_COUNTRY")
@AttributeOverrides
        ({
                @AttributeOverride(name = "id", column = @Column(name = "country_id")),
                @AttributeOverride(name = "name", column = @Column(name = "country_name"))
        })
public class Country extends AbstractNamedEntity {

    @Column(nullable = false)
    private String ISO;

    /*Bidirectional Mapping, that's the non owning side
    * One country can have many cities*/
    @OneToMany
            (mappedBy = "country", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = City.class)
    private Set<City> cities = new HashSet<City>();

    public Country() {
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Country country = (Country) o;

        if (!ISO.equals(country.ISO)) return false;
        return cities.equals(country.cities);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ISO.hashCode();
        result = 31 * result + cities.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", ISO='" + ISO + '\'' +
                ", cities=" + cities +
                '}';
    }
}