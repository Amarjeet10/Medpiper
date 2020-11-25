package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorPostJob;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DoctorPostJobRepository extends JpaRepository<DoctorPostJob,Integer>
{
    @Query(value="SELECT * FROM doctor_posted_jobs d WHERE d.doctor_id=?1",nativeQuery = true)
    List<DoctorPostJob> getDoctorPostedJob(@PathVariable("doctor_id") int doctorId) throws ResourceNotFoundException;
}
