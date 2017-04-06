package com.usm.model;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_SPECIALTY")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "specialty_id")),
        @AttributeOverride(name = "name", column = @Column(name = "specialty_name"))
})
@NamedQueries
        ({
                @NamedQuery(name = "Specialty.getAll", query = "from  Specialty")
        })
public class Specialty extends AbstractNamedEntity {

    /*Bidirectional ManyToOne, that's the owning side
    * Many Specialties can be a part of the same faculty*/
    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false, unique = false)
    private Faculty faculties;

    public Specialty() {
    }

    public Faculty getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Specialty specialty = (Specialty) o;

        return faculties.equals(specialty.faculties);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + faculties.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                ", faculties=" + faculties +
                '}';
    }
}