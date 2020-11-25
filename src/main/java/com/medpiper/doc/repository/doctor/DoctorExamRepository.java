package com.medpiper.doc.repository.doctor;

import com.medpiper.doc.domain.doctor.DoctorExam;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public interface DoctorExamRepository extends JpaRepository<DoctorExam,Integer>
{
    @Query(value="SELECT * FROM doctor_exam d WHERE d.doctor_id=?1",nativeQuery = true)
    List<DoctorExam> getDoctorExamListById(@Param("doctor_id") int doctorId);

    //Consumer<? super DoctorExam> updateDoctorExamListById(@Param("exam_title") String examTitle, @Param("from_date") Date fromDate, @Param("to_date") Date toDate,@Param("doctor_id") int doctorId,@Param("exam_id") int examId) throws ResourceNotFoundException;
    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "UPDATE doctor_exam de set exam_title =?,exam_from_date =?,exam_to_date =?, certificate_title =?, certificate_from_date=?, certificate_to_date=?, member_ship_title=?, membership_from_date=?, membership_to_date=? where de.doctor_id = ? and de.exam_id =?",nativeQuery = true)
    int updateDoctorExamListById(@Param("exam_title") String examTitle,@Param("exam_from_date") Date examFromDate,@Param("exam_to_date") Date examToDate,@Param("certificate_title") String certificateTitle,@Param("certificate_from_date") Date certificateFromDate,@Param("certificate_to_date") Date certificateToDate,@Param("member_ship_title") String membershipTitle,@Param("membership_from_date") Date membershipFromDate,@Param("membership_to_date") Date membershipToDate,@Param("doctor_id") int doctorId,@Param("exam_id") int examId);

}
