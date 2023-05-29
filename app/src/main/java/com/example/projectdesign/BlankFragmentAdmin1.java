package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectdesign.databinding.FragmentBlankAdmin1Binding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class BlankFragmentAdmin1 extends Fragment  {

    FilmAdapter adabter;

    RecyclerView recyclerView;
    UserAdapter adabter2;


    CoordinatorLayout coordinatorLayout;
    boolean flag=false;
    boolean flagButton=false;

    ArrayList<User> TempDeletedUser;
    ArrayList<Filme> TempDeletedFilm;

    FragmentBlankAdmin1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlankAdmin1Binding.inflate( inflater, container, false);
        recyclerView=binding.filmsList;
        MyDataBase myDataBase=new MyDataBase(getContext());

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


                        }

                        @Override
                        public void onEditClick(int position) {
                            Intent intent=new Intent(getContext(), EditData.class);
                            intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                            intent.putExtra("type","film");
                            startActivity(intent);
                        }
                    });
                    new ItemTouchHelper(itemTouchHelperCallbackFilm).attachToRecyclerView(binding.filmsList);
                    binding.filmsList.setAdapter(adabter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                    binding.filmsList.setLayoutManager(linearLayoutManager);

                }else {
                    adabter2 = new UserAdapter(getContext(), myDataBase.SearchAllUsersByName(binding.edSearch.getText().toString()), new UserAdapter.ClickHandle() {
                        @Override
                        public void onItemClick(int position) {
                            flag=true;


                        }

                        @Override
                        public void onEditClick(int position) {
                            Intent intent=new Intent(getContext(), EditData.class);
                            intent.putExtra("name",myDataBase.getAllUser().get(position).getUserName());
                            intent.putExtra("type","user");
                            startActivity(intent);
                        }
                    });





                    new ItemTouchHelper(itemTouchHelperCallbackUser).attachToRecyclerView(binding.filmsList);
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


                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent=new Intent(getContext(), EditData.class);
                        intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                        intent.putExtra("type","film");
                        startActivity(intent);
                    }
                });
                new ItemTouchHelper(itemTouchHelperCallbackFilm).attachToRecyclerView(binding.filmsList);
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

                        flag = false;

                    }

                    @Override
                    public void onEditClick(int position) {
                        Intent intent = new Intent(getContext(), EditData.class);
                        intent.putExtra("name", myDataBase.getAllUser().get(position).getUserName());
                        intent.putExtra("type", "user");
                        startActivity(intent);
                    }

                });
                new ItemTouchHelper(itemTouchHelperCallbackUser).attachToRecyclerView(binding.filmsList);
                binding.filmsList.setAdapter(adabter2);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                binding.filmsList.setLayoutManager(linearLayoutManager);





            }
        });




        return binding.getRoot();
    }



    ItemTouchHelper.SimpleCallback itemTouchHelperCallbackUser= new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {


                    return false;
                }



        @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    MyDataBase myDataBase=new MyDataBase(getContext());
                    TempDeletedUser=new ArrayList<>();
                    final  int postin=viewHolder.getLayoutPosition();

                    String name=myDataBase.getAllUser().get(postin).getUserName();


                    User user=myDataBase.getUserByName(myDataBase.getAllUser().get(postin).getUserName());



                    TempDeletedUser.add(user);
                    myDataBase.deleteUser(myDataBase.getAllUser().get(postin).getUserName());
                    adabter2.notifyItemInserted(postin);




            Snackbar.make(binding.layMain,"User Deleted",Snackbar.LENGTH_LONG)
                                .setTextColor(Color.WHITE)
                                .setBackgroundTint(getResources().getColor(R.color.color))
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        myDataBase.AddUser(TempDeletedUser.get(0));

                                        adabter2 = new UserAdapter(getContext(), myDataBase.getAllUser(), new UserAdapter.ClickHandle() {
                                            @Override
                                            public void onItemClick(int position) {

                                                flag = false;

                                            }

                                            @Override
                                            public void onEditClick(int position) {
                                                Intent intent = new Intent(getContext(), EditData.class);
                                                intent.putExtra("name", myDataBase.getAllUser().get(position).getUserName());
                                                intent.putExtra("type", "user");
                                                startActivity(intent);
                                            }

                                        });

                                        new ItemTouchHelper(itemTouchHelperCallbackUser).attachToRecyclerView(binding.filmsList);
                                        binding.filmsList.setAdapter(adabter2);
                                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                                        binding.filmsList.setLayoutManager(linearLayoutManager);



                                    }

                                })
                                .setActionTextColor(Color.WHITE)
                                .show();






                     adabter2 = new UserAdapter(getContext(), myDataBase.getAllUser(), new UserAdapter.ClickHandle() {
                                        @Override
                                        public void onItemClick(int position) {

                                            flag = false;

                                        }

                                        @Override
                                        public void onEditClick(int position) {
                                            Intent intent = new Intent(getContext(), EditData.class);
                                            intent.putExtra("name", myDataBase.getAllUser().get(position).getUserName());
                                            intent.putExtra("type", "user");
                                            startActivity(intent);
                                        }

                                    });

                    new ItemTouchHelper(itemTouchHelperCallbackUser).attachToRecyclerView(binding.filmsList);
                    binding.filmsList.setAdapter(adabter2);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                    binding.filmsList.setLayoutManager(linearLayoutManager);




                }
        public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(getContext(),R.color.color))
                    .addSwipeLeftActionIcon(R.drawable.baseline_delete_forever_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(getContext(),R.color.color))
                    .addSwipeRightActionIcon( R.drawable.baseline_delete_forever_24)

                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
            };


    ItemTouchHelper.SimpleCallback itemTouchHelperCallbackFilm= new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {


                    return false;
                }

                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    MyDataBase myDataBase=new MyDataBase(getContext());
                    TempDeletedFilm=new ArrayList<>();
                    final  int postin=viewHolder.getLayoutPosition();
                    String name=myDataBase.getAllFilms2().get(postin).getFilmName();


                    Filme filme=myDataBase.getFilmByName(myDataBase.getAllFilms2().get(postin).getFilmName());



                    TempDeletedFilm.add(filme);

                    TempDeletedFilm.add(filme);
                    myDataBase.deleteFilm(myDataBase.getAllFilms2().get(postin).getFilmName());
                    adabter.notifyItemInserted(postin);




                    Snackbar.make(binding.layMain,"Film Deleted",Snackbar.LENGTH_LONG)
                            .setTextColor(Color.WHITE)
                            .setBackgroundTint(getResources().getColor(R.color.color))
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    myDataBase.AddFilm(TempDeletedFilm.get(0));

                                    adabter = new FilmAdapter(getContext(), myDataBase.SearchAllFilmsByName(binding.edSearch.getText().toString()), new FilmAdapter.ClickHandle() {
                                        @Override
                                        public void onItemClick(int position) {
                                            flag=true;


                                        }

                                        @Override
                                        public void onEditClick(int position) {
                                            Intent intent=new Intent(getContext(), EditData.class);
                                            intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                                            intent.putExtra("type","film");
                                            startActivity(intent);
                                        }
                                    });
                                    new ItemTouchHelper(itemTouchHelperCallbackFilm).attachToRecyclerView(binding.filmsList);
                                    binding.filmsList.setAdapter(adabter);
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                                    binding.filmsList.setLayoutManager(linearLayoutManager);



                                }

                            })
                            .setActionTextColor(Color.WHITE)
                            .show();








                    adabter = new FilmAdapter(getContext(), myDataBase.SearchAllFilmsByName(binding.edSearch.getText().toString()), new FilmAdapter.ClickHandle() {
                        @Override
                        public void onItemClick(int position) {
                            flag=true;


                        }

                        @Override
                        public void onEditClick(int position) {
                            Intent intent=new Intent(getContext(), EditData.class);
                            intent.putExtra("name",myDataBase.getAllFilms2().get(position).getFilmName());
                            intent.putExtra("type","film");
                            startActivity(intent);
                        }
                    });
                    new ItemTouchHelper(itemTouchHelperCallbackFilm).attachToRecyclerView(binding.filmsList);
                    binding.filmsList.setAdapter(adabter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                    binding.filmsList.setLayoutManager(linearLayoutManager);




                }
        public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(getContext(),R.color.color))
                    .addSwipeLeftActionIcon(R.drawable.baseline_delete_forever_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(getContext(),R.color.color))
                    .addSwipeRightActionIcon( R.drawable.baseline_delete_forever_24)

                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
            };




