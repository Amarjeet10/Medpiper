package com.medpiper.doc.domain.doctor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DOCTOR_LICENSE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"licenseName","licenseNumber","doctor_id"}))
@lombok.Data

public class DoctorLicense
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licenseId;

    private String licenseCountryIssue;
    private String licenseName;
    private String licenseNumber;
    private String licenseStatus;
    private Date licenseFromDate;
    private Date  licenseToDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id")
    private DoctorBasicInfo doctor;

}
