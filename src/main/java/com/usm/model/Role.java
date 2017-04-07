package com.usm.model;

import com.usm.model.enums.RoleType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Created by csandu on 3/24/2017.
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_ROLE")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Role.getAll", query = "from  Role")
        })
@Data
public class Role extends AbstractBaseModel {

    @Column(name = "role_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /*Bidirectional Many To Many, that's the non-owning side
    * All Roles might have info about their candidates*/
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> users = new ArrayList<User>();

    public Role() {
    }
}