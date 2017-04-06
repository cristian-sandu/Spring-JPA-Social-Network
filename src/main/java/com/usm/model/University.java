package com.usm.model;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_UNIVERSITY")
@AttributeOverride(name = "id", column = @Column(name = "university_id"))
@NamedQueries
        ({
                @NamedQuery(name = "University.getAll", query = "from  University")
        })
public class University extends AbstractDescribedEntity {

    /*Unidirectional OneToOne, that's the owning side
    * Each University has a unique address, and Vice Versa
    * There cannot be USM and UTM Universities at the same addresses,
    * How the fuck do you imagine that ? xD*/
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false, unique = false)
    private Address address;

    public University() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        University that = (University) o;

        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "address=" + address +
                '}';
    }
}