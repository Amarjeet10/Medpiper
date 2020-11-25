package com.medpiper.doc.domain.doctor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DOCTOR_EDUCATION",
        uniqueConstraints=@UniqueConstraint(columnNames={"educationDegree","doctor_id"}))
@lombok.Data

public class DoctorEducation
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationId;
    private String educationType;
    private String educationDegree;
    private Date educationDegreeFromDate;
    private Date educationDegreeToDate;
    private String educationUniversity;
    private String educationCountry;
    private String educationCity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id",nullable = false)
    private DoctorBasicInfo doctor;

}
