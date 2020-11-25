package com.medpiper.doc.service;

import com.medpiper.doc.domain.doctor.*;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DoctorService
{


    public List<DoctorBasicInfo> getAllDoctorsBasicInfo(DoctorBasicInfo doctorBasicInfo) throws ResourceNotFoundException;
    public DoctorBasicInfo saveDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo);
    public DoctorBasicInfo getDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo) throws ResourceNotFoundException;
    public DoctorBasicInfo deleteDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo) throws ResourceNotFoundException;


    public DoctorContactDetails saveDoctorContactDetails(DoctorContactDetails doctorContactDetails) throws ResourceNotFoundException;
    public List<DoctorContactDetails> getDoctorContactDetails(DoctorContactDetails doctorContactDetails) throws ResourceNotFoundException;



    public List<DoctorExam> saveDoctorExam(List<DoctorExam> doctorExam) throws ResourceNotFoundException;
    public List<DoctorExam> getDoctorExam(DoctorExam doctorExam) throws ResourceNotFoundException;



    List<DoctorLicense> saveDoctorLicense(List<DoctorLicense> doctorLicense) throws ResourceNotFoundException;
    List<DoctorLicense> getDoctorLicense(DoctorLicense doctorLicense) throws ResourceNotFoundException;


    List<DoctorEducation> saveDoctorEducation(List<DoctorEducation> doctorEducation) throws ResourceNotFoundException;
    List<DoctorEducation> getDoctorEducation(DoctorEducation doctorEducation) throws ResourceNotFoundException;


    List<DoctorEmployment> saveDoctorEmployment(List<DoctorEmployment> doctorEmployment) throws ResourceNotFoundException;
    List<DoctorEmployment> getDoctorEmployment(DoctorEmployment doctorEmployment) throws ResourceNotFoundException;

    List<DoctorSkills> saveDoctorSkills(List<DoctorSkills> doctorSkills) throws ResourceNotFoundException;
    List<DoctorSkills> getDoctorSkills(DoctorSkills doctorSkills) throws ResourceNotFoundException;


    List<DoctorPreference> saveDoctorPreference(List<DoctorPreference> doctorPreference) throws ResourceNotFoundException;
    List<DoctorPreference> getDoctorPreference(DoctorPreference doctorPreference) throws ResourceNotFoundException;



    DoctorPostJob saveDoctorPostedJob(DoctorPostJob doctorPostJob) throws ResourceNotFoundException;
    List<DoctorPostJob> getDoctorPostedJob(DoctorPostJob doctorPostJob) throws ResourceNotFoundException;


   //public void init();

    //public void saveDoctorDisplayPicture(RequestContext requestContext);
    public void saveDoctorDisplayPicture(MultipartFile file,DoctorDisplayFile doctorDisplayFile);


}
