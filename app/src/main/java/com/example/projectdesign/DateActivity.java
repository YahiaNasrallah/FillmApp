package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityDateBinding;

public class DateActivity extends AppCompatActivity {

        int num;
        String booked1;
        String booked2;

        String Date;
        String Time;

    ActivityDateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String idName=intent.getStringExtra("name");
        MyDataBase myDataBase=new MyDataBase(DateActivity.this);

        binding.Time1.setText(myDataBase.getFilmByName(idName).getTime1());
        binding.Time2.setText(myDataBase.getFilmByName(idName).getTime2());
        binding.Time3.setText(myDataBase.getFilmByName(idName).getTime3());




        String date1=myDataBase.getFilmByName(idName).getDate1();
        String date2=myDataBase.getFilmByName(idName).getDate2();
        String date3=myDataBase.getFilmByName(idName).getDate3();
        String date4=myDataBase.getFilmByName(idName).getDate4();
        String date5=myDataBase.getFilmByName(idName).getDate5();



        if (date1.contains(" ")){
            binding.tvMonth1.setText(date1.substring(0,date1.indexOf(" ")));
            binding.tvDay1.setText(date1.substring(date1.indexOf(" ")));
        }else {
            binding.tvMonth1.setText(date1);
            binding.tvDay1.setText(date1);
        }
        if (date2.contains(" ")){
            binding.tvMonth2.setText(date2.substring(0,date2.indexOf(" ")));
            binding.tvDay2.setText(date2.substring(date2.indexOf(" ")));
        }else {
            binding.tvMonth2.setText(date2);
            binding.tvDay2.setText(date2);
        }

        if (date3.contains(" ")){
            binding.tvMonth3.setText(date3.substring(0,date3.indexOf(" ")));
            binding.tvDay3.setText(date3.substring(date3.indexOf(" ")));
        }else {
            binding.tvMonth3.setText(date3);
            binding.tvDay3.setText(date3);
        }

        if (date4.contains(" ")){
            binding.tvMonth4.setText(date4.substring(0,date4.indexOf(" ")));
            binding.tvDay4.setText(date4.substring(date4.indexOf(" ")));
        }else {
            binding.tvMonth4.setText(date4);
            binding.tvDay4.setText(date4);
        }

        if (date5.contains(" ")){
            binding.tvMonth5.setText(date5.substring(0,date5.indexOf(" ")));
            binding.tvDay5.setText(date5.substring(date5.indexOf(" ")));
        }else {
            binding.tvMonth5.setText(date5);
            binding.tvDay5.setText(date5);
        }


      click(binding.a1);
      click(binding.a2);
      click(binding.a3);
      click(binding.a4);
      click(binding.a5);
      click(binding.a6);
      click(binding.a7);
      click(binding.a8);

        click(binding.b1);
        click(binding.b2);
        click(binding.b3);
        click(binding.b4);
        click(binding.b5);
        click(binding.b6);
        click(binding.b7);
        click(binding.b8);


        click(binding.c1);
        click(binding.c2);
        click(binding.c3);
        click(binding.c4);
        click(binding.c5);
        click(binding.c6);
        click(binding.c7);
        click(binding.c8);


        click(binding.d1);
        click(binding.d2);
        click(binding.d3);
        click(binding.d4);
        click(binding.d5);
        click(binding.d6);
        click(binding.d7);
        click(binding.d8);



        click(binding.e3);
        click(binding.e4);
        click(binding.e5);
        click(binding.e6);
        click(binding.e7);
        click(binding.e8);



        binding.Date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date=date1;
                binding.Date1.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.tvMonth1.setTextColor(getResources().getColorStateList(R.color.Wihte));
                binding.tvDay1.setTextColor(getResources().getColorStateList(R.color.Wihte));


                binding.Date2.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth2.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay2.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date3.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth3.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay3.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date4.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth4.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay4.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date5.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth5.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay5.setTextColor(getResources().getColorStateList(R.color.wite));

            }
        });

        binding.Date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date=date2;
                binding.Date1.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth1.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay1.setTextColor(getResources().getColorStateList(R.color.wite));


                binding.Date2.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.tvMonth2.setTextColor(getResources().getColorStateList(R.color.Wihte));
                binding.tvDay2.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.Date3.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth3.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay3.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date4.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth4.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay4.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date5.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth5.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay5.setTextColor(getResources().getColorStateList(R.color.wite));

            }
        });


        binding.Date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date=date3;
                binding.Date1.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth1.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay1.setTextColor(getResources().getColorStateList(R.color.wite));


                binding.Date2.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth2.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay2.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date3.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.tvMonth3.setTextColor(getResources().getColorStateList(R.color.Wihte));
                binding.tvDay3.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.Date4.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth4.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay4.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date5.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth5.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay5.setTextColor(getResources().getColorStateList(R.color.wite));

            }
        });

        binding.Date4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date=date4;
                binding.Date1.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth1.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay1.setTextColor(getResources().getColorStateList(R.color.wite));


                binding.Date2.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth2.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay2.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date3.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth3.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay3.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date4.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.tvMonth4.setTextColor(getResources().getColorStateList(R.color.Wihte));
                binding.tvDay4.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.Date5.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth5.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay5.setTextColor(getResources().getColorStateList(R.color.wite));

            }
        });

        binding.Date5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date=date5;
                binding.Date1.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth1.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay1.setTextColor(getResources().getColorStateList(R.color.wite));


                binding.Date2.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth2.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay2.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date3.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth3.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay3.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date4.setBackgroundTintList(getResources().getColorStateList(R.color.dark3));
                binding.tvMonth4.setTextColor(getResources().getColorStateList(R.color.wite));
                binding.tvDay4.setTextColor(getResources().getColorStateList(R.color.wite));

                binding.Date5.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.tvMonth5.setTextColor(getResources().getColorStateList(R.color.Wihte));
                binding.tvDay5.setTextColor(getResources().getColorStateList(R.color.Wihte));

            }
        });


        binding.Time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time=binding.Time1.getText().toString();
                binding.Time1.setBackgroundTintList(getResources().getColorStateList(R.color.color));

                binding.Time2.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));
                binding.Time3.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));


            }
        });

        binding.Time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time=binding.Time2.getText().toString();
                binding.Time1.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));

                binding.Time2.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.Time3.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));


            }
        });

        binding.Time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time=binding.Time3.getText().toString();
                binding.Time1.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));

                binding.Time2.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));
                binding.Time3.setBackgroundTintList(getResources().getColorStateList(R.color.color));


            }
        });


        binding.btnPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        MyDataBase myDataBase=new MyDataBase(DateActivity.this);



                        Booked booked=new Booked();

                        Bitmap bitmap=myDataBase.getFilmByName(idName).getFilm_Photo();
                        String name=myDataBase.getFilmByName(idName).getFilmName();
                        String id=myDataBase.getFilmByName(idName).getFilmID()+""+myDataBase.getFilmByName(idName).getFilmName();
                        String type=myDataBase.getFilmByName(idName).getFilmType();
                        String cast=myDataBase.getFilmByName(idName).getFilmCast();
                        String time=Time;
                        String date=Date;
                        String chair1=booked1;
                        String chair2=booked2;
                        String account=myDataBase.getTemp();
                        String total=String.valueOf(Integer.parseInt(myDataBase.getFilmByName(idName).getFilmPrice())*num);
                        String numChairs=String.valueOf(num);



                                booked=new Booked(bitmap,name,id,type,cast,time,date,chair1,chair2,account,total,numChairs);







                                if (myDataBase.AddBOOK(booked)){
                                    Toast.makeText(DateActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(DateActivity.this, "NO", Toast.LENGTH_SHORT).show();

                                }











                        Intent intent = new Intent(DateActivity.this, PaymentActivity.class);
                        intent.putExtra("id",id);
                        startActivity(intent);
                        finish();
                    }
                });





    }



    public void click(View view){

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num<2) {

                    num++;
                    if (num==1){
                        booked1=String.valueOf(view.getTag());
                        Toast.makeText(DateActivity.this, booked1, Toast.LENGTH_SHORT).show();

                    } else if (num==2) {
                        booked2=String.valueOf(view.getTag());
                        Toast.makeText(DateActivity.this, booked2, Toast.LENGTH_SHORT).show();

                    }


                    view.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                } else {
                    Toast.makeText(DateActivity.this, "Cant Resere More Than 2", Toast.LENGTH_SHORT).show();
                }

        }});

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {



                if (num==2){
                    booked2="";
                } else if (num==1) {
                    booked1="";

                }
                num--;
                view.setBackgroundTintList(getResources().getColorStateList(R.color.dark2));


                return false;
            }
        });




}



}