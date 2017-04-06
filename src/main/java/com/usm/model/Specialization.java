package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "T_SPECIALIZATION")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "specialization_id")),
        @AttributeOverride(name = "name", column = @Column(name = "specialization_name"))
})
@NamedQueries
        ({
                @NamedQuery(name = "Specialization.getAll", query = "from  Specialization")
        })
public class Specialization extends AbstractNamedEntity {

    @Column(nullable = false, unique = false)
    private String year_of_study;

    /*Bidirectional ManyToOne, that's the owning side
    * Many specializations can be a part of the same specialty*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Specialty.class)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialties;

    public Specialization() {
    }

    public String getYear_of_study() {
        return year_of_study;
    }

    public void setYear_of_study(String year_of_study) {
        this.year_of_study = year_of_study;
    }

    public Specialty getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Specialty specialties) {
        this.specialties = specialties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Specialization that = (Specialization) o;

        if (!year_of_study.equals(that.year_of_study)) return false;
        return specialties.equals(that.specialties);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + year_of_study.hashCode();
        result = 31 * result + specialties.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                ", year_of_study='" + year_of_study + '\'' +
                ", specialties=" + specialties +
                '}';
    }
}