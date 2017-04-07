package com.usm.model;

import com.usm.model.enums.GendersType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/*
 * Created by csandu on 3/24/2017.
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_GENDER")
@AttributeOverride(name = "id", column = @Column(name = "gender_id"))
@NamedQueries
        ({
                @NamedQuery(name = "Gender.getAll", query = "from  Gender")
        })
@Data
public class Gender extends AbstractBaseModel {

    /*ENUMS !!!!!!!!!!
    * THREAD SAFE AND MANY OTHER GOOD THINGS*/
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private GendersType gendersType;

    public Gender() {
    }
}