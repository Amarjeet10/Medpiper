package com.medpiper.doc.service.Impl;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class MyUserDetails implements UserDetails
{
    @Autowired
    private RegistrationInfo registrationInfo;

    public MyUserDetails(RegistrationInfo registrationInfo)
    {
        this.registrationInfo = registrationInfo;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {

        /*
        String roles = registrationInfo.getUserRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles));
        return authorities;

         */

        List<GrantedAuthority> authorities = new ArrayList<>();
        // Extract list of roles (ROLE_name)
        this.registrationInfo.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
