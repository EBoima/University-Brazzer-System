package com.example.ubsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyExchangeAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
    private final Context context;
    private final int[] images;
    private final String[] placeNames;
    private final String[] placeGuide;

    public MyExchangeAdapter(ExchangeActivity exchangeActivity, int[] images, String[] placeNames, String[] placeGuide) {
        this.context = exchangeActivity;
        this.images = images;
        this.placeNames = placeNames;
        this.placeGuide = placeGuide;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row_item, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        holder.placeName.setText(placeNames[position]);
        holder.place.setImageResource(images[position]);
        holder.share.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "Checkout the new event "
                    + placeNames[holder.getAbsoluteAdapterPosition()] +
                    "\nHere is the link with full info: " + placeGuide[holder.getAbsoluteAdapterPosition()]);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser(intent, "Send To"));
        });
        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(placeGuide[holder.getBindingAdapterPosition()]));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder {

    ImageView place;
    TextView placeName;
    Button share;
    Button visit;

    public PlaceViewHolder(View itemView) {
        super(itemView);

        place = itemView.findViewById(R.id.ivPlace);
        placeName = itemView.findViewById(R.id.tvPlaceName);
        share = itemView.findViewById(R.id.btnShare);
        visit = itemView.findViewById(R.id.btnVisit);
    }
}