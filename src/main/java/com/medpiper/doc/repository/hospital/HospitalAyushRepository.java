package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalAyush;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface HospitalAyushRepository extends JpaRepository<HospitalAyush,Integer>
{
    @Query(value="SELECT * FROM hospital_ayush d WHERE d.hospital_id=?1",nativeQuery = true)
    List<HospitalAyush> getHospitalAyush(@PathVariable("hospital_id") int hospitalId) throws ResourceNotFoundException;
}
