package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorContactDetails;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface DoctorContactRepository extends JpaRepository<DoctorContactDetails,Integer>
{
    @Query(value="SELECT * FROM doctor_contact_details d WHERE d.doctor_id=?1",nativeQuery = true)
    List<DoctorContactDetails> getDoctorContactDetails(@Param("doctor_id") int doctorId) throws ResourceNotFoundException;

    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "UPDATE doctor_contact_details de set primary_email =?,alternate_email =?,phone_no =?,alternate_phone_no =?,address_line1 =?, address_line2 =?,social_media =? where de.doctor_id = ?",nativeQuery = true)
    void updateDoctorContactDetails(@Param("primary_email") String primary_email,@Param("alternate_email") String alternate_email,@Param("phone_no") long phoneNo,@Param("alternate_phone_no") long alternate_phoneNo,@Param("address_line1") String addressLine1,@Param("address_line2") String addressLine2,@Param("social_media") String socialMedia,@Param("doctor_id") int doctorId) throws ResourceNotFoundException;
}
