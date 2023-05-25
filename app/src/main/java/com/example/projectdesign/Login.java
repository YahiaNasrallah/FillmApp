package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {


    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        MyDataBase myDataBase=new MyDataBase(Login.this);

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,CreateAccount.class);
                startActivity(intent);
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myDataBase.CheckUser(binding.edUsernamelogin.getText().toString(),binding.edUserpasswordloign.getText().toString())) {
                    Toast.makeText(Login.this, "Found", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "Not Found", Toast.LENGTH_SHORT).show();

                }



            }
        });






    }
}