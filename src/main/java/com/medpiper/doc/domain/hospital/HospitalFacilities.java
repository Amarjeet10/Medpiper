package com.medpiper.doc.domain.hospital;

import javax.persistence.*;

@Entity
@Table(name="HOSPITAL_FACILITIES",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"hospital_id"}))
@lombok.Data
public class HospitalFacilities
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityId;

    private int noOfDoctors;
    private int noOfMedicalConsultants;
    private int noOfBeds;
    private String emergencyServices;
    private String pharmacy;
    private String labs;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id",nullable = false)
    private HospitalBasicInfo hospital;

}
