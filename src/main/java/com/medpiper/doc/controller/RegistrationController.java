package com.medpiper.doc.controller;

import com.medpiper.doc.domain.Registration.OTPVerification;
import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.domain.doctor.DoctorBasicInfo;
import com.medpiper.doc.pojo.LoginResponse;
import com.medpiper.doc.pojo.OtpRequest;
import com.medpiper.doc.service.OTPVerificationService;
import com.medpiper.doc.service.RegistrationService;
import com.medpiper.doc.util.Constants;
import com.medpiper.doc.util.ControllerResponse;
import com.medpiper.doc.util.Utils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value={Constants.URL_V1})
public class RegistrationController
{
        @Autowired
        private RegistrationService registrationService;

        @Autowired
        private OTPVerificationService otpVerificationService;


        @RequestMapping(value = "/hello")
        public String helloWorld()
        {
            return "This Link for testing purpose..............! So Yaa Hello Aliens";
        }


        @PostMapping(value="saveUser" , consumes = "application/json", produces="application/json;charset=UTF-8")
        public Callable<ControllerResponse> saveUser(@RequestBody RegistrationInfo registrationInfo)
        {
            return () ->
            {
                try
                {
                    JSONObject responseJson = new JSONObject();

                    ControllerResponse<String> controllerResponse = validateUserInfo(registrationInfo,responseJson);
                    if (!controllerResponse.isSuccess())
                    {
                        return controllerResponse;
                    }

                        String name=registrationInfo.getName();
                        String email=registrationInfo.getEmail();
                        String pwd=registrationInfo.getPwd();
                        String encrpytpwd=Utils.encryptPassword(pwd);
                        String userRole=registrationInfo.getUserRole();
                        String otp = Utils.generateOTP();
                        String otpHash = Utils.getRandomHash();
                        Date otpExpiry=Utils.getOtpExpiryTime();

                        registrationInfo.setName(name);
                        registrationInfo.setEmail(email);
                        registrationInfo.setPwd(encrpytpwd);
                        registrationInfo.setUserRole(userRole);
                        registrationInfo.setEnabled("FALSE");
                        registrationInfo.setOtpSent(1);
                        registrationInfo.setOtpHash(otp);
                        registrationInfo.setOtpExpiry(otpExpiry);

                        RegistrationInfo savedRegistrationInfo=registrationService.saveUser(registrationInfo);
                        //controllerResponse.setData(savedRegistrationInfo);
                        controllerResponse.setMessage("User Registered Successfully");
                        controllerResponse.setSuccess(true);
                        responseJson.put(OTPVerification.OTP,otp);
                        responseJson.put(RegistrationInfo.USERID,savedRegistrationInfo.getUserId());

                    return controllerResponse;
                }
                catch (Exception e)
                {
                    System.out.println(Utils.getExceptionReturnResponse(e));
                    return Utils.getExceptionReturnResponse(e);
                }

            };

        }
        @SuppressWarnings("unchecked")
        private ControllerResponse<String> validateUserInfo(RegistrationInfo registrationInfo, JSONObject responseJson)
        {

            int regType=registrationInfo.getRegType();
            String userRole=registrationInfo.getUserRole();
            String email=registrationInfo.getEmail();
            String pwd=registrationInfo.getPwd();
            String name=registrationInfo.getName();

            ControllerResponse<String> controllerResponse = new ControllerResponse<String>();
            controllerResponse.setSuccess(true);
            switch (regType)
            {
                case Constants.KEY_REG_TYPE_EMAIL:

                    if (Utils.isNullOrEpty(email) || Utils.isNullOrEpty(name) || Utils.isNullOrEpty(pwd))
                    {

                        controllerResponse.setErrorMessage("Email or name or password field is NULL or empty");
                        controllerResponse.setStatusCode(Constants.ERROR_CODE_FIELD_EMPTY);
                        controllerResponse.setSuccess(false);
                    }
                    else
                    {
                        RegistrationInfo existingRegistrationInfo=registrationService.findUserByEmail(email);
                        if(existingRegistrationInfo !=null)
                        {
                            controllerResponse.setErrorMessage("Email already registered");
                            controllerResponse.setStatusCode(Constants.ERROR_CODE_USER_ALREADY_REGISTRED);
                            controllerResponse.setSuccess(false);
                        }
                   /*
                        else
                        {
                            registrationInfo.setPwd(Utils.encryptPassword(registrationInfo.getPwd()));

                            String otp = Utils.generateOTP();
                            String otpHash = Utils.getRandomHash();

                            OTPVerification otpVerificationObj=new OTPVerification();
                            otpVerificationObj.setOtp(otp);
                            otpVerificationObj.setOtpHash(otpHash);
                            otpVerificationObj.setExpiry(Utils.getOtpExpiryTime());
                            otpVerificationService.saveOTP(otpVerificationObj);
                            responseJson.put(OTPVerification.OTP_HASH,otpHash);


                        }

                    */
                    }
                    break;

                default:
                controllerResponse.setSuccess(false);
                controllerResponse.setErrorMessage("Registration type " + regType + " is invalid");
                break;


            }
            return controllerResponse;

        }

        @PostMapping(value="verifyotp" , consumes = "application/json", produces="application/json;charset=UTF-8")
        public Callable<ControllerResponse> verifyotp(@RequestBody OtpRequest otpRequest)
        {
            return () ->
            {
                    ControllerResponse controllerResponse=new ControllerResponse();

                    String email=otpRequest.getEmail();
                    String otp=otpRequest.getOtp();
                    if (Utils.isNullOrEpty(email) || Utils.isNullOrEpty(otp))
                    {
                        controllerResponse.setErrorMessage("Email or OTP field is NULL or empty");
                        controllerResponse.setStatusCode(Constants.ERROR_CODE_FIELD_EMPTY);
                        controllerResponse.setSuccess(false);
                    }
                    else
                    {
                        String dbotp=registrationService.getOtpOfEmail(email);
                        String dbOtpExpiryTime=registrationService.getOtpExpirationOfEmail(email).toString();
                        if(otp.equals(dbotp)||otp==dbotp)
                        {
                            System.out.println("OTP Matched");

                            Date date = new Date();
                            String currentDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss  ").format(date);

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date d1 = null;
                            Date d2 = null;
                            try
                            {
                                d1 = format.parse(currentDate);
                                d2 = format.parse(dbOtpExpiryTime);
                            }
                            catch (ParseException e)
                            {
                                e.printStackTrace();
                            }

                            long diff = d2.getTime() - d1.getTime();
                            long diffMinutes = diff / (60 * 1000);

                            if(diffMinutes==0 || diffMinutes<0)
                            {
                                //send new otp and update the db
                                controllerResponse.setErrorMessage("OTP Time Expired............!");
                                controllerResponse.setSuccess(false);
                            }
                            else
                                {
                                //update the db and enable the user
                                    int enableUser=registrationService.enableUser(email);
                                    if(enableUser!=0)
                                    {
                                        controllerResponse.setMessage("OTP Verified");
                                        controllerResponse.setStatusCode(Constants.ERROR_CODE_SUCCESS);
                                        controllerResponse.setSuccess(true);
                                    }
                                    else
                                    {
                                       controllerResponse.setErrorMessage("OTP Verification Failed! Please try Again");
                                       controllerResponse.setStatusCode(Constants.ERROR_CODE_GENERIC_FAILURE);
                                       controllerResponse.setSuccess(false);
                                    }

                            }

                        }
                        else
                        {
                            controllerResponse.setErrorMessage("OTP do not match");
                            controllerResponse.setStatusCode(Constants.ERROR_OTP_MISMATCH);
                            controllerResponse.setSuccess(false);
                        }


                    }
                    return  controllerResponse;
            };
        }



}
