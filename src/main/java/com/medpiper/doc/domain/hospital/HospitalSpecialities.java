package com.medpiper.doc.domain.hospital;

import javax.persistence.*;

@Entity
@Table(name="HOSPITAL_SPECIALITY",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"hospitalSpeciality","hospital_id"}))
@lombok.Data
public class HospitalSpecialities
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalSpecialityId;

    private String hospitalSpeciality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id",nullable = false)
    private HospitalBasicInfo hospital;
}
