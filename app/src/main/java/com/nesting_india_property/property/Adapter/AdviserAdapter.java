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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nesting_india_property.property.Avtivities.ChannelAdvisePartnerActivity;
import com.nesting_india_property.property.Avtivities.MainActivity;
import com.nesting_india_property.property.Avtivities.ShowUSerList;
import com.nesting_india_property.property.Models.UserDataModel;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.Utils.Endpoints;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdviserAdapter extends RecyclerView.Adapter<AdviserAdapter.ShowData>{

    private List<UserDataModel> dataSet;
    private Context context;

    public AdviserAdapter(
            List<UserDataModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(context instanceof MainActivity) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adviserdata_home, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adviserdata, parent, false);
        }
        return new ShowData(view);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {


        Glide.with(context)
                .load(Endpoints.base_url + dataSet.get(position).getProfilepic())
                .apply(RequestOptions
                        .placeholderOf(R.drawable.personq)
                        .dontAnimate()
                        .error(R.drawable.personq))
                .into(holder.image);


        holder.fullname.setText(dataSet.get(position).getFname() + " " +dataSet.get(position).getLname() );
        holder.email.setText(dataSet.get(position).getEmail());
        holder.mobile.setText(dataSet.get(position).getMobile());
        holder.city.setText(dataSet.get(position).getCity());
        holder.state.setText(dataSet.get(position).getState());

        String userType = "";

       if (dataSet.get(position).getUsercategory().equals("1")) {
           userType =  "Owner";
        } else if (dataSet.get(position).getUsercategory().equals("2")) {
           userType = "Dealer";
        } else if (dataSet.get(position).getUsercategory().equals("3")) {
           userType = "Builder";
        }else if (dataSet.get(position).getUsercategory().equals("4")) {
           userType = "Buyer";
        }else {
           userType = "Unknown";
       }
        if(context instanceof ChannelAdvisePartnerActivity) {
            holder.tv_usertype.setText(userType);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        TextView fullname, email, mobile, city, state, tv_usertype;
        CircleImageView image;


        public ShowData(@NonNull View itemView) {
            super(itemView);


            fullname = itemView.findViewById(R.id.fullname);
            email = itemView.findViewById(R.id.tv_email);
            mobile = itemView.findViewById(R.id.tv_mobile);
            city = itemView.findViewById(R.id.tv_city);
            state = itemView.findViewById(R.id.tv_state);
            image = itemView.findViewById(R.id.image);
            tv_usertype = itemView.findViewById(R.id.tv_usertype);

        }
    }

}



