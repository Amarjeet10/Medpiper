package com.medpiper.doc.domain.doctor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DOCTOR_EXAM",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"examTitle","memberShipTitle","certificateTitle","doctor_id"}))
@lombok.Data
public class DoctorExam{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    private String examTitle;
    private Date examFromDate;
    private Date examToDate;

    private String memberShipTitle;
    private Date membershipFromDate;
    private Date membershipToDate;

    private String certificateTitle;
    private Date certificateFromDate;
    private Date certificateToDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DoctorBasicInfo doctor;

}
