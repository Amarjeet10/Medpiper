package com.medpiper.doc.domain.hospital;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name="HOSPITAL_BASIC_INFO")
@lombok.Data
public class HospitalBasicInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalId;

    private String hospitalName;
    private String hospitalType;
    @Column(unique = true)
    private String hospitalsecondaryEmail;
}
