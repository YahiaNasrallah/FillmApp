package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivitySeeAllBinding;

public class SeeAllActivity extends AppCompatActivity {

    FilmAdapter adabter;

    ActivitySeeAllBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySeeAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        MyDataBase myDataBase=new MyDataBase(SeeAllActivity.this);




        adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getAllFilms2(), new FilmAdapter.ClickHandle() {


            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(SeeAllActivity.this,DetailsActivity.class);
                intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                startActivity(intent);
            }


        });
        binding.recycleViewSeeAll.setAdapter(adabter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeeAllActivity.this);

        binding.recycleViewSeeAll.setLayoutManager(linearLayoutManager);













    }
}