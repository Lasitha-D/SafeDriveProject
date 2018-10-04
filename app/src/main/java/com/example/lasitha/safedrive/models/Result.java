package com.example.lasitha.safedrive.models;


import com.google.gson.annotations.SerializedName;

/*
* Created 27/09/2018 @10.36pm
* RL Dilshan
* */

public class Result {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("adminLogin")
    private AdminLogin adminLogin;


    public Result(Boolean error, String message, AdminLogin adminLogin) {
        this.error = error;
        this.message = message;
        this.adminLogin = adminLogin;

    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public AdminLogin getAdminLogin() {
        return adminLogin;
    }

}