package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorSkills;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorSkillsRepository extends JpaRepository<DoctorSkills,Integer>
{
    @Query(value="SELECT * FROM doctor_skills d WHERE d.doctor_id=?1",nativeQuery = true)
    List<DoctorSkills> getDoctorSkillsById(@Param("doctor_id") int doctorId) throws ResourceNotFoundException;
}
