package com.nesting_india_property.property.Avtivities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nesting_india_property.property.Adapter.MyPurchaseEnquiryAdapter;
import com.nesting_india_property.property.Adapter.MySubcriptionAdapter;
import com.nesting_india_property.property.Models.MyPurchaseEnquiryModel;
import com.nesting_india_property.property.Models.MySubscriptionModel;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.Utils.Endpoints;
import com.nesting_india_property.property.Utils.SmsData;
import com.nesting_india_property.property.Utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MySubscriptionActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;

    private RecyclerView recyclerView;

    List<MySubscriptionModel> mySubscriptionList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_subscription);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Subscription");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        progressDialog = new ProgressDialog(MySubscriptionActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        recyclerView = findViewById(R.id.recyclerView);

        mySubscriptionList = new ArrayList<>();
        showMyPurchaseEnquiry();

        }

    private void showMyPurchaseEnquiry() {

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getMySubscription, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response :: " + response);
                progressDialog.dismiss();

                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray jsonArray = obj.getJSONArray("data");

                    if (jsonArray.getJSONObject(0).getString("error").equals("false")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String subscription_title = object.getString("subscription_title");
                            String subscription_price = object.getString("subscription_price");
                            String subscription_duration = object.getString("subscription_duration");
                            String subscription_description = object.getString("subscription_description");
                            String subscription_offer = object.getString("subscription_offer");
                            String subscription_type = object.getString("subscription_type");
                            String subscription_credit = object.getString("subscription_credit");
                            String status = object.getString("status");
                            String payment_status = object.getString("payment_status");
                            String credit = object.getString("credit");
                            String expiry_date = object.getString("expiry_date");
                            String updated_at = object.getString("updated_at");
                            String error = object.getString("error");
                            String message = object.getString("message");
                            String payment_created_at = object.getString("payment_created_at");

                            MySubscriptionModel model = new MySubscriptionModel(subscription_title,
                                    subscription_price,
                                    subscription_duration,
                                    subscription_description,
                                    subscription_offer,
                                    subscription_type,
                                    subscription_credit,
                                    status,
                                    payment_status,
                                    credit,
                                    expiry_date,
                                    updated_at,
                                    error,
                                    message, payment_created_at);

                            mySubscriptionList.add(model);
                            MySubcriptionAdapter adapter = new MySubcriptionAdapter(mySubscriptionList, MySubscriptionActivity.this);
                            recyclerView.setAdapter(adapter);

                        }
                    }else{

                    }

                } catch (JSONException e) {
                    showmessage("Server Error...");
                    System.out.println("problem ::" + e);
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(MySubscriptionActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("email", VolleySingleton.getInstance(getApplicationContext()).email());
                return params;
            }
        };


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }


    private void showmessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
