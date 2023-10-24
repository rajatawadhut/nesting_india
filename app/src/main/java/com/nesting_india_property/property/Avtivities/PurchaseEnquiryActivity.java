package com.nesting_india_property.property.Avtivities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nesting_india_property.property.R;
import com.nesting_india_property.property.Utils.Endpoints;
import com.nesting_india_property.property.Utils.SmsData;
import com.nesting_india_property.property.Utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class PurchaseEnquiryActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    private Spinner typeofproperty, subtypeofproperty, minPrice, maxPrice, spi_property_for;
    String min = "", max = "", propertyfor = "";

    Button btnEnquiry, btnShowEnquiry;

    EditText city, locality, state, project, otherlocality;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_enquiry);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Purchase Enquiry");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        progressDialog = new ProgressDialog(PurchaseEnquiryActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);



        city = findViewById(R.id.city);
        locality = findViewById(R.id.locality);
        state = findViewById(R.id.state);
        project = findViewById(R.id.project);
        typeofproperty = findViewById(R.id.typeofproperty);
        subtypeofproperty = findViewById(R.id.subtypeofproperty);
        minPrice = findViewById(R.id.minPrice);
        maxPrice = findViewById(R.id.maxPrice);
        btnEnquiry = findViewById(R.id.btnEnquiry);
        btnShowEnquiry = findViewById(R.id.btnShowEnquiry);
        spi_property_for = findViewById(R.id.spi_property_for);



        locality.setText("");
        VolleySingleton.getInstance(getApplicationContext()).setsearchlocality("");

        state.setText("Maharashtra");
        VolleySingleton.getInstance(getApplicationContext()).setsearchstate("Maharashtra");



        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locality.setText("");
                VolleySingleton.getInstance(getApplicationContext()).setsearchlocality("");
                startActivity(new Intent(PurchaseEnquiryActivity.this, SearchCity.class));
            }
        });

        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city.setText("");
                VolleySingleton.getInstance(getApplicationContext()).setsearchcity("");
                locality.setText("");
                VolleySingleton.getInstance(getApplicationContext()).setsearchlocality("");
                startActivity(new Intent(PurchaseEnquiryActivity.this, SearchState.class));
            }
        });

        locality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PurchaseEnquiryActivity.this, SearchLocality.class));
            }
        });

        btnEnquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()) {
                    postEnquiry(VolleySingleton.getInstance(getApplicationContext()).id(), min, max, typeofproperty.getSelectedItem().toString(), subtypeofproperty.getSelectedItem().toString(),state.getText().toString(),city.getText().toString(), locality.getText().toString(),VolleySingleton.getInstance(getApplicationContext()).fname() + " " +VolleySingleton.getInstance(getApplicationContext()).lname(),VolleySingleton.getInstance(getApplicationContext()).email(),VolleySingleton.getInstance(getApplicationContext()).mobile(),"Recieved", propertyfor);
                }
            }
        });
        btnShowEnquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(PurchaseEnquiryActivity.this, ShowMyPurchaseEnquiryActivity.class));
            }
        });



        ArrayAdapter<CharSequence> minpricespinadapter = ArrayAdapter.createFromResource(PurchaseEnquiryActivity.this, R.array.minenquiryPrice, android.R.layout.simple_spinner_item);
        minpricespinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minPrice.setAdapter(minpricespinadapter);

        ArrayAdapter<CharSequence> maxpricespinadapter = ArrayAdapter.createFromResource(PurchaseEnquiryActivity.this, R.array.maxenquiryPrice, android.R.layout.simple_spinner_item);
        maxpricespinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maxPrice.setAdapter(maxpricespinadapter);


        ArrayAdapter<CharSequence> enquiryTypeOfPropertyAdapter = ArrayAdapter.createFromResource(PurchaseEnquiryActivity.this, R.array.enquiryTypeOfProperty, android.R.layout.simple_spinner_item);
        enquiryTypeOfPropertyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeofproperty.setAdapter(enquiryTypeOfPropertyAdapter);


        ArrayAdapter<CharSequence> enquirysubTypeOfPropertyAdapter = ArrayAdapter.createFromResource(PurchaseEnquiryActivity.this, R.array.enquirySubTypeOfProperty, android.R.layout.simple_spinner_item);
        enquirysubTypeOfPropertyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subtypeofproperty.setAdapter(enquirysubTypeOfPropertyAdapter);

        ArrayAdapter<CharSequence> spi_property_forAdapter = ArrayAdapter.createFromResource(PurchaseEnquiryActivity.this, R.array.propertyfor, android.R.layout.simple_spinner_item);
        spi_property_forAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_property_for.setAdapter(spi_property_forAdapter);


        spi_property_for.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                propertyfor = spi_property_for.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                min = minPrice.getSelectedItem().toString();
                if(min.equals("4000")){
                    min = "4000";
                }

                else if(min.equals("5000")){
                    min = "5000";
                }

                else if(min.equals("6000")){
                    min = "6000";
                }

                else if(min.equals("8000")){
                    min = "8000";
                }

                else if(min.equals("10000")){
                    min = "10000";
                }

                else if(min.equals("12000")){
                    min = "12000";
                }

                else if(min.equals("15000")){
                    min = "15000";
                }

                else if(min.equals("20000")){
                    min = "20000";
                }

                else if(min.equals("25000")){
                    min = "25000";
                }

                else if(min.equals("30000")){
                    min = "30000";
                }

                else if(min.equals("35000")){
                    min = "35000";
                }

                else if(min.equals("40000")){
                    min = "40000";
                }

                else if(min.equals("50000")){
                    min = "50000";
                }

                else if(min.equals("60000")){
                    min = "60000";
                }


                else if(min.equals("70000")){
                    min = "70000";
                }

                else if(min.equals("80000")){
                    min = "80000";
                }

                else if(min.equals("90000")){
                    min = "90000";
                }

                else if(min.equals("1 Lac")){
                    min = "100000";
                }

                else if(min.equals("1.5 Lac")){
                    min = "150000";
                }


                else if(min.equals("2 Lac")){
                    min = "200000";
                }

                else if(min.equals("4 Lac")){
                    min = "400000";
                }

                else if(min.equals("5 Lac")){
                    min = "500000";
                }

                else if(min.equals("7 Lac")){
                    min = "700000";
                }

                else if(min.equals("10 Lac")){
                    min = "1000000";
                }



                else if(min.equals("20 Lac")){
                    min = "2000000";
                }



                else if(min.equals("30 Lac")){
                    min = "3000000";
                }



                else if(min.equals("40 Lac")){
                    min = "4000000";
                }



                else if(min.equals("50 Lac")){
                    min = "5000000";
                }



                else if(min.equals("60 Lac")){
                    min = "6000000";
                }



                else if(min.equals("70 Lac")){
                    min = "7000000";
                }



                else if(min.equals("80 Lac")){
                    min = "8000000";
                }



                else if(min.equals("90 Lac")){
                    min = "9000000";
                }



                else if(min.equals("1 Cr")){
                    min = "10000000";
                }



                else if(min.equals("1.2 Cr")){
                    min = "12000000";
                }



                else if(min.equals("1.5 Cr")){
                    min = "15000000";
                }



                else if(min.equals("1.6 Cr")){
                    min = "16000000";
                }



                else if(min.equals("1.8 Cr")){
                    min = "18000000";
                }



                else if(min.equals("2 Cr")){
                    min = "20000000";
                }



                else if(min.equals("2.3 Cr")){
                    min = "23000000";
                }


                else if(min.equals("2.6 Cr")){
                    min = "26000000";
                }
                else if(min.equals("3 Cr")){
                    min = "30000000";
                }
                else if(min.equals("3.5 Cr")){
                    min = "35000000";
                }
                else if(min.equals("4 Cr")){
                    min = "40000000";
                }
                else if(min.equals("4.5 Cr")){
                    min = "45000000";
                }
                else if(min.equals("5 Cr")){
                    min = "50000000";
                }
                else if(min.equals("10 Cr")){
                    min = "100000000";
                }
                else if(min.equals("15 Cr")){
                    min = "150000000";
                }else {
                    min = "0";
                }




            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        maxPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                max = maxPrice.getSelectedItem().toString();

                if(max.equals("4000")){
                    max = "4000";
                }

                else if(max.equals("5000")){
                    max = "5000";
                }

                else if(max.equals("6000")){
                    max = "6000";
                }

                else if(max.equals("8000")){
                    max = "8000";
                }

                else if(max.equals("10000")){
                    max = "10000";
                }

                else if(max.equals("12000")){
                    max = "12000";
                }

                else if(max.equals("15000")){
                    max = "15000";
                }

                else if(max.equals("20000")){
                    max = "20000";
                }

                else if(max.equals("25000")){
                    max = "25000";
                }

                else if(max.equals("30000")){
                    max = "30000";
                }

                else if(max.equals("35000")){
                    max = "35000";
                }

                else if(max.equals("40000")){
                    max = "40000";
                }

                else if(max.equals("50000")){
                    max = "50000";
                }

                else if(max.equals("60000")){
                    max = "60000";
                }

                else if(max.equals("70000")){
                    max = "70000";
                }

                else if(max.equals("80000")){
                    max = "80000";
                }

                else if(max.equals("90000")){
                    max = "90000";
                }

                else if(max.equals("1 Lac")){
                    max = "100000";
                }

                else if(max.equals("1.5 Lac")){
                    max = "150000";
                }


                else if(max.equals("2 Lac")){
                    max = "200000";
                }

                else if(max.equals("4 Lac")){
                    max = "400000";
                }


                else if(max.equals("5 Lac")){
                    max = "500000";
                }

                else if(max.equals("7 Lac")){
                    max = "700000";
                }

                else if(max.equals("10 Lac")){
                    max = "1000000";
                }



                else if(max.equals("20 Lac")){
                    max = "2000000";
                }



                else if(max.equals("30 Lac")){
                    max = "3000000";
                }



                else if(max.equals("40 Lac")){
                    max = "4000000";
                }



                else if(max.equals("50 Lac")){
                    max = "5000000";
                }



                else if(max.equals("60 Lac")){
                    max = "6000000";
                }



                else if(max.equals("70 Lac")){
                    max = "7000000";
                }



                else if(max.equals("80 Lac")){
                    max = "8000000";
                }



                else if(max.equals("90 Lac")){
                    max = "9000000";
                }



                else if(max.equals("1 Cr")){
                    max = "10000000";
                }



                else if(max.equals("1.2 Cr")){
                    max = "12000000";
                }



                else if(max.equals("1.5 Cr")){
                    max = "15000000";
                }



                else if(max.equals("1.6 Cr")){
                    max = "16000000";
                }



                else if(max.equals("1.8 Cr")){
                    max = "18000000";
                }



                else if(max.equals("2 Cr")){
                    max = "20000000";
                }



                else if(max.equals("2.3 Cr")){
                    max = "23000000";
                }


                else if(max.equals("2.6 Cr")){
                    max = "26000000";
                }
                else if(max.equals("3 Cr")){
                    max = "30000000";
                }
                else if(max.equals("3.5 Cr")){
                    max = "35000000";
                }
                else if(max.equals("4 Cr")){
                    max = "40000000";
                }
                else if(max.equals("4.5 Cr")){
                    max = "45000000";
                }
                else if(max.equals("5 Cr")){
                    max = "50000000";
                }
                else if(max.equals("10 Cr")){
                    max = "100000000";
                }
                else if(max.equals("15 Cr")){
                    max = "150000000";
                }else {
                    max = "0";
                }


            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });






    }

    private boolean isValid() {
        if(propertyfor.isEmpty() || propertyfor.equals("Select Looking Property")) {
            showmessage("Please Select Looking Property!");
            return false;
        }
        else if(state.getText().toString().isEmpty()) {
            showmessage("Please Select State!");
            return false;
        }else if (city.getText().toString().isEmpty()){
            showmessage("Please Select City!");
            return false;
        }else if (locality.getText().toString().isEmpty()){
            showmessage("Please Select Locality!");
            return false;
        }else if (min.equals("0")){
            showmessage("Please Select Minimum Price!");
            return false;
        }else if (max.equals("0")){
            showmessage("Please Select Maximum Price!");
            return false;
        }else if (typeofproperty.getSelectedItem().equals("Select type of property")){
            showmessage("Please select type of property!");
            return false;
        }else if (subtypeofproperty.getSelectedItem().equals("Select sub type of property")){
            showmessage("Please select Select sub type of property!");
            return false;
        }
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(VolleySingleton.getInstance(getApplicationContext()).getsearchcity() != null){
            String citysearch = VolleySingleton.getInstance(getApplicationContext()).getsearchcity();
            city.setText(citysearch);
        }

        if(VolleySingleton.getInstance(getApplicationContext()).getsearchstate() != null){
            String citysearch = VolleySingleton.getInstance(getApplicationContext()).getsearchstate();
            state.setText(citysearch);
        }

        if(VolleySingleton.getInstance(getApplicationContext()).getsearchlocality() != null){
            String citysearch = VolleySingleton.getInstance(getApplicationContext()).getsearchlocality();
            locality.setText(citysearch);
        }

    }



    private void postEnquiry(final String userid,
                             final String minprice,
                             final String maxprice,
                             final String type,
                             final String category,
                             final String state,
                             final String city,
                             final String locality,
                             final String name,
                             final String email,
                             final String mobile,
                             final String status,
                             final String propertyfor){
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endpoints.sendMyPurchaseEnquiry, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("response ::::: "+ response);
                progressDialog.dismiss();
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.getBoolean("error")){
                        showmessage(obj.getString("message"));
                    }else{
                        showmessage(obj.getString("message"));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PurchaseEnquiryActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                SmsData smsData = new SmsData();
                Map<String, String> params = new HashMap<>();
                params.put("header", smsData.token);
                params.put("userid", userid);
                params.put("minprice", minprice);
                params.put("maxprice", maxprice);
                params.put("type", type);
                params.put("category", category);
                params.put("state", state);
                params.put("city", city);
                params.put("locality", locality);
                params.put("name", name);
                params.put("email", email);
                params.put("mobile", mobile);
                params.put("status", status);
                params.put("propertylistfor", propertyfor);
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void showmessage(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

}
