package com.medpiper.doc.domain.doctor;

import javax.persistence.*;

@Entity
@Table(name="DOCTOR_CONTACT_DETAILS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"doctor_id"}))
@lombok.Data
public class DoctorContactDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    private String primary_email;
    private String alternate_email;
    private Long phoneNo;
    private Long alternate_phoneNo;
    private String addressLine1;
    private String addressLine2;
    private String socialMedia;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",nullable = false)
    private DoctorBasicInfo doctor;
}
