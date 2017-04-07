package com.usm.security;

import com.usm.model.Role;
import com.usm.model.User;
import com.usm.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger rootLogger = LogManager.getRootLogger();

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*A call to Business Logic to verify inside if there is an actual user with coresponding name*/
        User securityUser = userService.findUserByUsername(username);

        if (securityUser == null) {
            rootLogger.info("Can't find A valid User with Username =>> " + username);
            throw new UsernameNotFoundException("Username NotFound in System !");
        }
        rootLogger.info("Retrieving A valid User with Username =>>  << " + securityUser.getUsername() + " >> and password => " + securityUser.getPassword() + "   from Business Logic");
        /*now if user exists and business logic returns true, it is time to return a real authorized user with valid credentials*/
        return new org.springframework.security.core.userdetails.User(securityUser.getUsername(), securityUser.getPassword(),
                true, true, true, true, getGrantedAuthorities(securityUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleType()));
        }
        rootLogger.info("Roles of User ==> " + user.getUsername() + " are => " + authorities);
        return authorities;
    }
}