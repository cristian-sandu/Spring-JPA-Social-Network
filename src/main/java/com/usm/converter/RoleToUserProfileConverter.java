package com.usm.converter;

import com.usm.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {
/*
    @Autowired
	UserProfileService userProfileService;

	*/

    /**
     * Gets UserProfile by Id
     *
     * @see org.springframework.core.convert.converter.Converter#convert(Object)
     *//*
	public Role convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Role profile= userProfileService.findById(id);
		return profile;
	}
	*/
    public Role convert(Object o) {
        return null;
    }
}