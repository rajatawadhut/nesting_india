package com.nesting_india_property.property.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nesting_india_property.property.Models.MyPurchaseEnquiryModel;
import com.nesting_india_property.property.Models.MyPurchaseEnquiryModel;
import com.nesting_india_property.property.R;

import java.util.List;

public class MyPurchaseEnquiryAdapter extends RecyclerView.Adapter<MyPurchaseEnquiryAdapter.ShowData> {


    private List<MyPurchaseEnquiryModel> dataSet;
    private Context context;

    public MyPurchaseEnquiryAdapter(
            List<MyPurchaseEnquiryModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_purchase_enquiry_layout, parent, false);
        return new ShowData(view);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ShowData holder, final int position) {
        MyPurchaseEnquiryModel model = dataSet.get(position);
        holder.tv_property_type.setText(model.getType());
        holder.tv_city.setText(model.getCity());
        holder.tv_locality.setText(model.getLocality());
        holder.tv_state.setText(model.getState());
        holder.tv_propertyfor.setText(model.getPropertylistfor());
        holder.tv_price.setText(model.getMinprice() + " - " + model.getMaxprice());
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ShowData extends RecyclerView.ViewHolder {
        TextView tv_property_type, tv_city, tv_state, tv_price, tv_locality, tv_propertyfor;
        public ShowData(@NonNull View itemView) {
            super(itemView);
            tv_property_type = itemView.findViewById(R.id.tv_property_type);
            tv_state = itemView.findViewById(R.id.tv_state);
            tv_city = itemView.findViewById(R.id.tv_city);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_locality = itemView.findViewById(R.id.tv_locality);
            tv_propertyfor = itemView.findViewById(R.id.tv_propertyfor);


        }
    }

}



