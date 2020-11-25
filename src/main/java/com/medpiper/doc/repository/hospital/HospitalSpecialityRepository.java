package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalSpecialities;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalSpecialityRepository extends JpaRepository<HospitalSpecialities, Integer>
{
    @Query(value="SELECT * FROM hospital_speciality d WHERE d.hospital_id=?1",nativeQuery = true)
    List<HospitalSpecialities> getHospitalSpeciality(@Param("hospital_id") int hospitalId) throws ResourceNotFoundException;
}
