package com.nesting_india_property.property.Avtivities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.nesting_india_property.property.Adapter.AdsViewPager;
import com.nesting_india_property.property.Adapter.AdviserAdapter;
import com.nesting_india_property.property.Adapter.MyPurchaseEnquiryAdapter;
import com.nesting_india_property.property.Models.AdsDataModel;
import com.nesting_india_property.property.Models.MyPurchaseEnquiryModel;
import com.nesting_india_property.property.Models.UserDataModel;
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


public class ChannelAdvisePartnerActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    private RecyclerView recyclerview;
    private List<UserDataModel> userDataModel;


    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_advise_partner);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Property Dealers");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        progressDialog = new ProgressDialog(ChannelAdvisePartnerActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        userDataModel = new ArrayList<UserDataModel>();
        recyclerview = findViewById(R.id.recyclerview);


        getadviser();
    }


    private void getadviser() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getAdvisor, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("response :::" + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    String succes = obj.getString("success");
                    JSONArray jsonArray = obj.getJSONArray("data");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String fname = object.getString("fname");
                            String lname = object.getString("lname");
                            String mobile = object.getString("mobile");
                            String email = object.getString("email");
                            String address = object.getString("address");
                            String city = object.getString("city");
                            String state = object.getString("state");
                            String time = object.getString("time");
                            String date = object.getString("date");
                            String status = object.getString("status");
                            String usercategory = object.getString("usercategory");
                            String profilepic = object.getString("profilepic");

                            UserDataModel userData = new UserDataModel(id, fname, lname, mobile, email, address, city, state, time, date, status, usercategory, profilepic);
                            userDataModel.add(userData);
                            AdviserAdapter adviserAdapter = new AdviserAdapter(userDataModel, ChannelAdvisePartnerActivity.this);
                            recyclerview.setAdapter(adviserAdapter);
                        }
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
                showmessage("Server Error...");
            }
        }) {
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


    public void showmessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
