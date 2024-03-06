package com.example.ubsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MySearchAdapter extends RecyclerView.Adapter<MySearchAdapter.ViewHolder> {

    Users[] myUserData;
    Context context;

    public MySearchAdapter(Users[] myUserData, SearchActivity activity) {
        this.myUserData = myUserData;
        this.context = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_view_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Users myUsersDataList = myUserData[position];
        holder.searchText.setText(myUsersDataList.getName());
        holder.detailText.setText(myUsersDataList.getDetails());
        holder.searchImage.setImageResource(myUsersDataList.getImage());

        holder.itemView.setOnClickListener(view -> Toast.makeText(context, myUsersDataList.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return myUserData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView searchImage;
        TextView searchText;
        TextView detailText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            searchImage = itemView.findViewById(R.id.imageView);
            searchText = itemView.findViewById(R.id.textView);
            detailText = itemView.findViewById(R.id.text_details);
        }
    }
}

