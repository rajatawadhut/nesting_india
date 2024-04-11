package com.nesting_india_property.property.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nesting_india_property.property.Models.SubscriptionPlanModel;
import com.nesting_india_property.property.R;

import java.util.List;

public class SubscriptionPlanAdapter extends RecyclerView.Adapter<SubscriptionPlanAdapter.ShowData> {

    SubscriptionListener listener;
    public interface SubscriptionListener {
        void onSelectSubscription(SubscriptionPlanModel model);
    }
    private List<SubscriptionPlanModel> dataSet;
    private Context context;

    public SubscriptionPlanAdapter(
            List<SubscriptionPlanModel> dataSet, Context context, SubscriptionListener listener) {
        this.dataSet = dataSet;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_plan_layout, parent, false);
        return new ShowData(view);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {
        SubscriptionPlanModel model = dataSet.get(position);
        holder.subscription_title.setText(model.getSubscription_title());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.subscription_description.setText(Html.fromHtml(model.getSubscription_description(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.subscription_description.setText(Html.fromHtml(model.getSubscription_description()));
        }
        holder.subscription_offer.setText("Launching Offer " + model.getSubscription_offer() + " % off");
        holder.orignal_subscription_price.setText(model.getSubscription_price());
        holder.orignal_subscription_price.setPaintFlags(holder.orignal_subscription_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        int price = Integer.parseInt(model.getSubscription_price());
        int percentage = Integer.parseInt(model.getSubscription_offer());
        int valuePrice = (price - ((price * percentage) /100));
        holder.subscription_price.setText( "\u20B9 "+ valuePrice + " for " + model.getSubscription_duration() + " days");

        holder.btn_buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setOriginalPrice(String.valueOf(valuePrice));
                listener.onSelectSubscription(model);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        TextView subscription_title, subscription_price, subscription_description, subscription_offer, orignal_subscription_price;

        Button btn_buy_now;

        public ShowData(@NonNull View itemView) {
            super(itemView);
            subscription_title = itemView.findViewById(R.id.tv_title);
            subscription_description = itemView.findViewById(R.id.tv_description);
            subscription_offer = itemView.findViewById(R.id.tv_offer);
            subscription_price = itemView.findViewById(R.id.tv_price);
            orignal_subscription_price = itemView.findViewById(R.id.tv_original_price);
            btn_buy_now = itemView.findViewById(R.id.btn_buy_now);


        }
    }

}



