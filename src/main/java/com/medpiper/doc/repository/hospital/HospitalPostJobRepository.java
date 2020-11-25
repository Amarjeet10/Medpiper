package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalPostJob;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface HospitalPostJobRepository extends JpaRepository<HospitalPostJob,Integer>
{
    @Query(value="select * from hospital_posted_jobs h where h.hospital_id=?1",nativeQuery = true)
    List<HospitalPostJob> getHospitalPostedJobs(@PathVariable("hospital_id") int hospitalId) throws ResourceNotFoundException;
}
