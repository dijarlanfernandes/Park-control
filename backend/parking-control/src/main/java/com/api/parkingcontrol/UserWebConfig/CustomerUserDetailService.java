package com.api.parkingcontrol.UserWebConfig;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EnableWebSecurity
public  interface CustomerUserDetailService extends UserDetailsService{

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {       
        return null;
    }

    
}
