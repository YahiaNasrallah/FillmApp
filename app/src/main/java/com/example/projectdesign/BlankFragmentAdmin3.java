package com.example.projectdesign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank1Binding;
import com.example.projectdesign.databinding.FragmentBlankAdmin3Binding;

import java.util.ArrayList;

public class BlankFragmentAdmin3 extends Fragment {

  FragmentBlankAdmin3Binding binding;
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      binding=FragmentBlankAdmin3Binding.inflate(inflater, container, false);














    return binding.getRoot();
    }
}