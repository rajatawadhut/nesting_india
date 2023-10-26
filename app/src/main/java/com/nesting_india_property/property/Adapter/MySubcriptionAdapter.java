package com.nesting_india_property.property.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.nesting_india_property.property.Models.MySubscriptionModel;
import com.nesting_india_property.property.R;

import java.util.List;

public class MySubcriptionAdapter extends RecyclerView.Adapter<MySubcriptionAdapter.ShowData> {


    private List<MySubscriptionModel> dataSet;
    private Context context;

    public MySubcriptionAdapter(
            List<MySubscriptionModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_subscription_layout, parent, false);
        return new ShowData(view);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {
        MySubscriptionModel model = dataSet.get(position);
        holder.tv_title.setText(model.getSubscription_title());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tv_description.setText(Html.fromHtml(model.getSubscription_description(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.tv_description.setText(Html.fromHtml(model.getSubscription_description()));
        }
        holder.tv_credit.setText(model.getCredit());
        holder.tv_price.setText(model.getSubscription_price());
        holder.tv_expiry_date.setText(model.getExpiry_date());
        holder.tv_payment_date.setText(model.getPayment_created_at());
        if(model.getPayment_status().equals("0")) {
            holder.tv_payment_status.setText("In Active");
            holder.tv_payment_status.setTextColor(ContextCompat.getColor(context, R.color.red));
            holder.ll_layout.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        }else{
            holder.tv_payment_status.setText("Active");
            holder.tv_payment_status.setTextColor(ContextCompat.getColor(context, R.color.green1));
            holder.ll_layout.setBackgroundColor(ContextCompat.getColor(context, R.color.green1));
        }

        if(position == 0){
            holder.ll_credit.setVisibility(View.VISIBLE);
        }else {
            holder.ll_credit.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        TextView tv_title, tv_description, tv_credit,tv_price, tv_payment_date, tv_expiry_date, tv_payment_status;
        LinearLayout ll_layout, ll_credit;
        public ShowData(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_credit = itemView.findViewById(R.id.tv_credit);
            tv_payment_date = itemView.findViewById(R.id.tv_payment_date);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_expiry_date = itemView.findViewById(R.id.tv_expiry_date);
            tv_payment_status = itemView.findViewById(R.id.tv_payment_status);
            ll_layout = itemView.findViewById(R.id.ll_layout);
            ll_credit = itemView.findViewById(R.id.ll_credit);
        }
    }

}



