package com.usm.model;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by csandu on 29.03.2017.
 */

@Entity
@Table(name = "T_BUILDING")

@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "building_id")),
        @AttributeOverride(name = "name", column = @Column(name = "building_name"))
})
public class Building extends AbstractNamedEntity {

    /*Unidirectional ManyToOne mapping, that's the owning side
    * Many Buildings can be on the same address*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;

    /*Bidirectional ManyToOne mapping, that's the owning side
    * Many Buildings into one University*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "university_id")
    private University universities;

    /*Bidirectional Mapping, that's the non owning side of Table
    * One Building can have many Faculties into it */
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, targetEntity = Faculty.class)
    // target entity nu e obligatoriu, e destul mappedBy, dar cind avem generics
    // este bine sa specificam si targetEntity
    private Set<Faculty> faculties = new HashSet<Faculty>();

    public Building() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public University getUniversities() {
        return universities;
    }

    public void setUniversities(University universities) {
        this.universities = universities;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Building building = (Building) o;

        if (!address.equals(building.address)) return false;
        if (!universities.equals(building.universities)) return false;
        return faculties.equals(building.faculties);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + universities.hashCode();
        result = 31 * result + faculties.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Building{" +
                "address=" + address +
                ", universities=" + universities +
                ", faculties=" + faculties +
                '}';
    }
}