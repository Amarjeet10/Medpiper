package com.medpiper.doc.service.Impl;

import com.medpiper.doc.domain.Registration.OTPVerification;
import com.medpiper.doc.repository.registration.OTPVerificationRepository;
import com.medpiper.doc.service.OTPVerificationService;
import org.springframework.stereotype.Service;

@Service
public class OTPVerificationServiceImpl implements OTPVerificationService
{
    private OTPVerificationRepository otpVerificationRepository;

    @Override
    public OTPVerification saveOTP(OTPVerification otpVerification)
    {
        return otpVerificationRepository.save(otpVerification);

    }
}
