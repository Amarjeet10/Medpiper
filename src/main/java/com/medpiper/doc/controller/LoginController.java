package com.medpiper.doc.controller;


import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.pojo.LoginRequest;
import com.medpiper.doc.pojo.LoginResponse;
import com.medpiper.doc.service.Impl.RegistrationServiceImpl;
import com.medpiper.doc.service.RegistrationService;
import com.medpiper.doc.util.Constants;
import com.medpiper.doc.util.ControllerResponse;
import com.medpiper.doc.util.JwtTokenUtil;
import com.medpiper.doc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value={Constants.URL_V1})
public class LoginController
{
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


  @PostMapping(value="login" , consumes = "application/json", produces="application/json;charset=UTF-8")
    public Callable<ControllerResponse> validateLogin(@RequestBody LoginRequest loginRequest)
    {
        return () ->
        {
            try
            {
                String email=loginRequest.getEmail();
                String pwd=loginRequest.getPwd();
                ControllerResponse<LoginResponse> controllerResponse = new ControllerResponse<LoginResponse>();

                if(Utils.isNullOrEpty(email) || Utils.isNullOrEpty(pwd))
                {
                    controllerResponse.setErrorMessage("Email or password field is NULL or empty");
                    controllerResponse.setStatusCode(Constants.ERROR_CODE_FIELD_EMPTY);
                }
                else
                {
                    RegistrationInfo registrationInfo= registrationService.findUserByEmail(email);
                    if(registrationInfo == null)
                    {
                        controllerResponse.setErrorMessage("User details not found. Login failed");
                        controllerResponse.setStatusCode(Constants.ERROR_CODE_USER_NOT_FOUND);
                        controllerResponse.setSuccess(false);
                    }

                    String loginEnable=registrationInfo.getEnabled();
                    System.out.println(".................................."+loginEnable);
                    String hashPwd=registrationInfo.getPwd();
                    if(!Utils.checkPassword(pwd, hashPwd))
                    {
                        controllerResponse.setErrorMessage("User Email and Password mismatch");
                        controllerResponse.setStatusCode(Constants.ERROR_CODE_USER_DETAILS_MISMATCH);
                        controllerResponse.setSuccess(false);
                    }
                    else
                    {
                        String token = jwtTokenUtil.generateToken(email);
                        LoginResponse loginResponse=new LoginResponse();
                        loginResponse.setId(registrationInfo.getUserId());
                        loginResponse.setEmail(email);
                        loginResponse.setToken(token);
                        loginResponse.setUserRole(registrationInfo.getUserRole());
                        controllerResponse.setData(loginResponse);
                        controllerResponse.setMessage("Log-In Successfull");
                        controllerResponse.setStatusCode(Constants.ERROR_CODE_SUCCESS);
                        controllerResponse.setSuccess(true);

                    }


                }
                return controllerResponse;
            }
            catch (Exception e)
            {
                ControllerResponse controllerResponse = new ControllerResponse<>();
                controllerResponse.setData(e.getMessage());
                controllerResponse.setErrorMessage("Login Failed");
                controllerResponse.setSuccess(false);
                return controllerResponse;
            }

        };

    }


}
