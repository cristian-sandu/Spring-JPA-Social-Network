package com.usm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_GROUP")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "group_id")),
        @AttributeOverride(name = "name", column = @Column(name = "group_name"))
})
@NamedQueries
        ({
                @NamedQuery(name = "Group.getAll", query = "from  Group")
        })
public class Group extends AbstractNamedEntity {

    /*Unidirectional ManyToMany mapping, that's the owning side
    * Many Groups and Many Specializations between them*/
    @ManyToMany
    @JoinTable(
            name = "T_GROUP_SPECIALIZATION",
            joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")}
    )
    private Set<Specialization> specializations = new HashSet<Specialization>();

    /*Bidirectional One To Many, that the non-owning side
    * One Group might have information about students it contains*/
    @OneToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private Set<Student> students = new HashSet<Student>();

    public Group() {
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Group group = (Group) o;

        if (!specializations.equals(group.specializations)) return false;
        return students.equals(group.students);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + specializations.hashCode();
        result = 31 * result + students.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                ", specializations=" + specializations +
                ", students=" + students +
                '}';
    }
}