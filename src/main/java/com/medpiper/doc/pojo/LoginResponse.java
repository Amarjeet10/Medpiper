package com.medpiper.doc.pojo;

@lombok.Data
public class LoginResponse
{
    private int id;
    private String email;
    private String userRole;
    private String token;
}
