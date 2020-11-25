package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorBasicInfoRepository extends JpaRepository<DoctorBasicInfo, Integer> {
}
