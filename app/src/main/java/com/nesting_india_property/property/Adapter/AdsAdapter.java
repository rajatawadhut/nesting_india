package com.nesting_india_property.property.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nesting_india_property.property.Avtivities.ShowAdsActivity;
import com.nesting_india_property.property.Models.AdsDataModel;
import com.nesting_india_property.property.R;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ShowData>{



    private List<AdsDataModel> dataSet;
    private Context context;



    public AdsAdapter(
            List<AdsDataModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adsmorelayout, parent, false);
        return new ShowData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {


        Glide.with(context).load(dataSet.get(position).getImage()).into(holder.adsimage);

        holder.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dataSet.get(position).getUrl().equals("#")){
                    Intent intent = new Intent(context, ShowAdsActivity.class);
                    intent.putExtra("url", dataSet.get(position).getUrl());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });


        System.out.println("datasetposition" + dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        
        ImageView adsimage;
        CardView cardImage;

        public ShowData(@NonNull View itemView) {
            super(itemView);

            adsimage = itemView.findViewById(R.id.adsimage);
            cardImage = itemView.findViewById(R.id.cardImage);

        }
    }

}



