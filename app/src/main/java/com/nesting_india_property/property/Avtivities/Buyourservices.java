package com.nesting_india_property.property.Avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nesting_india_property.property.Adapter.AdsViewPager;
import com.nesting_india_property.property.Adapter.SubscriptionPlanAdapter;
import com.nesting_india_property.property.Models.AdsDataModel;
import com.nesting_india_property.property.Models.SubscriptionPlanModel;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.Utils.Endpoints;
import com.nesting_india_property.property.Utils.SmsData;
import com.nesting_india_property.property.Utils.StorageSome;
import com.nesting_india_property.property.Utils.VolleySingleton;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyourservices extends AppCompatActivity implements PaymentResultListener, SubscriptionPlanAdapter.SubscriptionListener {


    private ProgressDialog progressDialog;

    RecyclerView recyclerview;
    List<SubscriptionPlanModel> subscriptionList;
    String getsubscription= "";
    String amountValue= "";
    int valueInt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_our_services);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Buy Services");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        subscriptionList = new ArrayList<SubscriptionPlanModel>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        recyclerview = findViewById(R.id.recyclerview);

        if(VolleySingleton.getInstance(getApplicationContext()).isLogin()){
            getsubscription();
        }
        getSubscriptionPlans();

       /* if(VolleySingleton.getInstance(getApplicationContext()).isLogin()){
            startpayment("700");
            valueInt = 4;
            amountValue = "700";
//                    openPaymentUrl();
        }else{
            showmessage("Please login first!!");
            startActivity(new Intent(Buyourservices.this, LoginActivity.class));
            finish();
        }*/




    }

    private void getSubscriptionPlans() {
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getSubscriptionPlans, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response :: " +response);
                progressDialog.dismiss();

                try {
                    JSONObject obj = new JSONObject(response);
                    String succes = obj.getString("success");
                    JSONArray jsonArray = obj.getJSONArray("data");

                    if(succes.equals("1")){

                        for(int i=0; i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String subscription_title = object.getString("subscription_title");
                            String subscription_price = object.getString("subscription_price");
                            String subscription_duration = object.getString("subscription_duration");
                            String subscription_description = object.getString("subscription_description");
                            String subscription_offer = object.getString("subscription_offer");
                            String subscription_type = object.getString("subscription_type");
                            String status = object.getString("status");


                            SubscriptionPlanModel model = new SubscriptionPlanModel(id,subscription_title,subscription_price, subscription_duration, subscription_description, subscription_offer, subscription_type, status);
                            subscriptionList.add(model);
                            SubscriptionPlanAdapter adapter = new SubscriptionPlanAdapter(subscriptionList, Buyourservices.this, Buyourservices.this);
                            recyclerview.setAdapter(adapter);
                        }
                    }

                } catch (JSONException e) {
                    showmessage("Server Error...");
                    System.out.println("problem ::"+e);
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(Buyourservices.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                return params;
            }
        };


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    public void openPaymentUrl() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nestingindia.com/buy-service"));
        startActivity(browserIntent);
    }

    public void startpayment(String value){


        Checkout checkout = new Checkout();
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("name", "Nesting India"); // amount in the smallest currency unit
            orderRequest.put("description", "App Payment"); // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
//            String amountValue = amount.getText().toString().trim();

            double total = Double.parseDouble(value);
            total = total * 100;
            orderRequest.put("theme.color","#008B8B");
            orderRequest.put("amount", total);
            orderRequest.put("image", Endpoints.homeicon);
            orderRequest.put("prefill.email", VolleySingleton.getInstance(getApplicationContext()).email());
            orderRequest.put("prefill.contact",VolleySingleton.getInstance(getApplicationContext()).mobile());

            checkout.open(this, orderRequest);




        }
        catch (Exception e){

        }
    }


    private void getsubscription() {
        final String userid = VolleySingleton.getInstance(getApplicationContext()).id();
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getsubscription, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response :: " +response);
                progressDialog.dismiss();
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.getBoolean("error")){
                        showmessage(obj.getString("message"));
                    }else{
                        String result = obj.getString("subscriptionplan");

                        showmessage(result);

                        StorageSome.getInstance(getApplicationContext()).setsubsription(result);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(Buyourservices.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("userid", userid);
                return params;
            }
        };


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }


    private void showmessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void sendsubscription(String tansId) {

        int getsub = Integer.parseInt(StorageSome.getInstance(getApplicationContext()).getsubsription());
        int a = getsub + valueInt;

        getsubscription = String.valueOf(a);

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.sendsubscription, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response ::::: "+ response);
                progressDialog.dismiss();
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.getBoolean("error")){
                        showmessage(obj.getString("message"));
                    }else{
                        getsubscription();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Buyourservices.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("userid", VolleySingleton.getInstance(getApplicationContext()).id());
                params.put("subscription", getsubscription);

                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(Buyourservices.this).addToRequestQueue(stringRequest);


    }



    private void sendPaymentDetail(String transId, String amount) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.payment_detail, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response ::::: "+ response);
                try {
                    JSONObject obj = new JSONObject(response);
                    progressDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Buyourservices.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("userid", VolleySingleton.getInstance(getApplicationContext()).id());
                params.put("amount", amount);
                params.put("transactionid", transId);
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_TIMEOUT_MS));
        VolleySingleton.getInstance(Buyourservices.this).addToRequestQueue(stringRequest);

    }


    @Override
    public void onPaymentSuccess(String s) {
        sendsubscription(s);
        sendPaymentDetail(s, amountValue);
        Toast.makeText(this,"Payment Successful", Toast.LENGTH_LONG).show();
        Log.v("Payment Failed", s);

    }

    @Override
    public void onPaymentError(int i, String s) {
        Log.v("Payment Failed", i +"   "+ s);

        Toast.makeText(this, "Payment Failed!!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSelectSubscription(SubscriptionPlanModel model) {
        startpayment(model.getSubscription_price());
    }
}

