package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalFacilities;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalfacilityRepository extends JpaRepository<HospitalFacilities,Integer>
{
    @Query(value="SELECT * FROM hospital_facilities d WHERE d.hospital_id=?1",nativeQuery = true)
    List<HospitalFacilities> getHospitalFacilities(@Param("hospital_id") int hospitalId) throws ResourceNotFoundException;
}
