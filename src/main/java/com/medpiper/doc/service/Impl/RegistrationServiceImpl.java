package com.medpiper.doc.service.Impl;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.repository.registration.RegistrationInfoRepository;
import com.medpiper.doc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class RegistrationServiceImpl implements RegistrationService
{
    @Autowired
    private RegistrationInfoRepository registrationInfoRepository;


    @Override
    public RegistrationInfo saveUser(RegistrationInfo registrationInfo)
    {
        return registrationInfoRepository.save(registrationInfo);

    }

    @Override
    public RegistrationInfo findUserByEmail(String email)
    {
        return registrationInfoRepository.findUserByEmail(email);
    }

    @Override
    public String getOtpOfEmail(String email)
    {
        String otp=registrationInfoRepository.getOtpOfEmail(email);
        return otp;
    }

    @Override
    public Date getOtpExpirationOfEmail(String email)
    {
        Date otpExpiryTime=registrationInfoRepository.getOtpExpirationOfEmail(email);
        return otpExpiryTime;
    }

    @Override
    public int enableUser(String email)
    {
        int enableuser= registrationInfoRepository.enableUser(email);
        return enableuser;
    }

}
