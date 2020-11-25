package com.medpiper.doc.domain.doctor;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medpiper.doc.domain.Registration.RegistrationInfo;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="DOCTOR_BASIC_INFO")
@lombok.Data
public class DoctorBasicInfo
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String profession;
    private String specialization;
    private String nationality;

    @Column(unique = true)
    private String email;

}
