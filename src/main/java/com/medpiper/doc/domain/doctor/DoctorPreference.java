package com.medpiper.doc.domain.doctor;

import javax.persistence.*;

@Entity
@Table(name="DOCTOR_PREFERENCE",
        uniqueConstraints=@UniqueConstraint(columnNames={"jobPreferencePosition","doctor_id"}))
@lombok.Data
public class DoctorPreference
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preferenceId;

    private  int jobPreferencePosition;
    private  String jobPreferencePositionName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id", nullable = false)
    private DoctorBasicInfo doctor;
}
