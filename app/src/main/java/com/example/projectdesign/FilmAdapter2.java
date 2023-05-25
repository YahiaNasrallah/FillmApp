package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdesign.databinding.RecycleFilmItem2Binding;
import com.example.projectdesign.databinding.RecycleFilmItemBinding;

import java.util.ArrayList;

public class FilmAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Filme> filmlist;


    //استدعاء الinterface
    private ClickHandle clickHandle;

    RecycleFilmItem2Binding binding;


    public FilmAdapter2(Context context, ArrayList<Filme> gamelist, ClickHandle clickHandle) {
        this.context = context;
        this.filmlist = gamelist;
        this.clickHandle=clickHandle;
    }


    //الدالتين لاعطاء الاوامر للعناصر
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RecycleFilmItem2Binding.inflate(LayoutInflater.from(context),parent,false);
            return new MyviewHolder(binding);
    }

    //الوصول لكل عنصر محدد من الليست
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyviewHolder myviewHolder= (MyviewHolder) holder;

        myviewHolder.binding.tvFilmnameItem.setText(filmlist.get(position).getFilmName());

        myviewHolder.binding.imagefilmItem.setImageBitmap(filmlist.get(position).getFilm_Photo());

        myviewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickHandle.onItemClick(position);

            }
        });






    }

    @Override
    public int getItemCount() {
        return filmlist.size();
    }


    //ربط التصميم
    public class MyviewHolder extends RecyclerView.ViewHolder{

        RecycleFilmItem2Binding binding;
        public MyviewHolder(RecycleFilmItem2Binding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



    //اصدار امر عند الضغط على عنصر ولكن من main
    public interface ClickHandle{
        void onItemClick(int position);

    }



}
