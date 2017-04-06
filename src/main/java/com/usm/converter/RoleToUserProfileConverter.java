package com.usm.converter;

import com.usm.model.Role;
import com.usm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*
 * A converter class used in views to map id's to actual userProfile objects.
 *
 * Gets UserProfile by Id
 *
 * @see org.springframework.core.convert.converter.Converter#convert(Object)
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;

    public Role convert(Object element) {
        Long id = Long.parseLong((String) element);
        Role role = roleService.findById(id);
        return role;
    }
}