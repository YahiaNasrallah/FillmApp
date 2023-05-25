package com.example.projectdesign;

public class Dates {

    private String Mothe;
    private int Day;

    public Dates(){

    }

    public Dates(String mothe, int day) {
        Mothe = mothe;
        Day = day;
    }


    public String getMothe() {
        return Mothe;
    }

    public void setMothe(String mothe) {
        Mothe = mothe;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }
}
