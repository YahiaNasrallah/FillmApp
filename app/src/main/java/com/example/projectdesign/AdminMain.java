package com.example.projectdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityAdminMainBinding;

public class AdminMain extends AppCompatActivity {


    ActivityAdminMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new BlankFragmentAdmin1());


        binding.bottom.setOnItemSelectedListener(item ->{

            if (item.getItemId()==R.id.item_biew){
                replaceFragment(new BlankFragmentAdmin1());
            } else if (item.getItemId()==R.id.item_add) {
                replaceFragment(new BlankFragmentAdmin2());
            } else if (item.getItemId()==R.id.item_edit) {
                replaceFragment(new BlankFragmentAdmin3());
            }


            return true;
        });




    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }

}