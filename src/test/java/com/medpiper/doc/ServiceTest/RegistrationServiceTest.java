package com.medpiper.doc.ServiceTest;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.repository.registration.RegistrationInfoRepository;
import com.medpiper.doc.service.RegistrationService;
import com.medpiper.doc.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)

@SpringBootTest
public class RegistrationServiceTest
{
    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private RegistrationInfoRepository registrationInfoRepository;
    @Test
    public void saveUserTest()
    {
        RegistrationInfo registrationInfo=new RegistrationInfo();
        registrationInfo.setUserId(1);
        registrationInfo.setName("Amarjeet");
        registrationInfo.setEmail("amarjeet");
        registrationInfo.setPwd("abc123");
        registrationInfo.setRegType(100);
        registrationInfo.setUserRole("ROLE_DOCTOR");
        registrationInfo.setOtpHash("1234");
        registrationInfo.setOtpExpiry(Utils.getOtpExpiryTime());
        registrationInfo.setEnabled("FALSE");
        registrationInfo.setOtpSent(1);
        when(registrationInfoRepository.save(registrationInfo)).thenReturn(registrationInfo);
        assertEquals(registrationInfo,registrationService.saveUser(registrationInfo));
    }
}
