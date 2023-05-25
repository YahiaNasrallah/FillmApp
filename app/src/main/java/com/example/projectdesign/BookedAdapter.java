package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdesign.databinding.BookedItemBinding;

import java.util.ArrayList;

public class BookedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private ArrayList<Booked> bookedlist;



    BookedItemBinding binding;
    //استدعاء الinterface
    private ClickHandle clickHandle;




    public BookedAdapter(Context context, ArrayList<Booked> bookedlist, ClickHandle clickHandle) {
        this.context = context;
        this.bookedlist = bookedlist;
        this.clickHandle=clickHandle;
    }


    //الدالتين لاعطاء الاوامر للعناصر
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=BookedItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyviewHolder(binding);
    }

    //الوصول لكل عنصر محدد من الليست
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyviewHolder myviewHolder= (MyviewHolder) holder;

        myviewHolder.binding.FilmName.setText(bookedlist.get(position).getFilm_Name());
        myviewHolder.binding.FilmCast.setText(bookedlist.get(position).getFilm_Cast());
        myviewHolder.binding.FilmDate.setText(bookedlist.get(position).getFilm_Date());
        myviewHolder.binding.FilmTime.setText(bookedlist.get(position).getFilm_Time());
        myviewHolder.binding.chairss.setText(bookedlist.get(position).getReserved_Chair1()+
                ","+bookedlist.get(position).getReserved_Chair2());
        myviewHolder.binding.ChirsNum.setText(bookedlist.get(position).getNumber_Chairs());
        myviewHolder.binding.image.setImageBitmap(bookedlist.get(position).getFilm_Photo());

        myviewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickHandle.onItemClick(position);

            }
        });

        myviewHolder.binding.btnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandle.onDetailsClick(position);
            }
        });





    }

    @Override
    public int getItemCount() {
        return bookedlist.size();
    }


    //ربط التصميم
    public class MyviewHolder extends RecyclerView.ViewHolder{

        BookedItemBinding binding;
        public MyviewHolder(BookedItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



    //اصدار امر عند الضغط على عنصر ولكن من main
    public interface ClickHandle{
        void onItemClick(int position);
        void onDetailsClick(int position);

    }








}
