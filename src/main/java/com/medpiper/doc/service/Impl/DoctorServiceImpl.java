package com.medpiper.doc.service.Impl;

import com.medpiper.doc.domain.doctor.*;
import com.medpiper.doc.exception.ResourceNotFoundException;
import com.medpiper.doc.repository.doctor.*;
import com.medpiper.doc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorBasicInfoRepository doctorBasicInfoRepository;
    @Autowired
    private DoctorContactRepository doctorContactRepository;
    @Autowired
    private DoctorExamRepository doctorExamRepository;
    @Autowired
    private DoctorLicenseRepository doctorLicenseRepository;
    @Autowired
    private DoctorEducationRepository doctorEducationRepository;
    @Autowired
    private DoctorEmploymentRepository doctorEmploymentRepository;
    @Autowired
    private DoctorSkillsRepository doctorSkillsRepository;
    @Autowired
    private DoctorPreferenceRepository doctorPreferenceRepository;
    @Autowired
    private DoctorPostJobRepository doctorPostJobRepository;

    @Override
    public List<DoctorBasicInfo> getAllDoctorsBasicInfo(DoctorBasicInfo doctorBasicInfo) {

        return doctorBasicInfoRepository.findAll();
    }

    @Override
    public DoctorBasicInfo saveDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo) {
        int doctorId = doctorBasicInfo.getDoctorId();
        Optional<DoctorBasicInfo> doctorBasicInfoOptional = doctorBasicInfoRepository.findById(doctorId);
        if (!doctorBasicInfoOptional.isPresent()) {
            return doctorBasicInfoRepository.save(doctorBasicInfo);
        } else {
            doctorBasicInfo.setDoctorId(doctorId);
            return doctorBasicInfoRepository.save(doctorBasicInfo);
        }

    }

    @Override
    public DoctorBasicInfo getDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo) throws ResourceNotFoundException {
        int doctorId = doctorBasicInfo.getDoctorId();
        Optional<DoctorBasicInfo> doctorBasicInfoOptional = doctorBasicInfoRepository.findById(doctorId);
        if (!doctorBasicInfoOptional.isPresent())
        {
            throw new ResourceNotFoundException("No details Found for Doctor Id.." + doctorId);
        }
        return doctorBasicInfoRepository.findById(doctorId).get();
    }

    @Override
    public DoctorBasicInfo deleteDoctorBasicInfo(DoctorBasicInfo doctorBasicInfo) throws ResourceNotFoundException {
        int doctorId = doctorBasicInfo.getDoctorId();
        Optional<DoctorBasicInfo> doctorBasicInfoOptional = doctorBasicInfoRepository.findById(doctorId);
        if (!doctorBasicInfoOptional.isPresent()) {
            throw new ResourceNotFoundException("No details Found for Doctor Id....." + doctorId + " in doctor Basic Info. So Delete Cannot be Performed");
        }
        doctorBasicInfoRepository.deleteById(doctorId);
        return doctorBasicInfo;
    }

    @Override
    public DoctorContactDetails saveDoctorContactDetails(DoctorContactDetails doctorContactDetails)
    {
        int doctorId=doctorContactDetails.getDoctor().getDoctorId();
        int contactId=0;
        if(contactId == 0)
        {
            doctorContactRepository.save(doctorContactDetails);
        }
        else
        {
            doctorContactDetails.getDoctor().setDoctorId(doctorId);
            doctorContactRepository.save(doctorContactDetails);

        }
        return doctorContactDetails;

    }

    @Override
    public List<DoctorContactDetails> getDoctorContactDetails(DoctorContactDetails doctorContactDetails) throws ResourceNotFoundException {
        int doctorId = doctorContactDetails.getDoctor().getDoctorId();
        List<DoctorContactDetails> verifyDoctorContactEntry = doctorContactRepository.getDoctorContactDetails(doctorId);
        List<DoctorContactDetails> doctorContactDetailsList = null;
        if (!verifyDoctorContactEntry.isEmpty())
        {

            doctorContactDetailsList = doctorContactRepository.getDoctorContactDetails(doctorId);

        }
        return doctorContactDetailsList;
    }


    @Override
    public List<DoctorExam> saveDoctorExam(List<DoctorExam> doctorExam)
    {
        int doctorId=doctorExam.get(0).getDoctor().getDoctorId();
        int examId=0;
        for(DoctorExam doctorExam1 : doctorExam)
        {
            if (examId == 0)
            {
                doctorExamRepository.saveAll(doctorExam);
            }
            else
            {
                doctorExam1.getDoctor().setDoctorId(doctorId);
                doctorExamRepository.saveAll(doctorExam);

            }
        }
        return doctorExam;


    }

    @Override
    public List<DoctorExam> getDoctorExam(DoctorExam doctorExam)
    {
        int doctorId = doctorExam.getDoctor().getDoctorId();
        List<DoctorExam> doctorExamList;
        doctorExamList = doctorExamRepository.getDoctorExamListById(doctorId);
        return doctorExamList;
    }


    @Override
    public List<DoctorLicense> saveDoctorLicense(List<DoctorLicense> doctorLicense)
    {
        int doctorId=doctorLicense.get(0).getDoctor().getDoctorId();
        int licenseId=0;
        for(DoctorLicense doctorLicense1 : doctorLicense)
        {
            if (licenseId == 0)
            {
                doctorLicenseRepository.saveAll(doctorLicense);
            }
            else
            {
                doctorLicense1.getDoctor().setDoctorId(doctorId);
                doctorLicenseRepository.saveAll(doctorLicense);

            }
        }
        return doctorLicense;
    }

    @Override
    public List<DoctorLicense> getDoctorLicense(DoctorLicense doctorLicense) throws ResourceNotFoundException {
        int doctorId = doctorLicense.getDoctor().getDoctorId();
        List<DoctorLicense> doctorLicenseList;
        doctorLicenseList = doctorLicenseRepository.getDoctorLicenseById(doctorId);
        return doctorLicenseList;

    }

    @Override
    public List<DoctorEducation> saveDoctorEducation(List<DoctorEducation> doctorEducation)
    {
        int doctorId=doctorEducation.get(0).getDoctor().getDoctorId();
        int educationId=0;
        for(DoctorEducation doctorEducation1 :doctorEducation)
        {
            if(educationId==0)
            {
                doctorEducationRepository.saveAll(doctorEducation);
            }
            else
            {
                doctorEducation1.getDoctor().setDoctorId(doctorId);
                doctorEducationRepository.saveAll(doctorEducation);

            }
        }
        return doctorEducation;
    }

    @Override
    public List<DoctorEducation> getDoctorEducation(DoctorEducation doctorEducation) throws ResourceNotFoundException {
        int doctorId = doctorEducation.getDoctor().getDoctorId();
        List<DoctorEducation> doctorEducationList;
        doctorEducationList = doctorEducationRepository.getDoctorEducationById(doctorId);
        return doctorEducationList;
    }

    @Override
    public List<DoctorEmployment> saveDoctorEmployment(List<DoctorEmployment> doctorEmployment)
    {
        int doctorId=doctorEmployment.get(0).getDoctor().getDoctorId();
        int employmentId=0;
        for(DoctorEmployment doctorEmployment1 :doctorEmployment)
        {
            if(employmentId==0)
            {
                doctorEmploymentRepository.saveAll(doctorEmployment);
            }
            else
            {
                doctorEmployment1.getDoctor().setDoctorId(doctorId);
                doctorEmploymentRepository.saveAll(doctorEmployment);

            }
        }
        return doctorEmployment;
    }

    @Override
    public List<DoctorEmployment> getDoctorEmployment(DoctorEmployment doctorEmployment) throws ResourceNotFoundException {
        int doctorId = doctorEmployment.getDoctor().getDoctorId();
        List<DoctorEmployment> doctorEmploymentList;
        doctorEmploymentList = doctorEmploymentRepository.getDoctorEmploymentById(doctorId);
        return doctorEmploymentList;
    }

    @Override
    public List<DoctorSkills> saveDoctorSkills(List<DoctorSkills> doctorSkills)
    {
        int doctorId=doctorSkills.get(0).getDoctor().getDoctorId();
        int skillId=0;
        for(DoctorSkills doctorSkills1 :doctorSkills)
        {
            if(skillId==0)
            {
                doctorSkillsRepository.saveAll(doctorSkills);
            }
            else
            {
                doctorSkills1.getDoctor().setDoctorId(doctorId);
                doctorSkillsRepository.saveAll(doctorSkills);

            }
        }
        return doctorSkills;
    }

    @Override
    public List<DoctorSkills> getDoctorSkills(DoctorSkills doctorSkills) throws ResourceNotFoundException {
        int doctorId = doctorSkills.getDoctor().getDoctorId();
        List<DoctorSkills> doctorSkillsList;
        doctorSkillsList = doctorSkillsRepository.getDoctorSkillsById(doctorId);
        return doctorSkillsList;
    }

    @Override
    public List<DoctorPreference> saveDoctorPreference(List<DoctorPreference> doctorPreference)
    {
        int doctorId=doctorPreference.get(0).getDoctor().getDoctorId();
        int preferenceId=0;
        for(DoctorPreference doctorPreference1 :doctorPreference)
        {
            if(preferenceId==0)
            {
                doctorPreferenceRepository.saveAll(doctorPreference);
            }
            else
            {
                doctorPreference1.getDoctor().setDoctorId(doctorId);
                doctorPreferenceRepository.saveAll(doctorPreference);

            }
        }
        return doctorPreference;
    }

    @Override
    public List<DoctorPreference> getDoctorPreference(DoctorPreference doctorPreference) throws ResourceNotFoundException {
        int doctorId = doctorPreference.getDoctor().getDoctorId();
        List<DoctorPreference> doctorPreferenceList;
        doctorPreferenceList = doctorPreferenceRepository.getDoctorPreferenceById(doctorId);
        return doctorPreferenceList;
    }

    @Override
    public DoctorPostJob saveDoctorPostedJob(DoctorPostJob doctorPostJob)
    {
        int doctorId=doctorPostJob.getDoctor().getDoctorId();
        int doctorJobId=0;
         if(doctorJobId == 0)
         {
                doctorPostJobRepository.save(doctorPostJob);
         }
         else
         {
                doctorPostJob.getDoctor().setDoctorId(doctorId);
                doctorPostJobRepository.save(doctorPostJob);

         }
        return doctorPostJob;
    }

    @Override
    public List<DoctorPostJob> getDoctorPostedJob(DoctorPostJob doctorPostJob) throws ResourceNotFoundException {
        int doctorId = doctorPostJob.getDoctor().getDoctorId();
        List<DoctorPostJob> doctorPostJobList;
        doctorPostJobList = doctorPostJobRepository.getDoctorPostedJob(doctorId);
        return doctorPostJobList;
    }


    String docUploadPath = "D:\\uploads\\doctor\\";
    @Override
    public void saveDoctorDisplayPicture(MultipartFile file,DoctorDisplayFile doctorDisplayFile)
    {

        try
        {
            int doctorId=doctorDisplayFile.getDoctorId();
            String dirName=docUploadPath+"\\"+doctorId;
            Path storageDir=Paths.get(dirName);
            File directory = new File(dirName);
            if (!directory.exists())
            {
                directory.mkdir();
                String originalFilename=file.getOriginalFilename();
                String extension = originalFilename.split("\\.")[1];
                Path newName= Paths.get(storageDir + "\\" + "doctorId_" + doctorId + "." + extension);
                for( File f:directory.listFiles())
                {
                    if(f.getName().startsWith("doctorId_"))
                    {
                        f.delete();
                    }
                }
                Files.copy(file.getInputStream(), storageDir.resolve(newName));
            }
            else
            {
                String originalFilename=file.getOriginalFilename();
                String extension = originalFilename.split("\\.")[1];
                Path newName= Paths.get(storageDir + "\\" + "doctorId_" + doctorId + "." + extension);
                for( File f:directory.listFiles())
                {
                    if(f.getName().startsWith("doctorId_"))
                    {
                        f.delete();
                    }
                }
               Files.copy(file.getInputStream(), storageDir.resolve(newName));
            }

        }
        catch (Exception e)
        {
            throw new RuntimeException("Could not store the file in Doctor. Error: " + e.getMessage());
        }
    }
}
