package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdesign.databinding.DesignBannerBinding;
import com.example.projectdesign.databinding.RecycleFilmItem2Binding;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Filme> filmlist;


    //استدعاء الinterface
    private ClickHandle clickHandle;

    DesignBannerBinding binding;


    public BannerAdapter(Context context, ArrayList<Filme> gamelist, ClickHandle clickHandle) {
        this.context = context;
        this.filmlist = gamelist;
        this.clickHandle=clickHandle;
    }


    //الدالتين لاعطاء الاوامر للعناصر
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=DesignBannerBinding.inflate(LayoutInflater.from(context),parent,false);
            return new MyviewHolder(binding);
    }

    //الوصول لكل عنصر محدد من الليست
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyviewHolder myviewHolder= (MyviewHolder) holder;


        myviewHolder.binding.imagBanner.setImageBitmap(filmlist.get(position).getFilm_Banner());

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

        DesignBannerBinding binding;
        public MyviewHolder(DesignBannerBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



    //اصدار امر عند الضغط على عنصر ولكن من main
    public interface ClickHandle{
        void onItemClick(int position);

    }



}
