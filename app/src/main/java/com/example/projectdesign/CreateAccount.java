package com.example.projectdesign;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityCreateAccountBinding;

import java.io.IOException;

public class CreateAccount extends AppCompatActivity {



    Bitmap image2;

    ActivityCreateAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyDataBase myDataBase=new MyDataBase(CreateAccount.this);





        binding.btnCreeateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();

                String name=binding.edUsernameCreate.getText().toString();
                String phone=binding.edUsernameCreate.getText().toString();
                String password=binding.edUsernameCreate.getText().toString();
                Bitmap i=image2;

                user=new User(i,name,password,phone);


                    if (myDataBase.AddUser(user)){

                        Toast.makeText(CreateAccount.this, "Done", Toast.LENGTH_SHORT).show();
                        binding.edUsernameCreate.getText().clear();
                        binding.edUserpasswordCreate.getText().clear();
                        binding.edUserphoneCreate.getText().clear();
                        binding.imageUser.setImageBitmap(null);

                    }else {
                        Toast.makeText(CreateAccount.this, "NO", Toast.LENGTH_SHORT).show();

                    }

                }







        });




        ActivityResultLauncher<Intent> lancher2=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent =result.getData();
                Uri img=intent.getData();


                try {
                    image2 =  MediaStore.Images.Media.getBitmap(CreateAccount.this.getContentResolver(),img);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }); {
        }


        //ينقلك للمعرض وبعدها يستخدم lancher2 ويعرض الصورة
        binding.imageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher2.launch(intent2);
            }
        });






    }
}