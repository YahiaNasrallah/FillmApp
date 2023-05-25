package com.example.projectdesign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlankAdmin1Binding;

import java.util.ArrayList;

public class BlankFragmentAdmin1 extends Fragment {

    FilmAdapter adabter;
    UserAdapter adabter2;

    FragmentBlankAdmin1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentBlankAdmin1Binding.inflate(inflater, container, false);











        MyDataBase myDataBase=new MyDataBase(getContext());


        binding.btnRecycleFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnRecycleFilm.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnRecycleFilm.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.btnRecycleUser.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRecycleUser.setTextColor(getResources().getColorStateList(R.color.color));

                adabter = new FilmAdapter(getContext(), myDataBase.getAllFilms2(), new FilmAdapter.ClickHandle() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getContext(), "HI", Toast.LENGTH_SHORT).show();
                    }

                });
                binding.filmsList.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                binding.filmsList.setLayoutManager(linearLayoutManager);




            }
        });


        binding.btnRecycleUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnRecycleUser.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnRecycleUser.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.btnRecycleFilm.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRecycleFilm.setTextColor(getResources().getColorStateList(R.color.color));
                adabter2 = new UserAdapter(getContext(), myDataBase.getAllUser(), new UserAdapter.ClickHandle() {
                    @Override
                    public void onItemClick(int position) {

                    }
                });
                        binding.filmsList.setAdapter(adabter2);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                binding.filmsList.setLayoutManager(linearLayoutManager);





            }
        });









        return binding.getRoot();
    }
}