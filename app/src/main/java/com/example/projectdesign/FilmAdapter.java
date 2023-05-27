package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projectdesign.databinding.RecycleFilmItemBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Filme> filmlist;

    
    //استدعاء الinterface 
    private ClickHandle clickHandle;

    RecycleFilmItemBinding binding;


    public FilmAdapter(Context context, ArrayList<Filme> gamelist, ClickHandle clickHandle) {
        this.context = context;
        this.filmlist = gamelist;
        this.clickHandle=clickHandle;
    }


    //الدالتين لاعطاء الاوامر للعناصر
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RecycleFilmItemBinding.inflate(LayoutInflater.from(context),parent,false);
            return new MyviewHolder(binding);
    }

    //الوصول لكل عنصر محدد من الليست
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyviewHolder myviewHolder= (MyviewHolder) holder;

        myviewHolder.binding.tvFilmnameItem.setText(filmlist.get(position).getFilmName());
        myviewHolder.binding.tvFilmIdItem.setText(filmlist.get(position).getFilmID());
        myviewHolder.binding.tvFilmCastingItem.setText(filmlist.get(position).getFilmCast());
        myviewHolder.binding.tvFilmHouersItem.setText(filmlist.get(position).getFilmHoure());
        myviewHolder.binding.tvTypeItem.setText(filmlist.get(position).getFilmType());
        myviewHolder.binding.tvLangugeItem.setText(filmlist.get(position).getFilmLanguge());
        myviewHolder.binding.imageViewItem.setImageBitmap(filmlist.get(position).getFilm_Photo());

        myviewHolder.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickHandle.onItemClick(position);
                return false;
            }
        });
        myviewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandle.onEditClick(position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return filmlist.size();
    }


    //ربط التصميم
    public class MyviewHolder extends RecyclerView.ViewHolder{

        RecycleFilmItemBinding binding;
        public MyviewHolder(RecycleFilmItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



    //اصدار امر عند الضغط على عنصر ولكن من main
    public interface ClickHandle{
        void onItemClick(int position);
        void onEditClick(int position);

    }



}
