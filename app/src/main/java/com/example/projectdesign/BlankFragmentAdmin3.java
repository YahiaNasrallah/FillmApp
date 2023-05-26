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
import androidx.recyclerview.widget.LinearLayoutManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank1Binding;
import com.example.projectdesign.databinding.FragmentBlankAdmin3Binding;

import java.io.IOException;
import java.util.ArrayList;

public class BlankFragmentAdmin3 extends Fragment {


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
  String fimlname;
  String username;
  FragmentBlankAdmin3Binding binding;
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      binding=FragmentBlankAdmin3Binding.inflate(inflater, container, false);

      MyDataBase myDataBase=new MyDataBase(getContext());

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


      binding.btnRecycleUser.setOnClickListener(new View.OnClickListener() {

        ArrayList<String> names=new ArrayList<>();

        @Override
        public void onClick(View v) {

          for (int i = 0; i <myDataBase.getAllUser().size() ; i++) {
            names.add(myDataBase.getAllUser().get(i).getUserName());
          }
          ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,names);
          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          binding.spiner.setAdapter(adapter);



          binding.spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              String value=parent.getItemAtPosition(position).toString();

              binding.linFilms.setVisibility(View.GONE);
              binding.linUsers.setVisibility(View.VISIBLE);
              username=myDataBase.getUserByName(value).getUserName();


              image2=myDataBase.getUserByName(username).getPhoto();


              String name=myDataBase.getUserByName(username).getUserName();
              String phone=myDataBase.getUserByName(username).getUserPhone();
              String password=myDataBase.getUserByName(username).getUserPassword();


              binding.edUsernameCreate.setText(name);
              binding.edUserphoneUpdate.setText(phone);
              binding.edUserpasswordUpdate.setText(password);
              binding.edUserRepasswordUpdate.setText(password);
              binding.imageUserupdate.setImageBitmap(image2);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
          });


        }
      });


      binding.btnUpdateccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          User user=new User();


          String name=binding.edUsernameCreate.getText().toString();
          String phone=binding.edUserphoneUpdate.getText().toString();
          String password=binding.edUserpasswordUpdate.getText().toString();

          user=new User(image2,name,password,phone);

          if (myDataBase.UpdateUSer(user,username)){
            binding.linUsers.setVisibility(View.GONE);
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();

          }




        }
      });



  //----------------------Film----------------------------
    binding.btnRecycleFilm.setOnClickListener(new View.OnClickListener() {

      ArrayList<String> films=new ArrayList<>();



      @Override
      public void onClick(View v) {

        for (int i = 0; i <myDataBase.getAllFilms2().size() ; i++) {
          films.add(myDataBase.getAllFilms2().get(i).getFilmName());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,films);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spiner.setAdapter(adapter);



        binding.spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String value=parent.getItemAtPosition(position).toString();

            binding.linFilms.setVisibility(View.VISIBLE);
            binding.linUsers.setVisibility(View.GONE);
             fimlname=myDataBase.getFilmByName(value).getFilmName();


             bitmap_Actor1=myDataBase.getFilmByName(fimlname).getActor1_photo();
             bitmap_Actor2=myDataBase.getFilmByName(fimlname).getActor2_photo();
             bitmap_Actor3=myDataBase.getFilmByName(fimlname).getActor3_photo();
             bitmap_Actor4=myDataBase.getFilmByName(fimlname).getActor4_photo();
             bitmap_Actor5=myDataBase.getFilmByName(fimlname).getActor5_photo();

             bitmap_photo=myDataBase.getFilmByName(fimlname).getFilm_Photo();
             bitmap_banner=myDataBase.getFilmByName(fimlname).getFilm_Banner();






            String name=myDataBase.getFilmByName(fimlname).getFilmName();
            String id2=myDataBase.getFilmByName(fimlname).getFilmID();
            String hourse=myDataBase.getFilmByName(fimlname).getFilmHoure();
            String castinng=myDataBase.getFilmByName(fimlname).getFilmCast();
            String languge=myDataBase.getFilmByName(fimlname).getFilmLanguge();
            String CreateDate=myDataBase.getFilmByName(fimlname).getFilmCreateDate();
            String Actor1Name=myDataBase.getFilmByName(fimlname).getActor1_name();
            String Actor2Name=myDataBase.getFilmByName(fimlname).getActor2_name();
            String Actor3Name=myDataBase.getFilmByName(fimlname).getActor3_name();
            String Actor4Name=myDataBase.getFilmByName(fimlname).getActor4_name();
            String Actor5Name=myDataBase.getFilmByName(fimlname).getActor5_name();
            String caption=myDataBase.getFilmByName(fimlname).getFilmCaption();
            String dat1=myDataBase.getFilmByName(fimlname).getDate1();
            String dat2=myDataBase.getFilmByName(fimlname).getDate2();
            String dat3=myDataBase.getFilmByName(fimlname).getDate3();
            String dat4=myDataBase.getFilmByName(fimlname).getDate4();
            String dat5=myDataBase.getFilmByName(fimlname).getDate5();
            String time1=myDataBase.getFilmByName(fimlname).getTime1();
            String time2=myDataBase.getFilmByName(fimlname).getTime2();
            String time3=myDataBase.getFilmByName(fimlname).getTime3();
            String price=myDataBase.getFilmByName(fimlname).getFilmPrice();


            binding.edFilmName.setText(name);
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

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });


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


        if (myDataBase.UpdateFilm(filme,fimlname)){
          Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
          binding.linFilms.setVisibility(View.GONE);

        }else {
          Toast.makeText(getContext(), "False", Toast.LENGTH_SHORT).show();
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





    ActivityResultLauncher<Intent> lancher9=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
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
    binding.imageUserupdate.setImageBitmap(image2);
      }
    }); {
    }


    //ينقلك للمعرض وبعدها يستخدم lancher2 ويعرض الصورة
    binding.cardUpdate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent2=new Intent();
        intent2.setAction(Intent.ACTION_GET_CONTENT);
        intent2.setType("image/*");
        lancher9.launch(intent2);
      }
    });





    return binding.getRoot();
    }


}