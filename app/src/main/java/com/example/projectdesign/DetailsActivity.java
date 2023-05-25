package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import com.example.projectdesign.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {


    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDataBase myDataBase=new MyDataBase(DetailsActivity.this);

        Intent intent1=getIntent();
        String idName=intent1.getStringExtra("name");
        binding.banner.setImageBitmap(myDataBase.getFilmByName(idName).getFilm_Banner());
        binding.tvFilmName.setText(myDataBase.getFilmByName(idName).getFilmName());
        binding.tvFilmHourse.setText(myDataBase.getFilmByName(idName).getFilmHoure());
        binding.tvFilmType.setText(myDataBase.getFilmByName(idName).getFilmType());
        binding.tvFilmCreatedate.setText(myDataBase.getFilmByName(idName).getFilmCreateDate());
        binding.tvFilmCaption.setText(myDataBase.getFilmByName(idName).getFilmCaption());

        binding.NameActor1.setText(myDataBase.getFilmByName(idName).getActor1_name());
        binding.NameActor2.setText(myDataBase.getFilmByName(idName).getActor2_name());
        binding.NameActor3.setText(myDataBase.getFilmByName(idName).getActor3_name());
        binding.NameActor4.setText(myDataBase.getFilmByName(idName).getActor4_name());
        binding.NameActor5.setText(myDataBase.getFilmByName(idName).getActor5_name());

        binding.imageActor1.setImageBitmap(myDataBase.getFilmByName(idName).getActor1_photo());
        binding.imageActor2.setImageBitmap(myDataBase.getFilmByName(idName).getActor2_photo());
        binding.imageActor3.setImageBitmap(myDataBase.getFilmByName(idName).getActor3_photo());
        binding.imageActor4.setImageBitmap(myDataBase.getFilmByName(idName).getActor4_photo());
        binding.imageActor5.setImageBitmap(myDataBase.getFilmByName(idName).getActor5_photo());






        binding.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this,DateActivity.class);
                intent.putExtra("name",idName);
                startActivity(intent);
                finish();
            }
        });







    }
}