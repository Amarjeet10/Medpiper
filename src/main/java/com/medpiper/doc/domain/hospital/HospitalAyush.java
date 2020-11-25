package com.medpiper.doc.domain.hospital;

import javax.persistence.*;

@Entity
@Table(name="HOSPITAL_AYUSH",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"hospitalAyush","hospital_id"}))
@lombok.Data
public class HospitalAyush
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalAyushId;

    private String hospitalAyush;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id",nullable = false)
    private HospitalBasicInfo hospital;
}
