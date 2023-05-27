package com.example.projectdesign;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.projectdesign.databinding.ActivityEditDataBinding;

import java.io.IOException;

public class EditData extends AppCompatActivity {

    Uri filmPhoto;
    Uri filmBanner;
    Uri Actor1Photo;
    Uri Actor2Photo;
    Uri Actor3Photo;
    Uri Actor4Photo;
    Uri Actor5Photo;

    Bitmap bitmap_photo;
    Bitmap bitmap_banner;
    Bitmap bitmap_Actor1;
    Bitmap bitmap_Actor2;
    Bitmap bitmap_Actor3;
    Bitmap bitmap_Actor4;
    Bitmap bitmap_Actor5;
    Bitmap image2;
    ActivityEditDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        MyDataBase myDataBase=new MyDataBase(this);
        String name=intent.getStringExtra("name");
        String type=intent.getStringExtra("type");






        binding.rbAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();
            }
        });
        binding.rbRomantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();

            }
        });
        binding.rbDrama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg2.clearCheck();

            }
        });
        binding.rbComedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg1.clearCheck();

            }
        });
        binding.rbAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg1.clearCheck();

            }
        });






        if (type.equals("user")){
            binding.linUsers.setVisibility(View.VISIBLE);



            image2=myDataBase.getUserByName(name).getPhoto();
            String name2=myDataBase.getUserByName(name).getUserName();
            String phone=myDataBase.getUserByName(name).getUserPhone();
            String password=myDataBase.getUserByName(name).getUserPassword();


            binding.edUsernameCreate.setText(name2);
            binding.edUserphoneUpdate.setText(phone);
            binding.edUserpasswordUpdate.setText(password);
            binding.edUserRepasswordUpdate.setText(password);
            binding.imageUserupdate.setImageBitmap(image2);








        } else if (type.equals("film")) {
                binding.linFilms.setVisibility(View.VISIBLE);

            if (myDataBase.getFilmByName(name).getFilmType().equals("Action")){
                binding.rbAction.setChecked(true);
            }else  if (myDataBase.getFilmByName(name).getFilmType().equals("Romantic")){
                binding.rbRomantic.setChecked(true);
            }else  if (myDataBase.getFilmByName(name).getFilmType().equals("Drama")){
                binding.rbDrama.setChecked(true);
            }else  if (myDataBase.getFilmByName(name).getFilmType().equals("Comedy")){
                binding.rbComedy.setChecked(true);
            }else  if (myDataBase.getFilmByName(name).getFilmType().equals("Adventure")){
                binding.rbAdventure.setChecked(true);
            }else  if (myDataBase.getFilmByName(name).getFilmType().equals("Horror")){
                binding.rbHorror.setChecked(true);
            }

            bitmap_Actor1=myDataBase.getFilmByName(name).getActor1_photo();
            bitmap_Actor2=myDataBase.getFilmByName(name).getActor2_photo();
            bitmap_Actor3=myDataBase.getFilmByName(name).getActor3_photo();
            bitmap_Actor4=myDataBase.getFilmByName(name).getActor4_photo();
            bitmap_Actor5=myDataBase.getFilmByName(name).getActor5_photo();
            bitmap_photo=myDataBase.getFilmByName(name).getFilm_Photo();
            bitmap_banner=myDataBase.getFilmByName(name).getFilm_Banner();

            binding.edActor1Photo.setImageBitmap(bitmap_Actor1);
            binding.edActor2Photo.setImageBitmap(bitmap_Actor2);
            binding.edActor3Photo.setImageBitmap(bitmap_Actor3);
            binding.edActor4Photo.setImageBitmap(bitmap_Actor4);
            binding.edActor5Photo.setImageBitmap(bitmap_Actor5);
            binding.btnFilmPhoto.setImageBitmap(bitmap_photo);
            binding.btnFilmBAnner.setImageBitmap(bitmap_banner);


            String name5=myDataBase.getFilmByName(name).getFilmName();
            String id2=myDataBase.getFilmByName(name).getFilmID();
            String hourse=myDataBase.getFilmByName(name).getFilmHoure();
            String castinng=myDataBase.getFilmByName(name).getFilmCast();
            String languge=myDataBase.getFilmByName(name).getFilmLanguge();
            String CreateDate=myDataBase.getFilmByName(name).getFilmCreateDate();
            String Actor1Name=myDataBase.getFilmByName(name).getActor1_name();
            String Actor2Name=myDataBase.getFilmByName(name).getActor2_name();
            String Actor3Name=myDataBase.getFilmByName(name).getActor3_name();
            String Actor4Name=myDataBase.getFilmByName(name).getActor4_name();
            String Actor5Name=myDataBase.getFilmByName(name).getActor5_name();
            String caption=myDataBase.getFilmByName(name).getFilmCaption();
            String dat1=myDataBase.getFilmByName(name).getDate1();
            String dat2=myDataBase.getFilmByName(name).getDate2();
            String dat3=myDataBase.getFilmByName(name).getDate3();
            String dat4=myDataBase.getFilmByName(name).getDate4();
            String dat5=myDataBase.getFilmByName(name).getDate5();
            String time1=myDataBase.getFilmByName(name).getTime1();
            String time2=myDataBase.getFilmByName(name).getTime2();
            String time3=myDataBase.getFilmByName(name).getTime3();
            String price=myDataBase.getFilmByName(name).getFilmPrice();


            binding.edFilmName.setText(name5);
            binding.edFilmID.setText(id2);
            binding.edFilmDuration.setText(hourse);
            binding.edFilmCast.setText(castinng);
            binding.edFilmLanguge.setText(languge);
            binding.edFilmCreateDate.setText(CreateDate);
            binding.edActor1Name.setText(Actor1Name);
            binding.edActor2Name.setText(Actor2Name);
            binding.edActor3Name.setText(Actor3Name);
            binding.edActor4Name.setText(Actor4Name);
            binding.edActor5Name.setText(Actor5Name);
            binding.edFilmCaption.setText(caption);
            binding.edDate1.setText(dat1);
            binding.edDate2.setText(dat2);
            binding.edDate3.setText(dat3);
            binding.edDate4.setText(dat4);
            binding.edDate5.setText(dat5);
            binding.edTime1.setText(time1);
            binding.edTime2.setText(time2);
            binding.edTime3.setText(time3);
            binding.edFilmPrice.setText(price);



        }











        binding.btnUpdateccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user=new User();


                String name3=binding.edUsernameCreate.getText().toString();
                String phone=binding.edUserphoneUpdate.getText().toString();
                String password=binding.edUserpasswordUpdate.getText().toString();

                user=new User(image2,name3,password,phone);

                if (myDataBase.UpdateUSer(user,name)){
                    binding.linUsers.setVisibility(View.GONE);
                    Toast.makeText(EditData.this, "Done", Toast.LENGTH_SHORT).show();

                }

                finish();



            }
        });







        binding.btnFilmSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Filme filme=new Filme();
                String typeg="";

                if (binding.rbComedy.isChecked()){
                    typeg=binding.rbComedy.getText().toString();
                }else  if (binding.rbRomantic.isChecked()){
                    typeg=binding.rbRomantic.getText().toString();
                }else  if (binding.rbHorror.isChecked()){
                    typeg=binding.rbHorror.getText().toString();
                }else  if (binding.rbDrama.isChecked()){
                    typeg=binding.rbDrama.getText().toString();
                }else  if (binding.rbAction.isChecked()){
                    typeg=binding.rbAction.getText().toString();
                }else  if (binding.rbAdventure.isChecked()){
                    typeg=binding.rbAdventure.getText().toString();
                }



                String nameg=binding.edFilmName.getText().toString();
                String id2g=binding.edFilmID.getText().toString();
                String hourseg=binding.edFilmDuration.getText().toString();
                String castinngg=binding.edFilmCast.getText().toString();
                String langugeg=binding.edFilmLanguge.getText().toString();
                String CreateDateg=binding.edFilmCreateDate.getText().toString();
                String Actor1Nameg=binding.edActor1Name.getText().toString();
                String Actor2Nameg=binding.edActor2Name.getText().toString();
                String Actor3Nameg=binding.edActor3Name.getText().toString();
                String Actor4Nameg=binding.edActor4Name.getText().toString();
                String Actor5Nameg=binding.edActor5Name.getText().toString();
                String captiong=binding.edFilmCaption.getText().toString();
                String dat1g=binding.edDate1.getText().toString();
                String dat2g=binding.edDate2.getText().toString();
                String dat3g=binding.edDate3.getText().toString();
                String dat4g=binding.edDate4.getText().toString();
                String dat5g=binding.edDate5.getText().toString();
                String time1g=binding.edTime1.getText().toString();
                String time2g=binding.edTime2.getText().toString();
                String time3g=binding.edTime3.getText().toString();
                String priceg=binding.edFilmPrice.getText().toString();



                filme=new Filme(nameg,id2g,hourseg,typeg,langugeg,CreateDateg,castinngg,Actor1Nameg,
                        Actor2Nameg,Actor3Nameg,Actor4Nameg,Actor5Nameg,captiong,dat1g,dat2g,dat3g,dat4g,dat5g,time1g,
                        time2g,time3g,priceg,bitmap_photo,bitmap_banner,bitmap_Actor1,bitmap_Actor2,bitmap_Actor3,
                        bitmap_Actor4,bitmap_Actor5);


                if (myDataBase.UpdateFilm(filme,name)){
                    Toast.makeText(EditData.this, "Success", Toast.LENGTH_SHORT).show();
                    binding.linFilms.setVisibility(View.GONE);

                }else {
                    Toast.makeText(EditData.this, "False", Toast.LENGTH_SHORT).show();
                }



    finish();

            }
        });





        //-------------------------------------------------------------------------



        ActivityResultLauncher<Intent> lancher9=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent =result.getData();
                assert intent != null;
                Uri img=intent.getData();


                try {
                    image2 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),img);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.imageUserupdate.setImageBitmap(image2);
            }
        }); {
        }
        binding.cardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher9.launch(intent2);

            }
        });






        //1--------------------------------------------------------------------------------------
        ActivityResultLauncher<Intent> lancher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                Actor1Photo= intent.getData();

                try {
                    bitmap_Actor1 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),Actor1Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                binding.edActor1Photo.setImageBitmap(bitmap_Actor1);
            }
        });
        {
        }
        binding.edActor1Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher1.launch(intent2);

            }
        });
        //--------------------------------------------------------------------------------------


        //2--------------------------------------------------------------------------------------
        ActivityResultLauncher<Intent> lancher2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                Actor2Photo = intent.getData();


                try {
                    bitmap_Actor2 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),Actor2Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.edActor2Photo.setImageBitmap(bitmap_Actor2);
            }
        });
        {
        }
        binding.edActor2Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher2.launch(intent2);


            }
        });
        //--------------------------------------------------------------------------------------


        //3--------------------------------------------------------------------------------------
        ActivityResultLauncher<Intent> lancher3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                Actor3Photo= intent.getData();

                try {
                    bitmap_Actor3 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),Actor3Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.edActor3Photo.setImageBitmap(bitmap_Actor3);
            }
        });
        {
        }
        binding.edActor3Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher3.launch(intent2);


            }
        });
        //--------------------------------------------------------------------------------------


        //4--------------------------------------------------------------------------------------
        ActivityResultLauncher<Intent> lancher4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                Actor4Photo= intent.getData();

                try {
                    bitmap_Actor4 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),Actor4Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.edActor4Photo.setImageBitmap(bitmap_Actor4);
            }
        });
        {
        }
        binding.edActor4Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher4.launch(intent2);


            }
        });
        //--------------------------------------------------------------------------------------


        //5--------------------------------------------------------------------------------------
        ActivityResultLauncher<Intent> lancher5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                Actor5Photo = intent.getData();


                try {
                    bitmap_Actor5 =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),Actor5Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.edActor5Photo.setImageBitmap(bitmap_Actor5);
            }
        });
        {
        }
        binding.edActor5Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancher5.launch(intent2);


            }
        });
        //--------------------------------------------------------------------------------------


        ActivityResultLauncher<Intent> lancherphoto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                filmPhoto = intent.getData();

                try {
                    bitmap_photo =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),filmPhoto);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.btnFilmPhoto.setImageBitmap(bitmap_photo);

            }
        });
        {
        }
        binding.btnFilmPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancherphoto.launch(intent2);


            }
        });


        ActivityResultLauncher<Intent> lancherbanner = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                filmBanner = intent.getData();


                try {
                    bitmap_banner =  MediaStore.Images.Media.getBitmap(EditData.this.getContentResolver(),filmBanner);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.btnFilmBAnner.setImageBitmap(bitmap_banner);
            }
        });
        {
        }
        binding.btnFilmBAnner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                lancherbanner.launch(intent2);


            }
        });


    }
}