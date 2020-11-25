package com.medpiper.doc.service;

import com.medpiper.doc.domain.Registration.OTPVerification;

public interface OTPVerificationService
{
    OTPVerification saveOTP(OTPVerification otpVerification);
}
