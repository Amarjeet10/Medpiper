package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalBasicInfoRepository extends JpaRepository<HospitalBasicInfo,Integer>
{
}
