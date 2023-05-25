package com.example.projectdesign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectdesign.databinding.FragmentBlank3Binding;


public class BlankFragment3 extends Fragment {

    FragmentBlank3Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBlank3Binding.inflate(inflater,container,false);










        return binding.getRoot();
    }
}