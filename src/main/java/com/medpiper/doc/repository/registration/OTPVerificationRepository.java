package com.medpiper.doc.repository.registration;

import com.medpiper.doc.domain.Registration.OTPVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPVerificationRepository extends JpaRepository<OTPVerification,Integer>
{

}
