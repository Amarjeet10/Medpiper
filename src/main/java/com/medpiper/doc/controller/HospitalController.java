package com.medpiper.doc.controller;

import com.medpiper.doc.domain.doctor.DoctorDisplayFile;
import com.medpiper.doc.domain.hospital.*;
import com.medpiper.doc.service.HospitalService;
import com.medpiper.doc.util.Constants;
import com.medpiper.doc.util.ControllerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value={Constants.URL_V1 + "hospital"})
public class HospitalController
{
    @Autowired
    private HospitalService hospitalService;

    @PostMapping(value="saveHospitalBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalBasicInfo(@RequestBody HospitalBasicInfo hospitalBasicInfo)
    {

        return () -> {
            try{

                HospitalBasicInfo savedBasicInfo = hospitalService.saveHospitalBasicInfo(hospitalBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedBasicInfo);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital basic info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @GetMapping(value="getHospitalBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalBasicInfo(@RequestBody HospitalBasicInfo hospitalBasicInfo)
    {
        return () -> {
            try{

                HospitalBasicInfo getHospitalBasicInfo = hospitalService.getHospitalBasicInfo(hospitalBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalBasicInfo);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital basic info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @PostMapping(value="saveHospitalBranchDetails" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalBranchDetails(@RequestBody HospitalBranchDetails hospitalBranchDetails)
    {

        return () -> {
            try{

                HospitalBranchDetails savedhospitalBranchDetails = hospitalService.saveHospitalBranchDetails(hospitalBranchDetails);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalBranchDetails);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Branch Details");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @GetMapping(value="getHospitalBranchDetails" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalBranchDetails(@RequestBody HospitalBranchDetails hospitalBranchDetails)
    {
        return () -> {
            try{

                List<HospitalBranchDetails> getHospitalBranchDetails = hospitalService.getHospitalBranchDetails(hospitalBranchDetails);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalBranchDetails);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Branch Details");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @PostMapping(value="saveHospitalFacility" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalFacilities(@RequestBody HospitalFacilities hospitalFacilities)
    {
        return () -> {
            try{

                HospitalFacilities savedhospitalfacilities = hospitalService.saveHospitalFacilities(hospitalFacilities);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalfacilities);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Facility");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @GetMapping(value="getHospitalFacility" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalFacility(@RequestBody HospitalFacilities hospitalFacilities)
    {
        return () -> {
            try{

                List<HospitalFacilities> getHospitalFacilities = hospitalService.getHospitalFacilities(hospitalFacilities);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalFacilities);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Facility");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }


    @PostMapping(value="saveHospitalAccreditation" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalAccreditation(@RequestBody List<HospitalAccreditation> hospitalAccreditation)
    {
        return () -> {
            try{

                List<HospitalAccreditation> savedhospitalAccreditation = hospitalService.saveHospitalAccreditation(hospitalAccreditation);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalAccreditation);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Accreditation");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @GetMapping(value="getHospitalAccreditation" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalFacility(@RequestBody HospitalAccreditation hospitalAccreditation)
    {
        return () -> {
            try{

                List<HospitalAccreditation> getHospitalAccreditation = hospitalService.getHospitalAccreditation(hospitalAccreditation);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalAccreditation);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Accreditation");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @PostMapping(value="saveHospitalSpeciality" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalSpeciality(@RequestBody List<HospitalSpecialities> hospitalSpecialities)
    {
        return () -> {
            try{

                List<HospitalSpecialities> savedhospitalSpeciality = hospitalService.saveHospitalSpeciality(hospitalSpecialities);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalSpeciality);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Speciality");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @GetMapping(value="getHospitalSpeciality" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalSpeciality(@RequestBody HospitalSpecialities hospitalSpecialities)
    {
        return () -> {
            try{

                List<HospitalSpecialities> getHospitalSpecialities = hospitalService.getHospitalSpeciality(hospitalSpecialities);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalSpecialities);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Speciality");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @PostMapping(value="saveHospitalAyush" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalAyush(@RequestBody List<HospitalAyush> hospitalAyush)
    {
        return () -> {
            try{

                List<HospitalAyush> savedhospitalAyush = hospitalService.saveHospitalAyush(hospitalAyush);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalAyush);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Ayush");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @GetMapping(value="getHospitalAyush" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalAyush(@RequestBody HospitalAyush hospitalAyush)
    {
        return () -> {
            try{

                List<HospitalAyush> getHospitalAyush = hospitalService.getHospitalAyush(hospitalAyush);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getHospitalAyush);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Ayush");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }

    @PostMapping(value="saveHospitalPostJob" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveHospitalPostJob(@RequestBody HospitalPostJob hospitalPostJob)
    {
        return () -> {
            try{

                HospitalPostJob savedhospitalPostedjob = hospitalService.saveHospitalPostJob(hospitalPostJob);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedhospitalPostedjob);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Hospital Job");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @GetMapping(value="getHospitalPostedJob" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getHospitalPostedJob(@RequestBody HospitalPostJob hospitalPostJob)
    {
        return () -> {
            try{

                List<HospitalPostJob> gethospitalPostedjob = hospitalService.getHospitalPostedJobs(hospitalPostJob);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(gethospitalPostedjob);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Hospital Posted Job");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @PostMapping("/saveHospitalDisplayPicture")
    public Callable<ControllerResponse> saveHospitalDisplayPicture(@RequestParam("file") MultipartFile file, HospitalDisplayFile hospitalDisplayFile)
    {
        return () ->
        {
            try
            {

                hospitalService.saveHospitalDisplayPicture(file,hospitalDisplayFile);
                String message = "Uploaded the file successfully: ";
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(message);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to Upload Hospital Display Picture");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }
}
