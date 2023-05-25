package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "filme_database";
    private static final String COLUMN_FILM_NAME = "name";
    private static final String COLUMN_FILM_ID = "id";
    private static final String COLUMN_FILM_HOUR = "hour";
    private static final String COLUMN_FILM_TYPE = "type";
    private static final String COLUMN_FILM_LANGUAGE = "language";
    private static final String COLUMN_FILM_CREATE_DATE = "createdate";
    private static final String COLUMN_FILM_CAST = "casting";
    private static final String COLUMN_FILM_CAPTION = "caption";
    private static final String COLUMN_DATE1 = "date1";
    private static final String COLUMN_DATE2 = "date2";
    private static final String COLUMN_DATE3 = "date3";
    private static final String COLUMN_DATE4 = "date4";
    private static final String COLUMN_DATE5 = "date5";
    private static final String COLUMN_TIME1 = "time1";
    private static final String COLUMN_TIME2 = "time2";
    private static final String COLUMN_TIME3 = "time3";
    private static final String COLUMN_FILM_PRICE = "price";

    private static final String COLUMN_ACTOR1_NAME = "actor1";
    private static final String COLUMN_ACTOR2_NAME = "actor2";
    private static final String COLUMN_ACTOR3_NAME = "actor3";
    private static final String COLUMN_ACTOR4_NAME = "actor4";
    private static final String COLUMN_ACTOR5_NAME = "actor5";


    private static final String COLUMN_ACTOR1_Photo = "actor1photo";
    private static final String COLUMN_ACTOR2_Photo = "actor2photo";
    private static final String COLUMN_ACTOR3_Photo = "actor3photo";
    private static final String COLUMN_ACTOR4_Photo = "actor4photo";
    private static final String COLUMN_ACTOR5_Photo = "actor5photo";


    private static final String COLUMN_FILM_PHOTO = "photo";
    private static final String COLUMN_FILM_Banner = "banner";

    private static final String TABLE_FILMS = "Filme_Table";




    //------------------------------------------------------

    private static final String COLUMN_BOOK_PHOTO = "photobook";
    private static final String COLUMN_BOOK_NAME = "namebook";
    private static final String COLUMN_BOOK_ID = "idbook";
    private static final String COLUMN_BOOK_TYPE = "typebook";
    private static final String COLUMN_BOOK_CAST = "castbook";
    private static final String COLUMN_BOOK_TIME = "timebook";
    private static final String COLUMN_BOOK_DATE = "datebook";
    private static final String COLUMN_BOOK_CHAIR1 = "chair1book";
    private static final String COLUMN_BOOK_CHAIR2 = "chair2book";
    private static final String COLUMN_BOOK_ACCOUNT = "accountbook";
    private static final String COLUMN_BOOK_TOTAL = "totalbook";
    private static final String COLUMN_BOOK_NUMCHAIRS = "numchairsbook";



    private static final String TABLE_BOOK = "Book_Table";




    //------------------------------------------------------

    private static final String COLUMN_USER_NAME = "username";
    private static final String COLUMN_USER_PASSWORD = "userpassword";
    private static final String COLUMN_USER_PHONE = "userphone";
    private static final String COLUMN_USER_PHOTO = "userphoto";



    private static final String TABLE_USER = "User_Table";


    //---------------------------------------------------------

    private static final String COLUMN_TEMP_NAME = "usernametemp";
    private static final String COLUMN_TEMP_ID = "idtemp";
    private static final String TABLE_TEMP = "User_Temp";


    public MyDataBase(Context context){
        super(context,DATABASE_NAME,null,120);

    }



    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  Filme_Table ( name TEXT , id TEXT , hour TEXT , type TEXT , language TEXT , createdate TEXT , casting TEXT , caption TEXT , date1 TEXT ," +
                "date2 TEXT ,date3 TEXT ,date4 TEXT,date5 TEXT,time1 TEXT,time2 TEXT,time3 TEXT,price TEXT,actor1 TEXT,actor2 TEXT,actor3 TEXT,actor4 TEXT,actor5 TEXT,photo BLOB," +
                "actor1photo BLOB,actor2photo BLOB,actor3photo BLOB,actor4photo BLOB,actor5photo BLOB,banner BLOB ) ");


        db.execSQL("CREATE TABLE  Book_Table ( photobook BLOB , namebook TEXT , idbook TEXT , typebook TEXT , castbook TEXT , timebook TEXT ,datebook TEXT , chair1book TEXT , chair2book TEXT , accountbook TEXT , totalbook TEXT , numchairsbook TEXT ) ");



        db.execSQL("CREATE TABLE  User_Table ( username TEXT , userpassword TEXT , userphone TEXT , userphoto BLOB ) ");


        db.execSQL("CREATE TABLE  User_Temp ( usernametemp TEXT , idtemp TEXT ) ");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP);
        onCreate(db);
    }



    //----------------------FILM-----------------------
    public boolean AddFilm(Filme filme){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FILM_NAME,filme.getFilmName());
        values.put(COLUMN_FILM_ID,filme.getFilmID());
        values.put(COLUMN_FILM_HOUR,filme.getFilmHoure());
        values.put(COLUMN_FILM_CAST,filme.getFilmCast());
        values.put(COLUMN_FILM_TYPE,filme.getFilmType());
        values.put(COLUMN_FILM_LANGUAGE,filme.getFilmLanguge());
        values.put(COLUMN_FILM_CREATE_DATE,filme.getFilmCreateDate());
        values.put(COLUMN_ACTOR1_NAME,filme.getActor1_name());
        values.put(COLUMN_ACTOR2_NAME,filme.getActor2_name());
        values.put(COLUMN_ACTOR3_NAME,filme.getActor3_name());
        values.put(COLUMN_ACTOR4_NAME,filme.getActor4_name());
        values.put(COLUMN_ACTOR5_NAME,filme.getActor5_name());
        values.put(COLUMN_FILM_CAPTION,filme.getFilmCaption());
        values.put(COLUMN_DATE1,filme.getDate1());
        values.put(COLUMN_DATE2,filme.getDate2());
        values.put(COLUMN_DATE3,filme.getDate3());
        values.put(COLUMN_DATE4,filme.getDate4());
        values.put(COLUMN_DATE5,filme.getDate5());
        values.put(COLUMN_TIME1,filme.getTime1());
        values.put(COLUMN_TIME2,filme.getTime2());
        values.put(COLUMN_TIME3,filme.getTime3());
        values.put(COLUMN_FILM_PRICE,filme.getFilmPrice());

        values.put(COLUMN_ACTOR1_Photo,getBytes(filme.getActor1_photo()));
        values.put(COLUMN_ACTOR2_Photo,getBytes(filme.getActor2_photo()));
        values.put(COLUMN_ACTOR3_Photo,getBytes(filme.getActor3_photo()));
        values.put(COLUMN_ACTOR4_Photo,getBytes(filme.getActor4_photo()));
        values.put(COLUMN_ACTOR5_Photo,getBytes(filme.getActor5_photo()));

        values.put(COLUMN_FILM_PHOTO,getBytes(filme.getFilm_Photo()));
        values.put(COLUMN_FILM_Banner,getBytes(filme.getFilm_Banner()));




        long filmId = db.insert(TABLE_FILMS, null, values);

        db.close();
        return filmId!=0;

    }



    @SuppressLint("Range")
    public Filme getFilmByName(String filmname) {
        SQLiteDatabase db = getReadableDatabase();
        Filme filme = new Filme();

        String[] condition = {filmname + ""};
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_FILMS + " where " + COLUMN_FILM_NAME + " =? ", condition);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
            filme.setFilmName(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_NAME)));
            filme.setFilmID(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_ID)));
            filme.setFilmHoure(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_HOUR)));
            filme.setFilmCast(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_CAST)));
            filme.setFilmType(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_TYPE)));
            filme.setFilmLanguge(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_LANGUAGE)));
            filme.setFilmCreateDate(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_CREATE_DATE)));
            filme.setActor1_name(cursor.getString(cursor.getColumnIndex(COLUMN_ACTOR1_NAME)));
            filme.setActor2_name(cursor.getString(cursor.getColumnIndex(COLUMN_ACTOR2_NAME)));
            filme.setActor3_name(cursor.getString(cursor.getColumnIndex(COLUMN_ACTOR3_NAME)));
            filme.setActor4_name(cursor.getString(cursor.getColumnIndex(COLUMN_ACTOR4_NAME)));
            filme.setActor5_name(cursor.getString(cursor.getColumnIndex(COLUMN_ACTOR5_NAME)));
            filme.setActor1_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR1_Photo))));
            filme.setActor2_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR2_Photo))));
            filme.setActor3_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR3_Photo))));
            filme.setActor4_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR4_Photo))));
            filme.setActor5_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR5_Photo))));
            filme.setFilmCaption(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_CAPTION)));
            filme.setDate1(cursor.getString(cursor.getColumnIndex(COLUMN_DATE1)));
            filme.setDate2(cursor.getString(cursor.getColumnIndex(COLUMN_DATE2)));
            filme.setDate3(cursor.getString(cursor.getColumnIndex(COLUMN_DATE3)));
            filme.setDate4(cursor.getString(cursor.getColumnIndex(COLUMN_DATE4)));
            filme.setDate5(cursor.getString(cursor.getColumnIndex(COLUMN_DATE5)));

            filme.setTime1(cursor.getString(cursor.getColumnIndex(COLUMN_TIME1)));
            filme.setTime2(cursor.getString(cursor.getColumnIndex(COLUMN_TIME2)));
            filme.setTime3(cursor.getString(cursor.getColumnIndex(COLUMN_TIME3)));
            filme.setFilmPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_PRICE)));

            filme.setActor1_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR1_Photo))));
            filme.setActor2_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR2_Photo))));
            filme.setActor3_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR3_Photo))));
            filme.setActor4_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR4_Photo))));
            filme.setActor5_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR5_Photo))));
            filme.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_FILM_PHOTO))));
            filme.setFilm_Banner(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_FILM_Banner))));


                cursor.moveToNext();

            }
        }



        return filme ;


    }




    @SuppressLint("Range")
    public ArrayList<Filme> getAllFilms2() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Filme> filmeList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FILMS, null);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Filme filme = new Filme();
                filme.setFilmName(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_NAME)));
                filme.setFilmID(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_ID)));
                filme.setFilmHoure(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_HOUR)));
                filme.setFilmCast(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_CAST)));
                filme.setFilmType(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_TYPE)));
                filme.setFilmLanguge(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_LANGUAGE)));
                filme.setActor1_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR1_Photo))));
                filme.setActor2_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR2_Photo))));
                filme.setActor3_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR3_Photo))));
                filme.setActor4_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR4_Photo))));
                filme.setActor5_photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_ACTOR5_Photo))));
                filme.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_FILM_PHOTO))));
                filme.setFilm_Banner(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_FILM_Banner))));


                filmeList.add(filme);
                cursor.moveToNext();

            }
        }

        cursor.close();
        return filmeList;
    }

    @SuppressLint("Range")
    public ArrayList<Filme> getFilmByType(String type) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Filme> filmeList = new ArrayList<>();

        String[] condition = {type + ""};
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_FILMS + " where " + COLUMN_FILM_TYPE + " =? ", condition);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Filme filme = new Filme();

                filme.setFilmName(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_NAME)));
                filme.setFilmID(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_ID)));
                filme.setFilmHoure(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_HOUR)));
                filme.setFilmCast(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_CAST)));
                filme.setFilmType(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_TYPE)));
                filme.setFilmLanguge(cursor.getString(cursor.getColumnIndex(COLUMN_FILM_LANGUAGE)));
                filme.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_FILM_PHOTO))));


                filmeList.add(filme);
                cursor.moveToNext();

            }
        }

        cursor.close();
        return filmeList;
    }







    //----------------------------BOOK-------------------------------

    public boolean AddBOOK(Booked booked){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_BOOK_NAME,booked.getFilm_Name());
        values.put(COLUMN_BOOK_ID,booked.getFilm_ID());
        values.put(COLUMN_BOOK_CAST,booked.getFilm_Cast());
        values.put(COLUMN_BOOK_TYPE,booked.getFilm_Type());
        values.put(COLUMN_BOOK_TIME,booked.getFilm_Time());
        values.put(COLUMN_BOOK_DATE,booked.getFilm_Date());
        values.put(COLUMN_BOOK_CHAIR1,booked.getReserved_Chair1());
        values.put(COLUMN_BOOK_CHAIR2,booked.getReserved_Chair2());
        values.put(COLUMN_BOOK_ACCOUNT,booked.getAccount_Name());
        values.put(COLUMN_BOOK_TOTAL,booked.getTotal_Balance());
        values.put(COLUMN_BOOK_NUMCHAIRS,booked.getNumber_Chairs());

        values.put(COLUMN_BOOK_PHOTO,getBytes(booked.getFilm_Photo()));




        long bookId = db.insert(TABLE_BOOK, null, values);

        db.close();
        return bookId!=0;

    }




    @SuppressLint("Range")
    public ArrayList<Booked> getAllBooked() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Booked> bookList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BOOK, null);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Booked booked = new Booked();

                booked.setFilm_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NAME)));
                booked.setFilm_ID(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ID)));
                booked.setFilm_Type(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TYPE)));
                booked.setFilm_Cast(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CAST)));
                booked.setFilm_Time(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TIME)));
                booked.setFilm_Date(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_DATE)));
                booked.setReserved_Chair1(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR1)));
                booked.setReserved_Chair2(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR2)));
                booked.setAccount_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ACCOUNT)));
                booked.setTotal_Balance(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TOTAL)));
                booked.setNumber_Chairs(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NUMCHAIRS)));

                booked.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_BOOK_PHOTO))));


                bookList.add(booked);
                cursor.moveToNext();

            }
        }

        cursor.close();
        return bookList;
    }




    @SuppressLint("Range")
    public Booked getBookByName(String bookname) {
        SQLiteDatabase db = getReadableDatabase();
        Booked booked = new Booked();

        String[] condition = {bookname + ""};
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_BOOK + " where " + COLUMN_BOOK_NAME + " =? ", condition);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                booked.setFilm_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NAME)));
                booked.setFilm_ID(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ID)));
                booked.setFilm_Type(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TYPE)));
                booked.setFilm_Cast(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CAST)));
                booked.setFilm_Time(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TIME)));
                booked.setFilm_Date(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_DATE)));
                booked.setReserved_Chair1(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR1)));
                booked.setReserved_Chair2(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR2)));
                booked.setAccount_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ACCOUNT)));
                booked.setTotal_Balance(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TOTAL)));
                booked.setNumber_Chairs(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NUMCHAIRS)));

                booked.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_BOOK_PHOTO))));


                cursor.moveToNext();

            }
        }



        return booked ;


    }




    @SuppressLint("Range")
    public Booked getBookByName2(String bookname) {
        SQLiteDatabase db = getReadableDatabase();
        Booked booked = new Booked();

        String[] condition = {bookname + ""};
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_BOOK + " where " + COLUMN_BOOK_ID + " =? ", condition);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                booked.setFilm_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NAME)));
                booked.setFilm_ID(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ID)));
                booked.setFilm_Type(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TYPE)));
                booked.setFilm_Cast(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CAST)));
                booked.setFilm_Time(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TIME)));
                booked.setFilm_Date(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_DATE)));
                booked.setReserved_Chair1(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR1)));
                booked.setReserved_Chair2(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_CHAIR2)));
                booked.setAccount_Name(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_ACCOUNT)));
                booked.setTotal_Balance(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TOTAL)));
                booked.setNumber_Chairs(cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_NUMCHAIRS)));

                booked.setFilm_Photo(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_BOOK_PHOTO))));


                cursor.moveToNext();

            }
        }



        return booked ;


    }





    //---------------------USER------------------------

    public boolean AddUser(User user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_NAME,user.getUserName());
        values.put(COLUMN_USER_PASSWORD,user.getUserPassword());
        values.put(COLUMN_USER_PHONE,user.getUserPhone());
        values.put(COLUMN_USER_PHOTO,getBytes(user.getPhoto()));





        long userId = db.insert(TABLE_USER, null, values);

        db.close();
        return userId!=0;


    }



    @SuppressLint("Range")
    public User getUserByName(String username) {
        SQLiteDatabase db = getReadableDatabase();
        User user = new User();

        String[] condition = {username + ""};
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_USER + " where " + COLUMN_FILM_NAME + " =? ", condition);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                user.setUserName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setUserPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setUserPhone(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PHONE)));
                user.setPhoto(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_USER_PHOTO))));



                cursor.moveToNext();

            }
        }



        return user ;


    }


    @SuppressLint("Range")
    public ArrayList<User> getAllUser() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<User> userArrayList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                User user = new User();


                user.setUserName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setUserPhone(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PHONE)));
                user.setUserPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setPhoto(getImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_USER_PHOTO))));


                userArrayList.add(user);
                cursor.moveToNext();

            }
        }

        cursor.close();
        return userArrayList;
    }



    @SuppressLint("Range")
    public boolean CheckUser(String name,String password) {
        SQLiteDatabase db = getReadableDatabase();

        boolean flag=false;
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {


                if (cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)).equals(name)&&
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)).equals(password)){
                    flag=true;
                }


                cursor.moveToNext();

            }
        }

        cursor.close();
        return flag;
    }


    //-----------------------TEMP--------------------------------

    public boolean AddTemp(String name){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TEMP_NAME,name);
        values.put(COLUMN_TEMP_ID,"1");

        long tempId = db.insert(TABLE_TEMP, null, values);

        db.close();
        return tempId!=0;


    }


    @SuppressLint("Range")
    public String getTemp() {
        SQLiteDatabase db = getReadableDatabase();
        String name="";
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + TABLE_TEMP,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                name=cursor.getString(cursor.getColumnIndex(COLUMN_TEMP_NAME));

                cursor.moveToNext();

            }
        }



        return name ;


    }



    public boolean UpdateTemp(String temp) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TEMP_NAME,temp);
        String[] array = { 1+""};
        long result = sqLiteDatabase.update(TABLE_TEMP,values,
                " " +COLUMN_TEMP_ID + "=? ",array);

        return result>0;

}





    //------------------------------------------------
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }


}
