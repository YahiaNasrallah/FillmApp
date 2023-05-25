package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityAdminLoginBinding;
import com.example.projectdesign.databinding.ActivityAdminMainBinding;

public class AdminLogin extends AppCompatActivity {


    ActivityAdminLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginAdmin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminLogin.this, AdminMain.class);
                startActivity(intent);
            }
        });



    }


}