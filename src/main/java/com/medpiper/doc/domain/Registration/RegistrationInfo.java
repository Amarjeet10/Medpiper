package com.medpiper.doc.domain.Registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="USER_INFO")
@lombok.Data
public class RegistrationInfo
{
    public static final String USERID = "userId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    @Column(unique = true)
    private String email;
    private String pwd;
    private int regType;


    private String userRole;

    @Column(nullable = false)
    private String enabled;

    @Column(columnDefinition = "integer default 1")
    private int otpSent;

    @Column(columnDefinition ="TEXT")
    private String otpHash;

    private Date otpExpiry;


    public List<String> getRoleList(){
        if(this.userRole.length() > 0){
            return Arrays.asList(this.userRole.split(","));
        }
        return new ArrayList<>();
    }

}
