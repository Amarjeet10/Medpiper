package com.medpiper.doc.controller;


import com.medpiper.doc.domain.doctor.*;
import com.medpiper.doc.service.*;
import com.medpiper.doc.util.Constants;
import com.medpiper.doc.util.ControllerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value={Constants.URL_V1 + "doctor"})
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping(value="saveDoctorBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorBasicInfo(@RequestBody DoctorBasicInfo doctorBasicInfo)
    {

        return () -> {
            try{

                DoctorBasicInfo savedBasicInfo = doctorService.saveDoctorBasicInfo(doctorBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedBasicInfo);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor basic info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };


    }
    @GetMapping(value="getDoctorBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorBasicInfo(@RequestBody DoctorBasicInfo doctorBasicInfo)
    {
        return () ->
        {
            try
            {
                DoctorBasicInfo getDoctorBasicInfo = doctorService.getDoctorBasicInfo(doctorBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorBasicInfo);
                controllerResponse.setSuccess(true);
                controllerResponse.setStatusCode(200);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Basic Info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }
    @GetMapping(value="getAllDoctorsBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getllDoctorsBasicInfo(@RequestBody DoctorBasicInfo doctorBasicInfo)
    {
        return () ->
        {
            try
            {
                List<DoctorBasicInfo> getAllDoctorBasicInfo = doctorService.getAllDoctorsBasicInfo(doctorBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getAllDoctorBasicInfo);
                controllerResponse.setSuccess(true);
                controllerResponse.setStatusCode(200);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get All Doctor Basic Info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }
    @DeleteMapping(value="deleteDoctorBasicInfo" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> deleteDoctorBasicInfo(@RequestBody DoctorBasicInfo doctorBasicInfo)
    {
        return () ->
        {
            try
            {
                DoctorBasicInfo deleteDoctorBasicInfo = doctorService.deleteDoctorBasicInfo(doctorBasicInfo);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(deleteDoctorBasicInfo);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to Delete Doctor Basic Info");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @PostMapping(value="saveDoctorContactDetails" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorContactDetails(@RequestBody DoctorContactDetails doctorContactDetails)
    {
        return () -> {
            try{

                DoctorContactDetails saveDoctorContactDetails = doctorService.saveDoctorContactDetails(doctorContactDetails);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorContactDetails);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Contact Details");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }
    @GetMapping(value="getDoctorContactDetails" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorContactDetails(@RequestBody DoctorContactDetails doctorContactDetails)
    {
        return () ->
        {
            try
            {
                List<DoctorContactDetails> getDoctorContactDetails = doctorService.getDoctorContactDetails(doctorContactDetails);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorContactDetails);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Contact Details");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @PostMapping(value="saveDoctorExam", consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorExam(@RequestBody List<DoctorExam> doctorExam)
    {
        return () -> {
            try{

                List<DoctorExam> saveDoctorExam = doctorService.saveDoctorExam(doctorExam);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorExam);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Exam");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }
    @GetMapping(value="getDoctorExam", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorExam(@RequestBody DoctorExam doctorExam)
    {
        return () ->
        {
            try
            {
                List<DoctorExam> getDoctorexam = doctorService.getDoctorExam(doctorExam);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorexam);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Exam");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @PostMapping(value="saveDoctorEducation" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorEducation(@RequestBody List<DoctorEducation> doctorEducation)
    {
        return () ->
        {
            try{

                List<DoctorEducation> saveDoctorEducation = doctorService.saveDoctorEducation(doctorEducation);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorEducation);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Education");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }
    @GetMapping(value="getDoctorEducation" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorEducation(@RequestBody DoctorEducation doctorEducation)
    {
        return () ->
        {
            try
            {
                List<DoctorEducation> getDoctorEducation = doctorService.getDoctorEducation(doctorEducation);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorEducation);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Education");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @PostMapping(value="saveDoctorLicense" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorLicense(@RequestBody List<DoctorLicense> doctorLicense)
    {
        return () ->
        {
            try{

                List<DoctorLicense> saveDoctorLicense = doctorService.saveDoctorLicense(doctorLicense);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorLicense);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor License");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }
    @GetMapping(value="getDoctorLicense" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorLicense(@RequestBody DoctorLicense doctorLicense)
    {
        return () ->
        {
            try
            {
                List<DoctorLicense> getDoctorLicense = doctorService.getDoctorLicense(doctorLicense);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorLicense);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor License");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @PostMapping(value="saveDoctorEmployment" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorEmployment(@RequestBody List<DoctorEmployment> doctorEmployment)
    {
        return () ->
        {
            try{

                List<DoctorEmployment> saveDoctorEmployment = doctorService.saveDoctorEmployment(doctorEmployment);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorEmployment);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Employment");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }
    @GetMapping(value="getDoctorEmployment" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorEmployment(@RequestBody DoctorEmployment doctorEmployment)
    {
        return () ->
        {
            try
            {
                List<DoctorEmployment> getDoctorEmployment = doctorService.getDoctorEmployment(doctorEmployment);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorEmployment);
                controllerResponse.setSuccess(true);
                return  controllerResponse;

            }
            catch(Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Employment");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @PostMapping(value="saveDoctorSkills" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorSkills(@RequestBody List<DoctorSkills> doctorSkills)
    {
        return () ->
        {
            try{

                List<DoctorSkills> saveDoctorSkills = doctorService.saveDoctorSkills(doctorSkills);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorSkills);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Skills");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }
    @GetMapping(value="getDoctorSkills" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorSkills(@RequestBody DoctorSkills doctorSkills)
    {
        return () ->
        {
            try{

                List<DoctorSkills> getDoctorSkills = doctorService.getDoctorSkills(doctorSkills);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorSkills);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Skills");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @PostMapping(value="saveDoctorPreference" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorPreference(@RequestBody List<DoctorPreference> doctorPreference)
    {
        return () ->
        {
            try{

                List<DoctorPreference> saveDoctorPreference = doctorService.saveDoctorPreference(doctorPreference);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(saveDoctorPreference);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Preferences");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };

    }

    @GetMapping(value="getDoctorPreference" ,consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorPreference(@RequestBody DoctorPreference doctorPreference)
    {
        return () ->
        {
            try{

                List<DoctorPreference> getDoctorPreference = doctorService.getDoctorPreference(doctorPreference);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorPreference);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Preference");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @PostMapping(value="saveDoctorPostJob" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> saveDoctorPostJob(@RequestBody DoctorPostJob doctorPostJob)
    {
        return () -> {
            try{

                DoctorPostJob savedDoctorPostedjob = doctorService.saveDoctorPostedJob(doctorPostJob);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(savedDoctorPostedjob);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to save Doctor Job");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }


    @GetMapping(value="getDoctorPostedJob" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> getDoctorPostedJob(@RequestBody DoctorPostJob doctorPostJob)
    {
        return () -> {
            try{

                List<DoctorPostJob> getDoctorPostedjob = doctorService.getDoctorPostedJob(doctorPostJob);
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(getDoctorPostedjob);
                controllerResponse.setSuccess(true);
                return  controllerResponse;
            }catch(Exception e){
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e);
                controllerResponse.setErrorMessage("Failed to get Doctor Posted Job");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

    @PostMapping("/saveDoctorDisplayPicture")
    public Callable<ControllerResponse> saveDoctorDisplayPicture(@RequestParam("file") MultipartFile file, DoctorDisplayFile doctorDisplayFile)
    {
        return () ->
        {
            try
            {

                doctorService.saveDoctorDisplayPicture(file,doctorDisplayFile);
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
                controllerResponse.setErrorMessage("Failed to Upload Doctor Display Picture");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }
        };
    }

}
