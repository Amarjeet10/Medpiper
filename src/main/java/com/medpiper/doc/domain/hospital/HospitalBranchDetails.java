package com.medpiper.doc.domain.hospital;

import javax.persistence.*;

@Entity
@Table(name="HOSPITAL_BRANCH_DETAILS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"hospital_id"}))
@lombok.Data
public class HospitalBranchDetails
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int hospitalBranchId;

    private String infoAddress;
    private String infoTownCity;
    private String infoState;
    private int infoPincode;
    private String infoDistrict;
    private String infoEstablishedYear;
    private String infoSubDistrict;
    private String infoHospitalRegistrationNo;

    private int contactLandLine;
    private String contactHospitalSecondaryEmail;
    private int contactMobileNumber;
    private String contactWebsite;
    private int contactEmergencynumber;
    private String contactName;
    private int contactHelpLineNumber;
    private String contactDesignation;

    private String healthCareProviderType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id",nullable = false)
    private HospitalBasicInfo hospital;


}
