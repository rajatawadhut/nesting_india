package com.nesting_india_property.property.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nesting_india_property.property.Models.LeadDataModel;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.listener.OnLeadClickListener;

import java.util.List;

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.ShowData>{

    private List<LeadDataModel> dataSet;
    private Context context;

    OnLeadClickListener listener;


    public LeadAdapter(
            List<LeadDataModel> dataSet, Context context, OnLeadClickListener listener) {
        this.dataSet = dataSet;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leadsearch, parent, false);
        return new ShowData(view);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {


        holder.fullname.setText(dataSet.get(position).getFullname());
        holder.email.setText(dataSet.get(position).getEmail());
        holder.mobile.setText(dataSet.get(position).getMobile());
        holder.city.setText(dataSet.get(position).getCity()+", "+ dataSet.get(position).getLocality());
        holder.date.setText(dataSet.get(position).getDate());
        holder.property.setText(dataSet.get(position).getType()+", "+dataSet.get(position).getCategory());


        String propertylength = dataSet.get(position).getType()+", "+dataSet.get(position).getCategory();
        if(propertylength.length() > 4){
            holder.propertylayout.setVisibility(View.VISIBLE);
        }else{
            holder.propertylayout.setVisibility(View.GONE);
        }




        if(dataSet.get(position).getLeadStatus().equals("0")){
            String mobile, firstFourChars;

            mobile = dataSet.get(position).getMobile();
            firstFourChars = mobile.substring(0, 3);

            for (int i =0; i< 7; i++){
                firstFourChars = firstFourChars + "*";
            }
            holder.mobile.setText(firstFourChars);

            String email, firstFourChars1;

            email = dataSet.get(position).getEmail();
            firstFourChars1 = email.substring(0, 3);

            for (int i =0; i< 7; i++){
                firstFourChars1 = firstFourChars1 + "*";
            }
            holder.email.setText(firstFourChars1);
            holder.call_button.setVisibility(View.GONE);
            holder.showCall.setVisibility(View.VISIBLE);
        }else{
            holder.call_button.setVisibility(View.VISIBLE);
            holder.showCall.setVisibility(View.GONE);
        }



        holder.call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = dataSet.get(position).getMobile();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                context.startActivity(intent);


            }
        });
        holder.showCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickLead(dataSet.get(position));
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        TextView fullname, email, mobile, city, property, date, showCall;
        LinearLayout namelayout, emaillayout, mobilelayout, citylayout, propertylayout, datelayout;

        ImageView call_button;

        public ShowData(@NonNull View itemView) {
            super(itemView);


            fullname = itemView.findViewById(R.id.fullname);
            email = itemView.findViewById(R.id.email);
            mobile = itemView.findViewById(R.id.mobile);
            city = itemView.findViewById(R.id.city);
            property = itemView.findViewById(R.id.property);
            namelayout = itemView.findViewById(R.id.namelayout);
            emaillayout = itemView.findViewById(R.id.emaillayout);
            mobilelayout = itemView.findViewById(R.id.mobilelayout);
            citylayout = itemView.findViewById(R.id.citylayout);
            propertylayout = itemView.findViewById(R.id.propertylayout);
            call_button = itemView.findViewById(R.id.call_button);
            datelayout = itemView.findViewById(R.id.datelayout);
            date = itemView.findViewById(R.id.date);
            showCall = itemView.findViewById(R.id.showCall);



        }
    }

}



