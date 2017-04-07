package com.usm.model;

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
@Table(name = "T_COUNTRY")
@AttributeOverrides
        ({
                @AttributeOverride(name = "id", column = @Column(name = "country_id")),
                @AttributeOverride(name = "name", column = @Column(name = "country_name"))
        })
@NamedQueries
        ({
                @NamedQuery(name = "Country.getAll", query = "from  Country")
        })
@Data
public class Country extends AbstractNamedEntity {

    @Column(nullable = false)
    private String ISO;

    /*Bidirectional Mapping, that's the non owning side
    * One country can have many cities*/
    @OneToMany(mappedBy = "country", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = City.class)
    private List<City> cities = new ArrayList<City>();

    public Country() {
    }
}