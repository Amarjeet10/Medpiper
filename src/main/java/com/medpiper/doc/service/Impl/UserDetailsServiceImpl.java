package com.medpiper.doc.service.Impl;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.repository.registration.RegistrationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private RegistrationInfoRepository registrationInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        RegistrationInfo registrationInfo=registrationInfoRepository.findUserByEmail(s);
        if(registrationInfo==null)
        {
                throw new UsernameNotFoundException("User Not Found");
        }
        return new MyUserDetails(registrationInfo);

    }
}
