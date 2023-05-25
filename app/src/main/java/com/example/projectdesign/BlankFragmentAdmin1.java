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

    FragmentBlankAdmin1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentBlankAdmin1Binding.inflate(inflater, container, false);











        MyDataBase myDataBase=new MyDataBase(getContext());




        adabter = new FilmAdapter(getContext(), myDataBase.getAllFilms2(), new FilmAdapter.ClickHandle() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "HI", Toast.LENGTH_SHORT).show();
            }

        });
        binding.filmsList.setAdapter(adabter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        binding.filmsList.setLayoutManager(linearLayoutManager);










        return binding.getRoot();
    }
}