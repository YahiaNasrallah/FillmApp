package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectdesign.databinding.ActivityViewTicketBinding;

public class ViewTicketActivity extends AppCompatActivity {


    ActivityViewTicketBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String idName=intent.getStringExtra("id");
        MyDataBase myDataBase=new MyDataBase(ViewTicketActivity.this);


        binding.tvFilmName.setText(myDataBase.getBookByName2(idName).getFilm_Name());
        binding.tvFilmCast.setText(myDataBase.getBookByName2(idName).getFilm_Cast());
        binding.tvFilmType.setText(myDataBase.getBookByName2(idName).getFilm_Type());
        binding.imageFilm.setImageBitmap(myDataBase.getBookByName2(idName).getFilm_Photo());
        binding.tvFilmDate.setText(myDataBase.getBookByName2(idName).getFilm_Date());
        binding.tvFilmTime.setText(myDataBase.getBookByName2(idName).getFilm_Time());
        binding.tvAccount.setText(myDataBase.getBookByName2(idName).getAccount_Name());
        binding.tvFilmTotal.setText(myDataBase.getBookByName2(idName).getTotal_Balance());
        binding.tvFilmNum.setText(myDataBase.getBookByName2(idName).getNumber_Chairs());
        binding.tvFilmChairs.setText(myDataBase.getBookByName2(idName).getReserved_Chair1()+","+myDataBase.getBookByName2(idName).getReserved_Chair2());





        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewTicketActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}