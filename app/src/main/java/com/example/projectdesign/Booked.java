package com.example.projectdesign;

import android.graphics.Bitmap;

public class Booked {

    private Bitmap Film_Photo;
    private String Film_Name;
    private String Film_ID;
    private String Film_Type;
    private String Film_Cast;
    private String Film_Time;
    private String Film_Date;
    private String Reserved_Chair1;
    private String Reserved_Chair2;
    private String Account_Name;
    private String Total_Balance;
    private String Number_Chairs;


    public Booked(Bitmap film_Photo, String film_Name, String film_ID, String film_Type, String film_Cast,
                  String film_Time, String film_Date, String reserved_Chair1, String reserved_Chair2,
                  String account_Name, String total_Balance,String chairsNum) {
        Film_Photo = film_Photo;
        Film_Name = film_Name;
        Film_ID = film_ID;
        Film_Type = film_Type;
        Film_Cast = film_Cast;
        Film_Time = film_Time;
        Film_Date = film_Date;
        Reserved_Chair1 = reserved_Chair1;
        Reserved_Chair2 = reserved_Chair2;
        Account_Name = account_Name;
        Total_Balance = total_Balance;
        this.Number_Chairs=chairsNum;
    }

    public Booked(){

    }

    public String getNumber_Chairs() {
        return Number_Chairs;
    }

    public void setNumber_Chairs(String number_Chairs) {
        Number_Chairs = number_Chairs;
    }

    public Bitmap getFilm_Photo() {
        return Film_Photo;
    }

    public void setFilm_Photo(Bitmap film_Photo) {
        Film_Photo = film_Photo;
    }

    public String getFilm_Name() {
        return Film_Name;
    }

    public void setFilm_Name(String film_Name) {
        Film_Name = film_Name;
    }

    public String getFilm_ID() {
        return Film_ID;
    }

    public void setFilm_ID(String film_ID) {
        Film_ID = film_ID;
    }

    public String getFilm_Type() {
        return Film_Type;
    }

    public void setFilm_Type(String film_Type) {
        Film_Type = film_Type;
    }

    public String getFilm_Cast() {
        return Film_Cast;
    }

    public void setFilm_Cast(String film_Cast) {
        Film_Cast = film_Cast;
    }

    public String getFilm_Time() {
        return Film_Time;
    }

    public void setFilm_Time(String film_Time) {
        Film_Time = film_Time;
    }

    public String getFilm_Date() {
        return Film_Date;
    }

    public void setFilm_Date(String film_Date) {
        Film_Date = film_Date;
    }

    public String getReserved_Chair1() {
        return Reserved_Chair1;
    }

    public void setReserved_Chair1(String reserved_Chair1) {
        Reserved_Chair1 = reserved_Chair1;
    }

    public String getReserved_Chair2() {
        return Reserved_Chair2;
    }

    public void setReserved_Chair2(String reserved_Chair2) {
        Reserved_Chair2 = reserved_Chair2;
    }

    public String getAccount_Name() {
        return Account_Name;
    }

    public void setAccount_Name(String account_Name) {
        Account_Name = account_Name;
    }

    public String getTotal_Balance() {
        return Total_Balance;
    }

    public void setTotal_Balance(String total_Balance) {
        Total_Balance = total_Balance;
    }
}
