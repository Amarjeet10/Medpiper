package com.medpiper.doc.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.util.ControllerResponse;
import com.medpiper.doc.util.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@SpringBootTest
public class RegistrationControllerTest
{
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Before
    public void setUp()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    ObjectMapper om=new ObjectMapper(); //to cast object to string
    @Test
    public void saveUserTest() throws Exception {
        RegistrationInfo registrationInfo=new RegistrationInfo();
        registrationInfo.setUserId(0);
        registrationInfo.setName("Amarjeet");
        registrationInfo.setEmail("amarjeet");
        registrationInfo.setPwd("abc123");
        registrationInfo.setRegType(100);
        registrationInfo.setUserRole("ROLE_DOCTOR");
        registrationInfo.setOtpHash("1234");
        registrationInfo.setOtpExpiry(Utils.getOtpExpiryTime());
        String jsonReqeust=om.writeValueAsString(registrationInfo);

        System.out.println("JsonRequest..................."+jsonReqeust);

        MvcResult mvcResult=mockMvc.perform(post("/medpiper/v1/saveUser").content(jsonReqeust).contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();

        String resultContent=mvcResult.getRequest().getContentAsString();
        System.out.println("ResultContent..................."+resultContent);

        //ControllerResponse controllerResponse=om.readValue(resultContent,ControllerResponse.class);
        Assert.assertEquals(jsonReqeust.toString(),resultContent.toString());

        //Assert.assertTrue(controllerResponse.isSuccess()==Boolean.TRUE);
        //RegistrationInfo registrationInfo1=om.readValue(resultContent,RegistrationInfo.class);
        //Assert.assertTrue(registrationInfo1.getEmail()=="amarjeet");
    }
}
