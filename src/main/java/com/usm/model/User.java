package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_USER")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverrides
        ({
                @AttributeOverride(name = "id", column = @Column(name = "user_id")),
                @AttributeOverride(name = "name", column = @Column(name = "firstName"))
        })
@NamedQueries
        ({
                @NamedQuery(name = "User.getAll", query = "from  User"),
                @NamedQuery(name = "User.getUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
        })
@Data
public class User extends AbstractNamedEntity {

    @Column(length = 200, nullable = false, unique = true)
    private String username;

    @Column(length = 255, nullable = false, unique = false)
    private String password;

    @Column(length = 300, nullable = false, unique = false)
    private String lastName;

    /*Unidirectional ManyToOne, that's the owning side
    * Many users can have the same gender*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", nullable = false, unique = false)
    private Gender genders;

    @Column(nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    @Column(nullable = false, unique = false)
    private String mobile_phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 500, unique = false, nullable = true)
    private String avatar;

    /*Unidirectional ManyToOne, that's the owning side
    * Many users can have the same address*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    /*Bidirectional ManyToMany, that's the owning side,
    * Many Users => Many Roles, got it ? */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Role.class)
    @JoinTable
            (
                    name = "T_USER_ROLE",
                    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
                    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
            )
    private List<Role> roles = new ArrayList<Role>();

    public User() {
    }
}