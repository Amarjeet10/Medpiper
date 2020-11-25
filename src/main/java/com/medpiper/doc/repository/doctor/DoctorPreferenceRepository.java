package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorPreference;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorPreferenceRepository extends JpaRepository<DoctorPreference,Integer>
{
    @Query(value="SELECT * FROM doctor_preference d WHERE d.doctor_id=?1",nativeQuery = true)
    public List<DoctorPreference> getDoctorPreferenceById(@Param("doctor_id") int doctorId) throws ResourceNotFoundException;
}
