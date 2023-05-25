package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.projectdesign.databinding.ActivityShowProfileBinding;

public class ShowProfile extends AppCompatActivity {

    boolean flag=true;
    ActivityShowProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        MyDataBase myDataBase=new MyDataBase(this);


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.imageUser.setImageBitmap(myDataBase.getUserByName(myDataBase.getTemp()).getPhoto());
        binding.tvUserName.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
        binding.tvNameShow.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
        binding.tvUserPhone.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPhone());

        binding.showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag){
                binding.tvUserPassword.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPassword());
                binding.showHide.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                flag=false;
            } else if (flag==false) {
                    binding.tvUserPassword.setText("*****");
                    binding.showHide.setImageResource(R.drawable.baseline_hide_source_24);
                    flag=true;
                }

            }
        });







    }
}