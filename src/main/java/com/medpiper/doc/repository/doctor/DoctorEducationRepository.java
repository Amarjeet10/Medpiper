package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorEducation;
import com.medpiper.doc.domain.doctor.DoctorExam;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorEducationRepository extends JpaRepository<DoctorEducation,Integer>
{
    @Query(value="SELECT * FROM doctor_education d WHERE d.doctor_id=?1",nativeQuery = true)
    List<DoctorEducation> getDoctorEducationById(@Param("doctor_id") int doctorId) throws ResourceNotFoundException;

}
