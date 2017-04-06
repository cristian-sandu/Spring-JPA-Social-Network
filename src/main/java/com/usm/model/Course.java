package com.usm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_COURSE")
@AttributeOverrides
        ({
                @AttributeOverride(name = "id", column = @Column(name = "course_id")),
                @AttributeOverride(name = "name", column = @Column(name = "course_name"))
        })
@NamedQueries
        ({
                @NamedQuery(name = "Course.getAll", query = "from  Course")
        })
public class Course extends AbstractNamedEntity {

    @Column(nullable = false)
    private String credits;

    /*Bidirectional ManyToMany relations, that's the owning side,
    * Many Courses to different specializations and Vice-Versa*/
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Specialization.class)
    @JoinTable
            (
                    name = "T_COURSE_SPECIALIZATION",
                    joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
                    inverseJoinColumns = {@JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")}
            )
    private Set<Specialization> specializations = new HashSet<Specialization>();

    /*Bidirectional ManyToMany, that's the non-owning side
    * Many Courses vs Many Teachers & Vice Versa*/
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Teacher> teachers = new HashSet<Teacher>();

    /*Unidirectional ManyToMany relation, that's the single owning side,
    * Many Courses in different rooms*/
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Classroom.class)
    @JoinTable
            (
                    name = "T_COURSE_ROOM",
                    joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
                    inverseJoinColumns = {@JoinColumn(name = "classroom_id", referencedColumnName = "classroom_id")}
            )
    private Set<Classroom> classrooms = new HashSet<Classroom>();

    public Course() {
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Course course = (Course) o;

        if (!credits.equals(course.credits)) return false;
        if (!specializations.equals(course.specializations)) return false;
        if (!teachers.equals(course.teachers)) return false;
        return classrooms.equals(course.classrooms);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + credits.hashCode();
        result = 31 * result + specializations.hashCode();
        result = 31 * result + teachers.hashCode();
        result = 31 * result + classrooms.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "credits='" + credits + '\'' +
                ", specializations=" + specializations +
                ", teachers=" + teachers +
                ", classrooms=" + classrooms +
                '}';
    }
}
