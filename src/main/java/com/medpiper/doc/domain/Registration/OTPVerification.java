package com.medpiper.doc.domain.Registration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OTP_VERIFICATION")
@lombok.Data
public class OTPVerification
{
    public static final String OTP = "otp";
    public static final String OTP_HASH = "otpHash";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition="TEXT")
    private String otpHash;

    private String otp;
    private Date expiry;
}
