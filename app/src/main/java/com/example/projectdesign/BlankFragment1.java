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
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlank1Binding;

public class BlankFragment1 extends Fragment {

    Intent intent;

    FilmAdapter2 adabter;

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


        adabter = new FilmAdapter2(getContext(), myDataBase.getAllFilms2(), new FilmAdapter2.ClickHandle() {


            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getContext(),DetailsActivity.class);
                intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                startActivity(intent);
            }


        });
        binding.recycleitemfilm.setAdapter(adabter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        binding.recycleitemfilm.setLayoutManager(linearLayoutManager);








            String banerFilm1="Yahia";
            String banerFilm2="Yahia";
            String banerFilm3="Yahia";


        binding.imag1.setImageBitmap(myDataBase.getFilmByName(banerFilm1).getFilm_Banner());
        binding.imag2.setImageBitmap(myDataBase.getFilmByName(banerFilm2).getFilm_Banner());
        binding.imag3.setImageBitmap(myDataBase.getFilmByName(banerFilm3).getFilm_Banner());


        binding.btnAction.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Action";

                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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



                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);




            }
        });



        binding.btnAll.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="All";

                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnAll.setTextColor(getResources().getColor(R.color.Wihte));

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

                binding.btnHorror.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnHorror.setTextColor(getResources().getColor(R.color.color));


                adabter = new FilmAdapter2(getContext(), myDataBase.getAllFilms2(), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);



            }
        });

        binding.btnRomantic.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Romantic";


                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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



                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);



            }
        });

        binding.btnDrama.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Drama";


                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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


                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);





            }
        });

        binding.btnComedy.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Comedy";


                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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



                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);



            }
        });

        binding.btnAdventure.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Adventure";



                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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

                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);




            }
        });

        binding.btnHorror.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onClick(View v) {

                type="Horror";


                binding.btnAll.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnAll.setTextColor(getResources().getColor(R.color.color));

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


                adabter = new FilmAdapter2(getContext(), myDataBase.getFilmByType(type), new FilmAdapter2.ClickHandle() {


                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        startActivity(intent);
                    }


                });
                binding.recycleitemfilm.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

                binding.recycleitemfilm.setLayoutManager(linearLayoutManager);




            }
        });




        binding.tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent1=new Intent(getContext(),SeeAllActivity.class);
                    startActivity(intent1);
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