package com.nesting_india_property.property.Avtivities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nesting_india_property.property.Adapter.AdsAdapter;
import com.nesting_india_property.property.Adapter.AdsViewPager;
import com.nesting_india_property.property.Adapter.LatestAdapter;
import com.nesting_india_property.property.Models.AdsDataModel;
import com.nesting_india_property.property.Models.LatestDataModel;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.Utils.Endpoints;
import com.nesting_india_property.property.Utils.SmsData;
import com.nesting_india_property.property.Utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewMoreAdsActivity extends AppCompatActivity {

    private List<AdsDataModel> adsDataModels;
 private AdsAdapter adapter;

 RecyclerView advertisement;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_more_ads);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Advertisement");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        adsDataModels = new ArrayList<>();
        advertisement = findViewById(R.id.advertisement);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        advertisement.setLayoutManager(layoutManager);
        getads();
    }

    private void getads() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.getalladsimage, new Response.Listener<String>() {
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


                            String image1, id1, url1;

                            image1 = Endpoints.base_url + object.getString("image");
                            id1 = object.getString("id");
                            url1 = object.getString("url");


                            AdsDataModel adsDataModel = new AdsDataModel(id1, image1, url1);
                            adsDataModels.add(adsDataModel);
                            adapter = new AdsAdapter(adsDataModels, getApplicationContext());
                            advertisement.setAdapter(adapter);
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

    private void showmessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
