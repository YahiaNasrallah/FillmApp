package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectdesign.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {


    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String idName=intent.getStringExtra("id");





        MyDataBase myDataBase=new MyDataBase(PaymentActivity.this) ;

        binding.filmName.setText(myDataBase.getBookByName2(idName).getFilm_Name());
        binding.filmDate.setText(myDataBase.getBookByName2(idName).getFilm_Date());
        binding.filmTime.setText(myDataBase.getBookByName2(idName).getFilm_Time());
        binding.filmPrice.setText(String.valueOf(Integer.parseInt(myDataBase.getBookByName2(idName).getTotal_Balance())/Integer.parseInt(myDataBase.getBookByName2(idName).getNumber_Chairs())));
        binding.numOfChirs.setText(myDataBase.getBookByName2(idName).getNumber_Chairs());
        binding.filmChairs.setText(myDataBase.getBookByName2(idName).getReserved_Chair1()+","+myDataBase.getBookByName2(idName).getReserved_Chair2());
        binding.filmTotal.setText(myDataBase.getBookByName2(idName).getTotal_Balance());


        binding.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();
                binding.rg3.clearCheck();
                binding.rg4.clearCheck();
            }
        });


        binding.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg1.clearCheck();
                binding.rg3.clearCheck();
                binding.rg4.clearCheck();
            }
        });
        binding.rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();
                binding.rg1.clearCheck();
                binding.rg4.clearCheck();
            }
        });
        binding.rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();
                binding.rg3.clearCheck();
                binding.rg1.clearCheck();
            }
        });



        binding.btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PaymentActivity.this,ViewTicketActivity.class);
                intent.putExtra("id",idName);
                startActivity(intent);
                finish();
            }
        });






    }
}