package com.medpiper.doc.domain.doctor;

import com.medpiper.doc.domain.hospital.HospitalBasicInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DOCTOR_POSTED_JOBS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"jobTitle","jobId","doctor_id"}))
@lombok.Data
public class DoctorPostJob
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorJobId;

    private String jobTitle;
    private String jobId;
    private String hospitalName;
    private Date jobFrom;
    private Date jobTo;
    private String jobLocation;
    private String jobDepartment;
    private String jobPay;
    private String jobContact;
    private String jobType;
    private String food;
    private String jobDetails;
    private String accomodation;
    private int noOfBeds;
    private String requirements;
    private String mlcHistory;
    private String yearsOfExperience;
    private String expectedFootfall;
    private String dutyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DoctorBasicInfo doctor;
}
