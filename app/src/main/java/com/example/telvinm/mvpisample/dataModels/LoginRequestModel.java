package com.example.telvinm.mvpisample.dataModels;

import com.google.gson.annotations.SerializedName;

public class LoginRequestModel
{
    @SerializedName("Password")
    String password;

    @SerializedName("UserName")
    String userName;


    public LoginRequestModel(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }
}
