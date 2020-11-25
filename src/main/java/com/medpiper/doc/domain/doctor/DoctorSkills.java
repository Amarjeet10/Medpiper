package com.medpiper.doc.domain.doctor;

import javax.persistence.*;

@Entity
@Table(name="DOCTOR_SKILLS",
        uniqueConstraints=@UniqueConstraint(columnNames={"skills","doctor_id"}))
@lombok.Data
public class DoctorSkills
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillsId;
    private String skills;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id",nullable = false)
    private DoctorBasicInfo doctor;
}
