package com.medpiper.doc.domain.hospital;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HOSPITAL_POSTED_JOBS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"jobTitle","jobId","hospital_id"})
)
@lombok.Data
public class HospitalPostJob
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalJobId;

    private String jobTitle;
    private String jobId;
    private String branch;
    private Date jobFrom;
    private Date jobTo;
    private String jobLocation;
    private String jobDepartment;
    private String jobPay;
    private String jobDepartmentContact;
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
    @JoinColumn(name = "hospital_id")
    private HospitalBasicInfo hospital;

}
