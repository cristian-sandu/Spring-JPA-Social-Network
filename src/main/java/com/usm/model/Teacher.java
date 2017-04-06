package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_TEACHER", uniqueConstraints = @UniqueConstraint(columnNames = {"teacher_id", "user_id"}))
@AttributeOverride(name = "id", column = @Column(name = "teacher_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Teacher.getAll", query = "from  Teacher")
        })
public class Teacher extends AbstractBaseModel {

    /*Bidirectional ManyToMany, that's the owning side
    * Many Teachers can have different teacherStatutes at the same type
    * For example: DEAN and TEACHER*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (
                    name = "T_TEACHER_STATUTE",
                    joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", nullable = false)},
                    inverseJoinColumns = {@JoinColumn(name = "statute_id", referencedColumnName = "statute_id", nullable = false)}
            )
    private Set<TeacherStatute> statutes = new HashSet<TeacherStatute>();

    /*Bidirectional ManyToMany, that's the owning side
    * Many Teachers and Many Courses*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Course.class)
    @JoinTable(
            name = "T_TEACHER_COURSE",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")}
    )
    private Set<Course> courses = new HashSet<Course>();

    /*Unidirectional Mappimg, that's the single owning side
    * A user can be a single teacher/student*/

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Teacher() {
    }

    public Set<TeacherStatute> getStatutes() {
        return statutes;
    }

    public void setStatutes(Set<TeacherStatute> statutes) {
        this.statutes = statutes;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (!statutes.equals(teacher.statutes)) return false;
        if (!courses.equals(teacher.courses)) return false;
        return user.equals(teacher.user);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + statutes.hashCode();
        result = 31 * result + courses.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "statutes=" + statutes +
                ", courses=" + courses +
                ", user=" + user +
                '}';
    }
}