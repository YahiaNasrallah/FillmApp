package com.example.projectdesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank2Binding;
import com.example.projectdesign.databinding.FragmentBlankAdmin2Binding;


public class BlankFragment2 extends Fragment {


    BookedAdapter adabter;

    FragmentBlank2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentBlank2Binding.inflate(inflater,container,false);






        MyDataBase myDataBase=new MyDataBase(getContext());




        adabter = new BookedAdapter(getContext(), myDataBase.getBookedByAccount(myDataBase.getTemp()), new BookedAdapter.ClickHandle() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDetailsClick(int position) {
                Intent intent=new Intent(getContext(),PaymentActivity.class);
                intent.putExtra("id",myDataBase.getAllBooked().get(position).getFilm_ID());
                startActivity(intent);


            }
        });
                binding.recycle2.setAdapter(adabter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        binding.recycle2.setLayoutManager(linearLayoutManager);






        return binding.getRoot();
    }
}