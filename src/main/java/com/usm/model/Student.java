package com.usm.model;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "user_id"}))
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Student.getAll", query = "from  Student")
        })
public class Student extends AbstractBaseModel {

    @Column(columnDefinition = "boolean default false", nullable = true)
    private Boolean isHead = false;

    /*Bidirectional ManyToOne, that's the owning side
    * Many Students can be a part of the same group*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_id", nullable = false)
    private Group groups;

    /*Unidirectional Mappimg, that's the single owning side
    * A user can be a single teacher/student*/
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Student() {
    }

    public Group getGroups() {
        return groups;
    }

    public void setGroups(Group groups) {
        this.groups = groups;
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

        Student student = (Student) o;

        if (!groups.equals(student.groups)) return false;
        return user.equals(student.user);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + groups.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "groups=" + groups +
                ", user=" + user +
                '}';
    }
}