package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
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
@Data
public class Street extends AbstractNamedEntity {

    @Column(nullable = false)
    private String street_number;

    @Column(nullable = true, unique = false)
    private String post_code;

    public Street() {
    }
}