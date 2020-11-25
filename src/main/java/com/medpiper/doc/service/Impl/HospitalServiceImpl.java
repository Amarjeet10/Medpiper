package com.medpiper.doc.service.Impl;


import com.medpiper.doc.domain.doctor.DoctorExam;
import com.medpiper.doc.domain.hospital.*;
import com.medpiper.doc.exception.ResourceNotFoundException;
import com.medpiper.doc.repository.hospital.*;
import com.medpiper.doc.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService
{
    @Autowired
    private HospitalBasicInfoRepository hospitalBasicInfoRepository;
    @Autowired
    private HospitalBranchDetailsRepository hospitalBranchDetailsRepository;
    @Autowired
    private HospitalfacilityRepository hospitalfacilityRepository;
    @Autowired
    private HospitalAccreditationRepository hospitalAccreditationRepository;
    @Autowired
    private HospitalSpecialityRepository hospitalSpecialityRepository;
    @Autowired
    private HospitalAyushRepository hospitalAyushRepository;
    @Autowired
    private HospitalPostJobRepository hospitalPostJobRepository;

    @Override
    public HospitalBasicInfo saveHospitalBasicInfo(HospitalBasicInfo hospitalBasicInfo)
    {
        int hospitalId=hospitalBasicInfo.getHospitalId();
        Optional<HospitalBasicInfo> hospitalBasicInfoOptional=hospitalBasicInfoRepository.findById(hospitalId);
        if(!hospitalBasicInfoOptional.isPresent())
        {
            return hospitalBasicInfoRepository.save(hospitalBasicInfo);
        }
        else
        {
            hospitalBasicInfo.setHospitalId(hospitalId);
            return hospitalBasicInfoRepository.save(hospitalBasicInfo);
        }
    }

    @Override
    public HospitalBasicInfo getHospitalBasicInfo(HospitalBasicInfo hospitalBasicInfo) throws ResourceNotFoundException
    {
        int hospitalId=hospitalBasicInfo.getHospitalId();
        Optional<HospitalBasicInfo> hospitalBasicInfoOptional=hospitalBasicInfoRepository.findById(hospitalId);
        if(!hospitalBasicInfoOptional.isPresent())
        {
            throw new ResourceNotFoundException("No details Found for Hospital Id.."+hospitalId+" in hospital Basic Info.So Search Cannot be Performed");
        }
        return hospitalBasicInfoRepository.findById(hospitalId).get();
    }

    @Override
    public HospitalBranchDetails saveHospitalBranchDetails(HospitalBranchDetails hospitalBranchDetails)
    {
        int hospitalId=hospitalBranchDetails.getHospital().getHospitalId();
        int hospitalBranchId=0;
        if(hospitalBranchId == 0)
        {
            hospitalBranchDetailsRepository.save(hospitalBranchDetails);
        }
        else
        {
            hospitalBranchDetails.getHospital().setHospitalId(hospitalId);
            hospitalBranchDetailsRepository.save(hospitalBranchDetails);

        }
        return hospitalBranchDetails;
    }

    @Override
    public List<HospitalBranchDetails> getHospitalBranchDetails(HospitalBranchDetails hospitalBranchDetails) throws ResourceNotFoundException
    {
        int hospitalId=hospitalBranchDetails.getHospital().getHospitalId();
        List<HospitalBranchDetails> hospitalBranchDetailsList;
        hospitalBranchDetailsList=hospitalBranchDetailsRepository.getHospitalBranchDetails(hospitalId);
        return hospitalBranchDetailsList;
    }

    @Override
    public HospitalFacilities saveHospitalFacilities(HospitalFacilities hospitalFacilities)
    {
        int hospitalId=hospitalFacilities.getHospital().getHospitalId();
        int facilityId=0;
        if(facilityId == 0)
        {
            hospitalfacilityRepository.save(hospitalFacilities);
        }
        else
        {
            hospitalFacilities.getHospital().setHospitalId(hospitalId);
            hospitalfacilityRepository.save(hospitalFacilities);

        }
        return hospitalFacilities;
    }

    @Override
    public List<HospitalFacilities> getHospitalFacilities(HospitalFacilities hospitalFacilities) throws ResourceNotFoundException
    {
        int hospitalId=hospitalFacilities.getHospital().getHospitalId();
        List<HospitalFacilities> hospitalFacilitiesList;
        hospitalFacilitiesList=hospitalfacilityRepository.getHospitalFacilities(hospitalId);
        return hospitalFacilitiesList;
    }

    @Override
    public List<HospitalAccreditation> saveHospitalAccreditation(List<HospitalAccreditation> hospitalAccreditation)
    {
        int hospitalId=hospitalAccreditation.get(0).getHospital().getHospitalId();
        int accreditationId=0;
        for(HospitalAccreditation hospitalAccreditation1 : hospitalAccreditation)
        {
            if (accreditationId == 0)
            {
                hospitalAccreditationRepository.saveAll(hospitalAccreditation);
            }
            else
            {
                hospitalAccreditation1.getHospital().setHospitalId(hospitalId);
                hospitalAccreditationRepository.saveAll(hospitalAccreditation);

            }
        }
        return hospitalAccreditation;
    }

    public List<HospitalAccreditation> getHospitalAccreditation(HospitalAccreditation hospitalAccreditation) throws ResourceNotFoundException
    {
        int hospitalId=hospitalAccreditation.getHospital().getHospitalId();
        List<HospitalAccreditation> hospitalAccreditationList;
        hospitalAccreditationList=hospitalAccreditationRepository.getHospitalAccreditation(hospitalId);
        return  hospitalAccreditationList;
    }

    public List<HospitalSpecialities> saveHospitalSpeciality(List<HospitalSpecialities> hospitalSpecialities)
    {
        int hospitalId=hospitalSpecialities.get(0).getHospital().getHospitalId();
        int hospitalSpecialityId=0;
        for(HospitalSpecialities hospitalSpecialities1 : hospitalSpecialities)
        {
            if (hospitalSpecialityId == 0)
            {
                hospitalSpecialityRepository.saveAll(hospitalSpecialities);
            }
            else
            {
                hospitalSpecialities1.getHospital().setHospitalId(hospitalId);
                hospitalSpecialityRepository.saveAll(hospitalSpecialities);

            }
        }
        return hospitalSpecialities;
    }

    public List<HospitalSpecialities> getHospitalSpeciality(HospitalSpecialities hospitalSpecialities) throws ResourceNotFoundException
    {
        int hospitalId=hospitalSpecialities.getHospital().getHospitalId();
        List<HospitalSpecialities> hospitalSpecialitiesList;
        hospitalSpecialitiesList=hospitalSpecialityRepository.getHospitalSpeciality(hospitalId);
        return hospitalSpecialitiesList;
    }

    public List<HospitalAyush> saveHospitalAyush(List<HospitalAyush> hospitalAyush)
    {
        int hospitalId=hospitalAyush.get(0).getHospital().getHospitalId();
        int hospitalAyushId=0;
        for(HospitalAyush hospitalAyush1 : hospitalAyush)
        {
            if (hospitalAyushId == 0)
            {
                hospitalAyushRepository.saveAll(hospitalAyush);
            }
            else
            {
                hospitalAyush1.getHospital().setHospitalId(hospitalId);
                hospitalAyushRepository.saveAll(hospitalAyush);

            }
        }
        return hospitalAyush;
    }

    public List<HospitalAyush> getHospitalAyush(HospitalAyush hospitalAyush) throws ResourceNotFoundException
    {
        int hospitalId=hospitalAyush.getHospital().getHospitalId();
        List<HospitalAyush> hospitalAyushList;
        hospitalAyushList=hospitalAyushRepository.getHospitalAyush(hospitalId);
        return hospitalAyushList;
    }

    public HospitalPostJob saveHospitalPostJob(HospitalPostJob hospitalPostJob)
    {
        int hospitalId=hospitalPostJob.getHospital().getHospitalId();
        int hospitalJobId=0;
        if(hospitalJobId == 0)
        {
            hospitalPostJobRepository.save(hospitalPostJob);
        }
        else
        {
            hospitalPostJob.getHospital().setHospitalId(hospitalId);
            hospitalPostJobRepository.save(hospitalPostJob);

        }
        return hospitalPostJob;
    }

    public List<HospitalPostJob> getHospitalPostedJobs(HospitalPostJob hospitalPostJob) throws ResourceNotFoundException
    {
        int hospitalId=hospitalPostJob.getHospital().getHospitalId();
        List<HospitalPostJob> hospitalPostJobList;
        hospitalPostJobList=hospitalPostJobRepository.getHospitalPostedJobs(hospitalId);
        return hospitalPostJobList;
    }


    String hospitalUploadPath = "D:\\uploads\\hospital\\";
    @Override
    public void saveHospitalDisplayPicture(MultipartFile file,HospitalDisplayFile hospitalDisplayFile)
    {
        try
        {
                int hospitalId=hospitalDisplayFile.getHospitalId();
                String dirName=hospitalUploadPath+"\\"+hospitalId;
                Path storageDir= Paths.get(dirName);
                File directory = new File(dirName);
                if (!directory.exists())
                {
                    directory.mkdir();
                    String originalFilename=file.getOriginalFilename();
                    String extension = originalFilename.split("\\.")[1];
                    Path newName= Paths.get(storageDir + "\\" + "hospitalId_" + hospitalId + "." + extension);
                    for( File f:directory.listFiles())
                    {
                        if(f.getName().startsWith("hospitalId_"))
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
                    Path newName= Paths.get(storageDir + "\\" + "hospitalId_" + hospitalId + "." + extension);
                    for( File f:directory.listFiles())
                    {
                        if(f.getName().startsWith("hospitalId_"))
                        {
                            f.delete();
                        }
                    }
                    Files.copy(file.getInputStream(), storageDir.resolve(newName));
                }

            }
        catch (Exception e)
        {
            throw new RuntimeException("Could not store the file for Hospital Error: " + e.getMessage());
        }
    }
}
