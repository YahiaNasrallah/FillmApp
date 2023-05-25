package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank1Binding;

public class BlankFragment1 extends Fragment {

    Intent intent;

    String type;

    FragmentBlank1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         binding =FragmentBlank1Binding.inflate(inflater, container, false);

      binding.go.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getContext(),DetailsActivity.class);
               startActivity(intent);
           }
       });


MyDataBase myDataBase=new MyDataBase(getContext());


            String banerFilm1="Yahia";
            String banerFilm2="Yahia";
            String banerFilm3="Yahia";


        binding.imag1.setImageBitmap(myDataBase.getFilmByName(banerFilm1).getFilm_Banner());
        binding.imag2.setImageBitmap(myDataBase.getFilmByName(banerFilm2).getFilm_Banner());
        binding.imag3.setImageBitmap(myDataBase.getFilmByName(banerFilm3).getFilm_Banner());






            binding.tvFilm1.setText(myDataBase.getFilmByName("Yahia").getFilmName());
            binding.imagefilm1.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());

        binding.tvfilm2.setText(myDataBase.getFilmByName("Yahia").getFilmName());
        binding.imagefilm2.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());


        binding.tvfilm3.setText(myDataBase.getFilmByName("Yahia").getFilmName());
        binding.imagefilm3.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());

        binding.tvfilm4.setText(myDataBase.getFilmByName("Yahia").getFilmName());
        binding.imagefilm4.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());

        binding.tvfilm4.setText(myDataBase.getFilmByName("Yahia").getFilmName());
        binding.imagefilm4.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());

        binding.tvfilm5.setText(myDataBase.getFilmByName("Yahia").getFilmName());
        binding.imagefilm5.setImageBitmap(myDataBase.getFilmByName("Yahia").getFilm_Photo());



        binding.btnAction.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Action";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnAction.setTextColor(getResources().getColor(R.color.Wihte));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.color));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.color));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.color));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.color));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));

                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);




            }
        });

        binding.btnRomantic.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Romantic";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAction.setTextColor(getResources().getColor(R.color.color));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.Wihte));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.color));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.color));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.color));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));

                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);
            }
        });

        binding.btnDrama.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Drama";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAction.setTextColor(getResources().getColor(R.color.color));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.color));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.Wihte));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.color));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.color));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));
                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);

            }
        });

        binding.btnComedy.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Comedy";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAction.setTextColor(getResources().getColor(R.color.color));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.color));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.color));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.Wihte));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.color));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));

                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);
            }
        });

        binding.btnAdventure.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Adventure";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAction.setTextColor(getResources().getColor(R.color.color));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.color));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.color));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.color));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.Wihte));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));

                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);
            }
        });

        binding.btnHorror.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Horror";


                binding.btnAction.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAction.setTextColor(getResources().getColor(R.color.color));



                binding.btnRomantic.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRomantic.setTextColor(getResources().getColor(R.color.color));

                binding.btnDrama.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnDrama.setTextColor(getResources().getColor(R.color.color));

                binding.btnComedy.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnComedy.setTextColor(getResources().getColor(R.color.color));

                binding.btnAdventure.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAdventure.setTextColor(getResources().getColor(R.color.color));

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.Wihte));

                Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                intent1.putExtra("type",type);
                startActivity(intent1);
            }
        });




        binding.tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(),SeeAllActivity.class);
                    startActivity(intent);
                    Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                    intent1.putExtra("type","All");
                    startActivity(intent1);
                }
            });

        binding.Film1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     intent=new Intent(getContext(),DetailsActivity.class);

                    intent.putExtra("name",binding.tvFilm1.getText().toString());


                    startActivity(intent);
                }
            });

        binding.Film2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",binding.tvfilm2.getText().toString());


                startActivity(intent);
            }
        });

        binding.Film3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",binding.tvfilm3.getText().toString());


                startActivity(intent);
            }
        });

        binding.Film4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",binding.tvfilm4.getText().toString());


                startActivity(intent);
            }
        });

        binding.Film5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",binding.tvfilm5.getText().toString());


                startActivity(intent);
            }
        });
        binding.imag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",banerFilm1);


                startActivity(intent);
            }
        });
        binding.imag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",banerFilm2);


                startActivity(intent);
            }
        });
        binding.imag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getContext(),DetailsActivity.class);

                intent.putExtra("name",banerFilm3);


                startActivity(intent);
            }
        });







        return binding.getRoot();
    }
}