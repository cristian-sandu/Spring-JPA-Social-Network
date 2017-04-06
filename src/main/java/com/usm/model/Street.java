package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "T_STREET")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "street_id")),
        @AttributeOverride(name = "name", column = @Column(name = "street_name"))
})
@NamedQueries
        ({
                @NamedQuery(name = "Street.getAll", query = "from  Street")
        })
public class Street extends AbstractNamedEntity {

    @Column(nullable = false)
    private String street_number;

    @Column(nullable = true, unique = false)
    private String post_code;

    public Street() {
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

}