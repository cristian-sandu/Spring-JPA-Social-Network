package com.usm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_FACULTY")
@AttributeOverride(name = "id", column = @Column(name = "faculty_id"))
public class Faculty extends AbstractDescribedEntity {

    /*Bidirectional ManyToOne, that's the owning side,
    * Many Faculties can be inside one building*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    /*Bidirectional OneToMany, that's the non-owning side
    * One Faculty might have information about many specialties that it contains*/
    @OneToMany(mappedBy = "faculties", targetEntity = Specialty.class, fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private Set<Specialty> specialties = new HashSet<Specialty>();

    public Faculty() {
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Faculty faculty = (Faculty) o;

        if (!building.equals(faculty.building)) return false;
        return specialties.equals(faculty.specialties);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + building.hashCode();
        result = 31 * result + specialties.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "building=" + building +
                ", specialties=" + specialties +
                '}';
    }
}