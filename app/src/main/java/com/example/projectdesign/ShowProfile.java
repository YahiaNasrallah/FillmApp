package com.example.projectdesign;




import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityShowProfileBinding;
import com.example.projectdesign.databinding.DialgoBinding;

import java.io.IOException;

public class ShowProfile extends AppCompatActivity {

    boolean flag=false;

    Bitmap phtot;
    boolean flagImage=true;
    ActivityShowProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






        MyDataBase myDataBase=new MyDataBase(this);


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.imageUser.setImageBitmap(myDataBase.getUserByName(myDataBase.getTemp()).getPhoto());
        binding.tvUserName.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
        binding.tvNameShow.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
        binding.tvUserPhone.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPhone());

        binding.showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag){
                binding.tvUserPassword.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPassword());
                binding.showHide.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                flag=false;
            } else if (flag==false) {
                    binding.tvUserPassword.setText("*****");
                    binding.showHide.setImageResource(R.drawable.baseline_hide_source_24);
                    flag=true;
                }

            }
        });


        binding.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phtot=myDataBase.getUserByName(myDataBase.getTemp()).getPhoto();


                binding.card1image.setVisibility(View.GONE);
                binding.tvNameShow.setVisibility(View.GONE);
               binding.lin1.setVisibility(View.GONE);
               binding.lin2.setVisibility(View.GONE);
               binding.lin3.setVisibility(View.GONE);

            binding.cardUpdate.setVisibility(View.VISIBLE);
            binding.edUsernameCreate.setVisibility(View.VISIBLE);
            binding.edUserpasswordUpdate.setVisibility(View.VISIBLE);
            binding.edUserRepasswordUpdate.setVisibility(View.VISIBLE);
            binding.edUserphoneUpdate.setVisibility(View.VISIBLE);
            binding.btnUpdateccount.setVisibility(View.VISIBLE);
            binding.edUsernameCreate.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
            binding.edUserphoneUpdate.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPhone());
            binding.edUserpasswordUpdate.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPassword());
            binding.edUserRepasswordUpdate.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPassword());
            binding.imageUserupdate.setImageBitmap(myDataBase.getUserByName(myDataBase.getTemp()).getPhoto());



                binding.btnUpdateccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        User user=new User();

                        String name=binding.edUsernameCreate.getText().toString();
                        String phone=binding.edUserphoneUpdate.getText().toString();
                        String password=binding.edUserpasswordUpdate.getText().toString();
                        Bitmap phot=phtot;




                        user=new User(phot,name,password,phone);

                        if (myDataBase.UpdateUSer(user,myDataBase.getTemp())){
                            myDataBase.UpdateTemp(name);
                            Toast.makeText(ShowProfile.this, "Done", Toast.LENGTH_SHORT).show();

                            binding.card1image.setVisibility(View.VISIBLE);
                            binding.tvNameShow.setVisibility(View.VISIBLE);
                            binding.lin1.setVisibility(View.VISIBLE);
                            binding.lin2.setVisibility(View.VISIBLE);
                            binding.lin3.setVisibility(View.VISIBLE);



                            binding.cardUpdate.setVisibility(View.GONE);
                            binding.edUsernameCreate.setVisibility(View.GONE);
                            binding.edUserpasswordUpdate.setVisibility(View.GONE);
                            binding.edUserRepasswordUpdate.setVisibility(View.GONE);
                            binding.edUserphoneUpdate.setVisibility(View.GONE);
                            binding.btnUpdateccount.setVisibility(View.GONE);




                            binding.imageUser.setImageBitmap(myDataBase.getUserByName(name).getPhoto());
                            binding.tvUserName.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
                            binding.tvNameShow.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserName());
                            binding.tvUserPhone.setText(myDataBase.getUserByName(myDataBase.getTemp()).getUserPhone());
                        }else {
                            Toast.makeText(ShowProfile.this, "NO", Toast.LENGTH_SHORT).show();
                        }






                    }
                });



            }
        });




        ActivityResultLauncher<Intent> lancher2=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent4 =result.getData();
                assert intent4 != null;
                Uri img=intent4.getData();

                try {
                    phtot =  MediaStore.Images.Media.getBitmap(ShowProfile.this.getContentResolver(),img);
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
                binding.imageUserupdate.setImageBitmap(phtot);
                binding.imageUser.setImageBitmap(phtot);

            }
        }); {
        }
        binding.imageUserupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                Toast.makeText(ShowProfile.this, "gg", Toast.LENGTH_SHORT).show();
                Intent intent5=new Intent();
                intent5.setAction(Intent.ACTION_GET_CONTENT);
                intent5.setType("image/*");
                lancher2.launch(intent5);
            }
        });



    }
}