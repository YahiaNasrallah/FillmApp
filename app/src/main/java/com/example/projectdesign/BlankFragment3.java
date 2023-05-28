package com.example.projectdesign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank3Binding;


public class BlankFragment3 extends Fragment {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    FragmentBlank3Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBlank3Binding.inflate(inflater,container,false);

        preferences= getContext().getSharedPreferences("MyPrefe", Context.MODE_PRIVATE);
        editor=preferences.edit();


        MyDataBase myDataBase=new MyDataBase(getContext());

        binding.imageUser.setImageBitmap(myDataBase.getUserByName(myDataBase.getTemp()).getPhoto());
        binding.tvNameUser.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());

        binding.editProfileUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ShowProfile.class);
                startActivity(intent);
            }
        });


    binding.logOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editor.clear();
            editor.commit();
            Intent intent=new Intent(getContext(),Login.class);
            startActivity(intent);
        }
    });





        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        MyDataBase myDataBase=new MyDataBase(getContext());
        binding.imageUser.setImageBitmap(myDataBase.getUserByName(myDataBase.getTemp()).getPhoto());
        binding.tvNameUser.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
    }
}