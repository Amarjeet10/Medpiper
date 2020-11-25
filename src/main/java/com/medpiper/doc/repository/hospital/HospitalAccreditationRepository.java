package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalAccreditation;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalAccreditationRepository extends JpaRepository<HospitalAccreditation,Integer>
{
    @Query(value="SELECT * FROM hospital_accreditation_collaboration_empanelment d WHERE d.hospital_id=?1",nativeQuery = true)
    List<HospitalAccreditation> getHospitalAccreditation(@Param("hospital_id") int hospitalId) throws ResourceNotFoundException;
}
