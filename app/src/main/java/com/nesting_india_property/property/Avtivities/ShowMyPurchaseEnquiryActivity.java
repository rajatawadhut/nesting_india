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
import com.nesting_india_property.property.Adapter.SubscriptionPlanAdapter;
import com.nesting_india_property.property.Models.MyPurchaseEnquiryModel;
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


public class ShowMyPurchaseEnquiryActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;

    List<MyPurchaseEnquiryModel> purchaseEnquiryList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_purchase_enquiry);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Purchase Enquiry");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        progressDialog = new ProgressDialog(ShowMyPurchaseEnquiryActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        recyclerView = findViewById(R.id.recyclerView);
        purchaseEnquiryList = new ArrayList<MyPurchaseEnquiryModel>();


        showMyPurchaseEnquiry();


    }

    private void showMyPurchaseEnquiry() {
        String userid1 = VolleySingleton.getInstance(getApplicationContext()).id();

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getMyPurchaseEnquiry, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response :: " + response);
                progressDialog.dismiss();

                try {
                    JSONObject obj = new JSONObject(response);
                    String succes = obj.getString("success");
                    JSONArray jsonArray = obj.getJSONArray("data");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String userid = object.getString("userid");
                            String minprice = object.getString("minprice");
                            String maxprice = object.getString("maxprice");
                            String type = object.getString("type");
                            String category = object.getString("category");
                            String state = object.getString("state");
                            String city = object.getString("city");
                            String locality = object.getString("locality");
                            String name = object.getString("name");
                            String email = object.getString("email");
                            String date = object.getString("date");
                            String time = object.getString("time");
                            String status = object.getString("status");



                            MyPurchaseEnquiryModel model = new MyPurchaseEnquiryModel(id, userid, minprice, maxprice, type, category, state, city, locality, name, email, date, time, status);
                            purchaseEnquiryList.add(model);
                            MyPurchaseEnquiryAdapter adapter = new MyPurchaseEnquiryAdapter(purchaseEnquiryList, ShowMyPurchaseEnquiryActivity.this);
                            recyclerView.setAdapter(adapter);
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
                progressDialog.dismiss();
                Toast.makeText(ShowMyPurchaseEnquiryActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("userid", userid1);
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
