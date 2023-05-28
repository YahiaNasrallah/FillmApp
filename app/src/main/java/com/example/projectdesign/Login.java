package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences=getSharedPreferences("MyPrefe",MODE_PRIVATE);
        editor=preferences.edit();


        MyDataBase myDataBase=new MyDataBase(Login.this);

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,CreateAccount.class);
                startActivity(intent);
            }
        });


        if (preferences.contains("savedName")){
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }else {


        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (binding.edUsernamelogin.getText().toString().equals("a")&&binding.edUserpasswordloign.getText().toString().equals("a")){



                    Intent intent=new Intent(Login.this,AdminMain.class);

                    startActivity(intent);



                }else {


                    if (myDataBase.CheckUser(binding.edUsernamelogin.getText().toString(),binding.edUserpasswordloign.getText().toString())) {



                        if (myDataBase.getTemp().equals("")){
                            myDataBase.AddTemp(binding.edUsernamelogin.getText().toString());
                        }else{
                            myDataBase.UpdateTemp(binding.edUsernamelogin.getText().toString());
                        }



                        Toast.makeText(Login.this, "Found", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,MainActivity.class);
                        binding.edUsernamelogin.getText().clear();
                        binding.edUserpasswordloign.getText().clear();
                        startActivity(intent);



                    }else

                        if (myDataBase.CheckUserName(binding.edUsernamelogin.getText().toString())) {
                            binding.edUserpasswordloign.setError("Error Password");
                            binding.edUserpasswordloign.requestFocus();

                        }else {

                            binding.edUsernamelogin.setError("User Not Found");
                            binding.edUsernamelogin.requestFocus();

                    }



                }




            }
        });



        }




    }
}