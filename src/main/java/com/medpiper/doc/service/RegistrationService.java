package com.medpiper.doc.service;

import com.medpiper.doc.domain.Registration.RegistrationInfo;

import java.util.Date;

public interface RegistrationService
{
    RegistrationInfo saveUser(RegistrationInfo registrationInfo);
    RegistrationInfo findUserByEmail(String email);
    String getOtpOfEmail(String email);
    Date getOtpExpirationOfEmail(String email);
    int enableUser(String email);

}
