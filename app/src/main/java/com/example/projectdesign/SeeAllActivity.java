package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

        binding.edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.SearchAllFilmsByName(binding.edSearch.getText().toString()), new FilmAdapter.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {

                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent=new Intent(SeeAllActivity.this,DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }
                });
                binding.recycleViewSeeAll.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeeAllActivity.this);

                binding.recycleViewSeeAll.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        adabter = new FilmAdapter(SeeAllActivity.this, myDataBase.getAllFilms2(), new FilmAdapter.ClickHandle() {


            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onEditClick(int position) {
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