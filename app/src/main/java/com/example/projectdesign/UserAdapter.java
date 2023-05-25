package com.example.projectdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdesign.databinding.RecycleFilmItemBinding;
import com.example.projectdesign.databinding.RecycleUserItemBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<User> userList;


    //استدعاء الinterface
    private ClickHandle clickHandle;

    RecycleUserItemBinding binding;


    public UserAdapter(Context context, ArrayList<User> userList, ClickHandle clickHandle) {
        this.context = context;
        this.userList = userList;
        this.clickHandle=clickHandle;
    }


    //الدالتين لاعطاء الاوامر للعناصر
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RecycleUserItemBinding.inflate(LayoutInflater.from(context),parent,false);
            return new MyviewHolder(binding);
    }

    //الوصول لكل عنصر محدد من الليست
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyviewHolder myviewHolder= (MyviewHolder) holder;

        myviewHolder.binding.tvNameUserItem.setText(userList.get(position).getUserName());
        myviewHolder.binding.tvPasswordUserItem.setText(userList.get(position).getUserPassword());
        myviewHolder.binding.tvPhoneUserItem.setText(userList.get(position).getUserPhone());
        myviewHolder.binding.imageUserItem.setImageBitmap(userList.get(position).getPhoto());

        myviewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickHandle.onItemClick(position);

            }
        });






    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    //ربط التصميم
    public class MyviewHolder extends RecyclerView.ViewHolder{

        RecycleUserItemBinding binding;
        public MyviewHolder(RecycleUserItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



    //اصدار امر عند الضغط على عنصر ولكن من main
    public interface ClickHandle{
        void onItemClick(int position);

    }



}
