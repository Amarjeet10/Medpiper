package com.medpiper.doc.domain.hospital;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HOSPITAL_ACCREDITATION_COLLABORATION_EMPANELMENT",
        uniqueConstraints=@UniqueConstraint(columnNames={"accreditation","collaboration","empanelment","hospital_id"}))
@lombok.Data
public class HospitalAccreditation
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accreditationId;

    private String accreditation;
    private Date accreditationFromDate;
    private Date accreditationToDate;

    private String collaboration;
    private Date collaborationFromDate;
    private Date collaborationToDate;

    private String empanelment;
    private Date empanelmentFromDate;
    private Date empanelmentToDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id",nullable = false)
    private HospitalBasicInfo hospital;

}
