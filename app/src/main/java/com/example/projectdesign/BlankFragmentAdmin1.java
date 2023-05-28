package com.example.projectdesign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlankAdmin1Binding;

import java.util.ArrayList;

public class BlankFragmentAdmin1 extends Fragment {

    FilmAdapter adabter;
    UserAdapter adabter2;

    boolean flag=false;
    boolean flagButton=false;

    int postion;

    FragmentBlankAdmin1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlankAdmin1Binding.inflate(inflater, container, false);
        MyDataBase myDataBase=new MyDataBase(getContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Warning");
        builder.setMessage("Sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (flag){

                    myDataBase.deleteFilm(myDataBase.getAllFilms2().get(postion).getFilmName());

                }else {
                    myDataBase.deleteUser(myDataBase.getAllUser().get(postion).getUserName());

                }

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);




        binding.edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!flagButton){
                    adabter = new FilmAdapter(getContext(), myDataBase.SearchAllFilmsByName(binding.edSearch.getText().toString()), new FilmAdapter.ClickHandle() {
                        @Override
                        public void onItemClick(int position) {
                            flag=true;

                            dialog.show();
                        }

                        @Override
                        public void onEditClick(int position) {
                            Intent intent=new Intent(getContext(), EditData.class);
                            intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                            intent.putExtra("type","film");
                            startActivity(intent);
                        }
                    });
                    binding.filmsList.setAdapter(adabter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                    binding.filmsList.setLayoutManager(linearLayoutManager);

                }else {
                    adabter2 = new UserAdapter(getContext(), myDataBase.SearchAllUsersByName(binding.edSearch.getText().toString()), new UserAdapter.ClickHandle() {
                        @Override
                        public void onItemClick(int position) {
                            flag=false;
                            dialog.show();
                        }
                        @Override
                        public void onEditClick(int position) {
                            Intent intent=new Intent(getContext(), EditData.class);
                            intent.putExtra("name",myDataBase.getAllUser().get(position).getUserName());
                            intent.putExtra("type","user");
                            startActivity(intent);
                        }
                    });
                    binding.filmsList.setAdapter(adabter2);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                    binding.filmsList.setLayoutManager(linearLayoutManager);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });









        binding.btnRecycleFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagButton=false;
                binding.btnRecycleUser.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRecycleUser.setTextColor(getResources().getColorStateList(R.color.color));

                binding.btnRecycleFilm.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnRecycleFilm.setTextColor(getResources().getColorStateList(R.color.Wihte));

                adabter = new FilmAdapter(getContext(), myDataBase.getAllFilms2(), new FilmAdapter.ClickHandle() {
                    @Override
                    public void onItemClick(int position) {
                        flag=true;

                        dialog.show();
                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent=new Intent(getContext(), EditData.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        intent.putExtra("type","film");
                        startActivity(intent);
                    }
                });
                binding.filmsList.setAdapter(adabter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                binding.filmsList.setLayoutManager(linearLayoutManager);




            }
        });


        binding.btnRecycleUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagButton=true;
                binding.btnRecycleUser.setBackgroundTintList(getResources().getColorStateList(R.color.color));
                binding.btnRecycleUser.setTextColor(getResources().getColorStateList(R.color.Wihte));

                binding.btnRecycleFilm.setBackgroundTintList(getResources().getColorStateList(R.color.dark));
                binding.btnRecycleFilm.setTextColor(getResources().getColorStateList(R.color.color));
                adabter2 = new UserAdapter(getContext(), myDataBase.getAllUser(), new UserAdapter.ClickHandle() {
                    @Override
                    public void onItemClick(int position) {
                    flag=false;
                        dialog.show();
                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent=new Intent(getContext(), EditData.class);
                        intent.putExtra("name",myDataBase.getAllUser().get(position).getUserName());
                        intent.putExtra("type","user");
                        startActivity(intent);
                    }
                });
                        binding.filmsList.setAdapter(adabter2);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                binding.filmsList.setLayoutManager(linearLayoutManager);





            }
        });




        return binding.getRoot();
    }

}