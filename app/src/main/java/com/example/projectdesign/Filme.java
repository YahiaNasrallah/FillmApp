package com.example.projectdesign;

import android.graphics.Bitmap;
import android.net.Uri;

public class Filme {

    private String filmName;
    private String filmID;



    private String FilmHoure;
    private String FilmType;
    private String FilmLanguge;
    private String FilmCreateDate;
    private String FilmCast;


    private String Actor1_name;

    private String Actor2_name;

    private String Actor3_name;

    private String Actor4_name;

    private String Actor5_name;


    private Bitmap Actor1_photo;

    private Bitmap Actor2_photo;

    private Bitmap Actor3_photo;

    private Bitmap Actor4_photo;

    private Bitmap Actor5_photo;

    private String FilmCaption;

    private String Date1;
    private String Date2;
    private String Date3;
    private String Date4;
    private String Date5;

    private String Time1;
    private String Time2;
    private String Time3;
    private String FilmPrice;

    private Bitmap Film_Banner;
    private Bitmap Film_Photo;


    public Filme() {
    }

    public Filme(String filmName,String filmID, String filmHoure, String filmType, String filmLanguge, String filmCreateDate,
                 String filmCast, String actor1_name, String actor2_name, String actor3_name, String actor4_name,
                 String actor5_name, String filmCaption, String date1, String date2, String date3, String date4,
                 String date5, String time1, String time2, String time3, String filmPrice,Bitmap film_Photo,Bitmap banner
    ,Bitmap actor1_photo,Bitmap actor2_photo,Bitmap actor3_photo,Bitmap actor4_photo,Bitmap actor5_photo) {
        this.filmName = filmName;
        this.filmID=filmID;
        FilmHoure = filmHoure;
        FilmType = filmType;
        FilmLanguge = filmLanguge;
        FilmCreateDate = filmCreateDate;
        FilmCast = filmCast;
        Actor1_name = actor1_name;
        Actor2_name = actor2_name;
        Actor3_name = actor3_name;
        Actor4_name = actor4_name;
        Actor5_name = actor5_name;
        FilmCaption = filmCaption;
        Date1 = date1;
        Date2 = date2;
        Date3 = date3;
        Date4 = date4;
        Date5 = date5;
        Time1 = time1;
        Time2 = time2;
        Time3 = time3;
        FilmPrice = filmPrice;
        this.Film_Photo=film_Photo;
        this.Film_Banner=banner;
        this.Actor1_photo=actor1_photo;
        this.Actor2_photo=actor2_photo;
        this.Actor3_photo=actor3_photo;
        this.Actor4_photo=actor4_photo;
        this.Actor5_photo=actor5_photo;

    }

    public Bitmap getActor1_photo() {
        return Actor1_photo;
    }

    public void setActor1_photo(Bitmap actor1_photo) {
        Actor1_photo = actor1_photo;
    }

    public Bitmap getActor2_photo() {
        return Actor2_photo;
    }

    public void setActor2_photo(Bitmap actor2_photo) {
        Actor2_photo = actor2_photo;
    }

    public Bitmap getActor3_photo() {
        return Actor3_photo;
    }

    public void setActor3_photo(Bitmap actor3_photo) {
        Actor3_photo = actor3_photo;
    }

    public Bitmap getActor4_photo() {
        return Actor4_photo;
    }

    public void setActor4_photo(Bitmap actor4_photo) {
        Actor4_photo = actor4_photo;
    }

    public Bitmap getActor5_photo() {
        return Actor5_photo;
    }

    public void setActor5_photo(Bitmap actor5_photo) {
        Actor5_photo = actor5_photo;
    }

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }

    public Bitmap getFilm_Banner() {
        return Film_Banner;
    }

    public void setFilm_Banner(Bitmap film_Banner) {
        Film_Banner = film_Banner;
    }

    public Bitmap getFilm_Photo() {
        return Film_Photo;
    }

    public void setFilm_Photo(Bitmap film_Photo) {
        Film_Photo = film_Photo;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmHoure() {
        return FilmHoure;
    }

    public void setFilmHoure(String filmHoure) {
        FilmHoure = filmHoure;
    }

    public String getFilmType() {
        return FilmType;
    }

    public void setFilmType(String filmType) {
        FilmType = filmType;
    }

    public String getFilmLanguge() {
        return FilmLanguge;
    }

    public void setFilmLanguge(String filmLanguge) {
        FilmLanguge = filmLanguge;
    }

    public String getFilmCreateDate() {
        return FilmCreateDate;
    }

    public void setFilmCreateDate(String filmCreateDate) {
        FilmCreateDate = filmCreateDate;
    }

    public String getFilmCast() {
        return FilmCast;
    }

    public void setFilmCast(String filmCast) {
        FilmCast = filmCast;
    }

    public String getActor1_name() {
        return Actor1_name;
    }

    public void setActor1_name(String actor1_name) {
        Actor1_name = actor1_name;
    }

    public String getActor2_name() {
        return Actor2_name;
    }

    public void setActor2_name(String actor2_name) {
        Actor2_name = actor2_name;
    }

    public String getActor3_name() {
        return Actor3_name;
    }

    public void setActor3_name(String actor3_name) {
        Actor3_name = actor3_name;
    }

    public String getActor4_name() {
        return Actor4_name;
    }

    public void setActor4_name(String actor4_name) {
        Actor4_name = actor4_name;
    }

    public String getActor5_name() {
        return Actor5_name;
    }

    public void setActor5_name(String actor5_name) {
        Actor5_name = actor5_name;
    }

    public String getFilmCaption() {
        return FilmCaption;
    }

    public void setFilmCaption(String filmCaption) {
        FilmCaption = filmCaption;
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        Date2 = date2;
    }

    public String getDate3() {
        return Date3;
    }

    public void setDate3(String date3) {
        Date3 = date3;
    }

    public String getDate4() {
        return Date4;
    }

    public void setDate4(String date4) {
        Date4 = date4;
    }

    public String getDate5() {
        return Date5;
    }

    public void setDate5(String date5) {
        Date5 = date5;
    }

    public String getTime1() {
        return Time1;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public String getTime2() {
        return Time2;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }

    public String getTime3() {
        return Time3;
    }

    public void setTime3(String time3) {
        Time3 = time3;
    }

    public String getFilmPrice() {
        return FilmPrice;
    }

    public void setFilmPrice(String filmPrice) {
        FilmPrice = filmPrice;
    }
}
