package com.medpiper.doc.repository.registration;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Date;

public interface RegistrationInfoRepository extends JpaRepository<RegistrationInfo, Integer>
{
    @Query(value="SELECT * FROM user_info u WHERE u.email=?1",nativeQuery = true)
    RegistrationInfo findUserByEmail(@PathVariable("email") String email);

    @Query(value="SELECT otp_hash FROM user_info u WHERE u.email=?1",nativeQuery = true)
    String getOtpOfEmail(@PathVariable("email") String email);

    @Query(value="SELECT otp_expiry FROM user_info u WHERE u.email=?1",nativeQuery = true)
    Date getOtpExpirationOfEmail(@PathVariable("email") String email);

    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value="update user_info u set u.enabled='TRUE',u.otp_sent=0,u.otp_expiry='0000-00-00 00:00:00',u.otp_hash='' where u.email=?1 ",nativeQuery = true)
    int enableUser(@RequestParam("email") String email);



}
