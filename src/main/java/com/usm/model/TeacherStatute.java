package com.usm.model;

import com.usm.model.enums.TeacherStatuteType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_STATUTE")
@AttributeOverride(name = "id", column = @Column(name = "statute_id"))
@NamedQueries
        ({
                @NamedQuery(name = "TeacherStatute.getAll", query = "from  TeacherStatute")
        })
public class TeacherStatute extends AbstractBaseModel {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TeacherStatuteType teacherStatuteType;

    /*Bidirectional ManyToMany, that is the non owning side,
    * All statutes might know who are their corespondents teachers*/
    @ManyToMany(mappedBy = "statutes", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Teacher> teachers = new HashSet<Teacher>();

    public TeacherStatute() {
    }

    public TeacherStatuteType getTeacherStatuteType() {
        return teacherStatuteType;
    }

    public void setTeacherStatuteType(TeacherStatuteType teacherStatuteType) {
        this.teacherStatuteType = teacherStatuteType;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TeacherStatute that = (TeacherStatute) o;

        if (teacherStatuteType != that.teacherStatuteType) return false;
        return teachers.equals(that.teachers);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + teacherStatuteType.hashCode();
        result = 31 * result + teachers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TeacherStatute{" +
                "teacherStatuteType=" + teacherStatuteType +
                ", teachers=" + teachers +
                '}';
    }
}