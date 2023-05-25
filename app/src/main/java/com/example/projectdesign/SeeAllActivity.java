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
        Intent intent=getIntent();
        String condetion=intent.getStringExtra("type");

        if (condetion.equals("All")){
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

        } else if (condetion.equals("Action")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Action"), new FilmAdapter.ClickHandle() {


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

        }else if (condetion.equals("Romantic")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Romantic"), new FilmAdapter.ClickHandle() {


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

        }else if (condetion.equals("Drama")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Drama"), new FilmAdapter.ClickHandle() {


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

        }else if (condetion.equals("Comedy")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Comedy"), new FilmAdapter.ClickHandle() {


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

        }else if (condetion.equals("Adventure")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Adventure"), new FilmAdapter.ClickHandle() {


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

        }else if (condetion.equals("Horror")) {
            adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getFilmByType("Horror"), new FilmAdapter.ClickHandle() {


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
}