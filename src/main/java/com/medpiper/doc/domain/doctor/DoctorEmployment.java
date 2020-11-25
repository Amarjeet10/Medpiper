package com.medpiper.doc.domain.doctor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DOCTOR_EMPLOYMENT",
        uniqueConstraints=@UniqueConstraint(columnNames={"employmentType","employmentPosition","employmentFromDate","employmentToDate","doctor_id"}))
@lombok.Data
public class DoctorEmployment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employmentId;

    private String employmentType;
    private String employmentPosition;
    private Date employmentFromDate;
    private Date employmentToDate;
    private String employmentTrainingCurrentEmployer;
    private String employmentEmployer;
    private String employmentCountry;
    private String employmentCity;
    private String employmentKeyResponsibilities;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id",nullable = false)
    private DoctorBasicInfo doctor;

}
