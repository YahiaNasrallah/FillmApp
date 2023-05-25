package com.example.projectdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.projectdesign.R;
import com.example.projectdesign.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new BlankFragment1());








        binding.bottom.setOnItemSelectedListener(item ->{

            if (item.getItemId()==R.id.item_home){
                replaceFragment(new BlankFragment1());
            } else if (item.getItemId()==R.id.item_love) {
                replaceFragment(new BlankFragment2());
            } else if (item.getItemId()==R.id.item_cart) {
                replaceFragment(new BlankFragment3());
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