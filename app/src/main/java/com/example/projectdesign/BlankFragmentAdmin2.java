package com.example.projectdesign;

import static android.content.ContentValues.TAG;

import static java.io.File.createTempFile;

import android.annotation.SuppressLint;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank2Binding;
import com.example.projectdesign.databinding.FragmentBlankAdmin2Binding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class BlankFragmentAdmin2 extends Fragment {



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




    FragmentBlankAdmin2Binding binding;

    @SuppressLint("WrongThread")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding=FragmentBlankAdmin2Binding.inflate(inflater,container,false);



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
        binding.rbHorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rg1.clearCheck();

            }
        });




        binding.btnFilmSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyDataBase myDataBase=new MyDataBase(getContext());
                Filme filme=new Filme();
                String type="";

                if (binding.rbComedy.isChecked()){
                    type=binding.rbComedy.getText().toString();
                }else  if (binding.rbRomantic.isChecked()){
                    type=binding.rbRomantic.getText().toString();
                }else  if (binding.rbHorror.isChecked()){
                    type=binding.rbHorror.getText().toString();
                }else  if (binding.rbDrama.isChecked()){
                    type=binding.rbDrama.getText().toString();
                }else  if (binding.rbAction.isChecked()){
                    type=binding.rbAction.getText().toString();
                }else  if (binding.rbAdventure.isChecked()){
                    type=binding.rbAdventure.getText().toString();
                }



                String name=binding.edFilmName.getText().toString();
                String id=binding.edFilmID.getText().toString();
                String hourse=binding.edFilmDuration.getText().toString();
                String castinng=binding.edFilmCast.getText().toString();
                String languge=binding.edFilmLanguge.getText().toString();
                String CreateDate=binding.edFilmCreateDate.getText().toString();
                String Actor1Name=binding.edActor1Name.getText().toString();
                String Actor2Name=binding.edActor2Name.getText().toString();
                String Actor3Name=binding.edActor3Name.getText().toString();
                String Actor4Name=binding.edActor4Name.getText().toString();
                String Actor5Name=binding.edActor5Name.getText().toString();
                String caption=binding.edFilmCaption.getText().toString();
                String dat1=binding.edDate1.getText().toString();
                String dat2=binding.edDate2.getText().toString();
                String dat3=binding.edDate3.getText().toString();
                String dat4=binding.edDate4.getText().toString();
                String dat5=binding.edDate5.getText().toString();
                String time1=binding.edTime1.getText().toString();
                String time2=binding.edTime2.getText().toString();
                String time3=binding.edTime3.getText().toString();
                String price=binding.edFilmPrice.getText().toString();



                filme=new Filme(name,id,hourse,type,languge,CreateDate,castinng,Actor1Name,
                        Actor2Name,Actor3Name,Actor4Name,Actor5Name,caption,dat1,dat2,dat3,dat4,dat5,time1,
                        time2,time3,price,bitmap_photo,bitmap_banner,bitmap_Actor1,bitmap_Actor2,bitmap_Actor3,
                        bitmap_Actor4,bitmap_Actor5);







                if (myDataBase.AddFilm(filme)){
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();

                    binding.edFilmName.getText().clear();
                    binding.edFilmID.getText().clear();
                    binding.edFilmDuration.getText().clear();
                    binding.edFilmCast.getText().clear();
                    binding.edFilmCreateDate.getText().clear();
                    binding.edFilmCaption.getText().clear();
                    binding.edFilmPrice.getText().clear();
                    binding.edFilmLanguge.getText().clear();
                    binding.edTime1.getText().clear();
                    binding.edTime2.getText().clear();
                    binding.edTime3.getText().clear();
                    binding.edDate1.getText().clear();
                    binding.edDate2.getText().clear();
                    binding.edDate3.getText().clear();
                    binding.edDate4.getText().clear();
                    binding.edDate5.getText().clear();
                    binding.edActor1Name.getText().clear();
                    binding.edActor2Name.getText().clear();
                    binding.edActor3Name.getText().clear();
                    binding.edActor4Name.getText().clear();
                    binding.edActor5Name.getText().clear();

                    binding.edActor1Photo.setClickable(true);
                    binding.edActor1Photo.setText("Uplode Photo");

                    binding.edActor2Photo.setClickable(true);
                    binding.edActor3Photo.setText("Uplode Photo");

                    binding.edActor3Photo.setClickable(true);
                    binding.edActor3Photo.setText("Uplode Photo");

                    binding.edActor4Photo.setClickable(true);
                    binding.edActor4Photo.setText("Uplode Photo");

                    binding.edActor5Photo.setClickable(true);
                    binding.edActor5Photo.setText("Uplode Photo");

                    binding.btnFilmPhoto.setClickable(true);
                    binding.btnFilmPhoto.setText("Uplode Photo");

                    binding.btnFilmBAnner.setClickable(true);
                    binding.btnFilmBAnner.setText("Uplode Photo");

                    binding.rg1.clearCheck();
                    binding.rg2.clearCheck();









                }else {
                    Toast.makeText(getContext(), "Nope", Toast.LENGTH_SHORT).show();
                }





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
                    bitmap_Actor1 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Actor1Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


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
                binding.edActor1Photo.setText("Selected");
                binding.edActor1Photo.setClickable(false);
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
                    bitmap_Actor2 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Actor2Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
                binding.edActor2Photo.setText("Selected");
                binding.edActor2Photo.setClickable(false);
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
                    bitmap_Actor3 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Actor3Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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
                binding.edActor3Photo.setText("Selected");
                binding.edActor3Photo.setClickable(false);
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
                    bitmap_Actor4 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Actor4Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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
                binding.edActor4Photo.setText("Selected");
                binding.edActor4Photo.setClickable(false);
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
                    bitmap_Actor5 =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Actor5Photo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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
                binding.edActor5Photo.setText("Selected");
                binding.edActor5Photo.setClickable(false);
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
                   bitmap_photo =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),filmPhoto);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


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
                binding.btnFilmPhoto.setText("Selected");
                binding.btnFilmPhoto.setClickable(false);
            }
        });


        ActivityResultLauncher<Intent> lancherbanner = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                assert intent != null;
                filmBanner = intent.getData();


                try {
                    bitmap_banner =  MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),filmBanner);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
                binding.btnFilmBAnner.setText("Selected");
                binding.btnFilmBAnner.setClickable(false);
            }
        });

















        return binding.getRoot();
    }
}
/*


 */


















