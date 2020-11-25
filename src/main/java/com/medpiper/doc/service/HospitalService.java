package com.medpiper.doc.service;

import com.medpiper.doc.domain.doctor.DoctorDisplayFile;
import com.medpiper.doc.domain.hospital.*;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface HospitalService
{
    HospitalBasicInfo saveHospitalBasicInfo(HospitalBasicInfo hospitalBasicInfo) throws ResourceNotFoundException;
    HospitalBasicInfo getHospitalBasicInfo(HospitalBasicInfo hospitalBasicInfo) throws ResourceNotFoundException;

    HospitalBranchDetails saveHospitalBranchDetails(HospitalBranchDetails hospitalBranchDetails) throws ResourceNotFoundException;
    List<HospitalBranchDetails> getHospitalBranchDetails(HospitalBranchDetails hospitalBranchDetails) throws ResourceNotFoundException;

    HospitalFacilities saveHospitalFacilities(HospitalFacilities hospitalFacilities) throws ResourceNotFoundException;
    List<HospitalFacilities> getHospitalFacilities(HospitalFacilities hospitalFacilities) throws ResourceNotFoundException;

    List<HospitalAccreditation> saveHospitalAccreditation(List<HospitalAccreditation> hospitalAccreditation) throws ResourceNotFoundException;
    List<HospitalAccreditation> getHospitalAccreditation(HospitalAccreditation hospitalAccreditation) throws ResourceNotFoundException;

    List<HospitalSpecialities> saveHospitalSpeciality(List<HospitalSpecialities> hospitalSpecialities) throws ResourceNotFoundException;
    List<HospitalSpecialities> getHospitalSpeciality(HospitalSpecialities hospitalSpecialities) throws ResourceNotFoundException;

    List<HospitalAyush> saveHospitalAyush(List<HospitalAyush> hospitalAyush) throws ResourceNotFoundException;
    List<HospitalAyush> getHospitalAyush(HospitalAyush hospitalAyush) throws ResourceNotFoundException;

    HospitalPostJob saveHospitalPostJob(HospitalPostJob hospitalPostJob) throws ResourceNotFoundException;
    List<HospitalPostJob> getHospitalPostedJobs(HospitalPostJob hospitalPostJob) throws ResourceNotFoundException;


    public void saveHospitalDisplayPicture(MultipartFile file, HospitalDisplayFile hospitalDisplayFile);
}
