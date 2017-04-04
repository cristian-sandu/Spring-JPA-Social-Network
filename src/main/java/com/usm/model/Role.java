package com.usm.model;

import com.usm.model.enums.RoleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@Entity
@Table(name = "T_ROLE")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
public class Role extends AbstractBaseModel {

    @Column(name = "role_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /*Bidirectional Many To Many, that's the non-owning side
    * All Roles might have info about their candidates*/
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Role role = (Role) o;

        if (roleType != role.roleType) return false;
        return users.equals(role.users);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + roleType.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleType=" + roleType +
                ", users=" + users +
                '}';
    }
}