package com.project_n.mvvmbelajarproject1.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class People implements Serializable {


    @SerializedName("gender")
    public String gender;


    @SerializedName("name")
    public String name;


    @SerializedName("location")
    public Location location;


    @SerializedName("mail")
    public String mail;


    @SerializedName("login")
    public String login;


    @SerializedName("phone")
    public String phone;


    @SerializedName("cell")
    public String cell;


    @SerializedName("picture")
    public Picture picture;



    public String fullName;

    public Boolean hasEmail(){
        return mail != null && !mail.isEmpty();
    }

}
