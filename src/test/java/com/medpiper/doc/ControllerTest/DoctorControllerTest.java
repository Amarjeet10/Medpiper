package com.medpiper.doc.ControllerTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medpiper.doc.domain.doctor.DoctorBasicInfo;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)

@SpringBootTest
public class DoctorControllerTest
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

   /* protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
    */
    @Test
    public void getDoctorBasicInfo() throws Exception
    {

        DoctorBasicInfo doctorBasicInfo=new DoctorBasicInfo();
        doctorBasicInfo.setDoctorId(1);
        String jsonRequest=om.writeValueAsString(doctorBasicInfo);
        System.out.println("JsonRequest..................."+jsonRequest);

        doctorBasicInfo.setFirstName("Amarjeet");
        doctorBasicInfo.setMiddleName("");
        doctorBasicInfo.setLastName("Yadav");
        doctorBasicInfo.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2011-01-01 00:00:00"));
        doctorBasicInfo.setProfession("Job");
        doctorBasicInfo.setSpecialization("IT");
        doctorBasicInfo.setNationality("Indian");
        doctorBasicInfo.setEmail("amarjeet");
        doctorBasicInfo.setDoctorId(1);

        String jsonResponse=om.writeValueAsString(doctorBasicInfo);
        System.out.println("JsonResponse..................."+jsonResponse);

        MvcResult mvcResult=mockMvc.perform(get("/medpiper/v1/doctor/getDoctorBasicInfo").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Status.................."+status);
        String resultContent=mvcResult.getRequest().getContentAsString();
        Assert.assertEquals(200,status);

        //String jsonResponse=om.writeValueAsString(doctorBasicInfo);
        //String jsonResponse=mapToJson(doctorBasicInfo);
        //System.out.println("JsonResponse..................."+jsonResponse);



        //{"userId":0,"name":"Amarjeet","email":"amarjeet","pwd":"abc123","regType":100,"userRole":1,"enabled":0,"otpSent":0,"otpHash":"1234","otpExpiry":1605958233328}
        // passing doctorId , expect a json

       /* MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/medpiper/v1/doctor/getDoctorBasicInfo")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8"))
                //.andExpect(content().json("{'data':{'doctorId': 1,'firstName': 'Amarjeet','middleName': '','lastName': 'Yadav','dateOfBirth': '2020-01-01T00:00:00.000+00:00','profession': 'Job','specialization': 'IT','nationality': 'Indian','email': 'amarjeet@techvariable.com'}}"))
                .andExpect(jsonPath("$.doctorId",is(jsonResponse)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.doctorId",hasValue("1")))
                .andReturn();
*/
      /*  MvcResult mvcResult=mockMvc.perform(get("/medpiper/v1/doctor/getDoctorBasicInfo")
                .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("utf-8"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Status.................."+status);
        String resultContent=mvcResult.getRequest().getContentAsString();
        System.out.println("ResultContent..................."+resultContent);
    */
       /* int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("ResultContent..................."+content);
        assertEquals(200, status);
        */

        //String content = mvcResult.getResponse().getContentAsString();
       // DoctorBasicInfo doctorBasicInfo = mapFromJson(content, DoctorBasicInfo.class);
        //String resultContent=mvcResult.getRequest().getContentAsString();
        //assertTrue(doctorBasicInfo. > 0);
        //System.out.println("ResultContent..................."+resultContent);



    }
}
