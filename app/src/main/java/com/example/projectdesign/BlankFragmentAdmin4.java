package com.example.projectdesign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlankAdmin4Binding;

import java.io.IOException;

public class BlankFragmentAdmin4 extends Fragment {
    Bitmap image2;

    FragmentBlankAdmin4Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentBlankAdmin4Binding.inflate(inflater,container,false);


        MyDataBase myDataBase=new MyDataBase(getContext());





        binding.btnCreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();

                String name=binding.edUsernameCreate.getText().toString();
                String phone=binding.edUserphoneCreate.getText().toString();
                String password=binding.edUserpasswordCreate.getText().toString();
                Bitmap i=image2;

                user=new User(image2,name,password,phone);


                if (myDataBase.AddUser(user)){

                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                    binding.edUsernameCreate.getText().clear();
                    binding.edUserpasswordCreate.getText().clear();
                    binding.edUserphoneCreate.getText().clear();
                    binding.imageUserCreate.setImageBitmap(null);

                }else {
                    Toast.makeText(getContext(), "NO", Toast.LENGTH_SHORT).show();

                }

            }







        });




        ActivityResultLauncher<Intent> lancher2=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent =result.getData();
                assert intent != null;
                Uri img=intent.getData();


                try {
                    image2 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),img);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.imageUserCreate.setImageBitmap(image2);
            }
        }); {
        }


        //ينقلك للمعرض وبعدها يستخدم lancher2 ويعرض الصورة
        binding.imageUserCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher2.launch(intent2);
            }
        });











        return binding.getRoot();
    }
}