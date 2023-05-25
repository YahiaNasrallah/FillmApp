package com.example.projectdesign;

import android.graphics.Bitmap;

public class User {

    private Bitmap Photo;
    private String UserName;
    private String UserPassword;
    private String UserPhone;

    public User(){

    }

    public User(Bitmap photo, String userName, String userPassword, String userPhone) {
        Photo = photo;
        UserName = userName;
        UserPassword = userPassword;
        UserPhone = userPhone;
    }

    public Bitmap getPhoto() {
        return Photo;
    }

    public void setPhoto(Bitmap photo) {
        Photo = photo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
}
