package com.jpdas.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jpdas.assignment.Adapter.TripAdapter;
import com.jpdas.assignment.Models.Trip;
import com.jpdas.assignment.Utils.CommonI;
import com.jpdas.assignment.Utils.JsonChilds;
import com.jpdas.assignment.Utils.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rvTrip;
    private ArrayList<Trip> trips;
    private TripAdapter tripAdapter;
    private TextView tv_name,tv_location,tv_rides,tv_freeRides,tv_value;
    private CircleImageView iv_profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        setDatas();


    }

    private void init()
    {
        rvTrip=findViewById(R.id.trip_recycleview);
        tv_freeRides=findViewById(R.id.tv_free_rides);
        tv_rides=findViewById(R.id.tv_rides);
        tv_location=findViewById(R.id.tv_user_location);
        tv_name=findViewById(R.id.tv_user_name);
        tv_value=findViewById(R.id.tv_credits);
        iv_profile_image=findViewById(R.id.user_profile_image);

    }

    private void setDatas() {
        if (!CommonI.connectionAvailable(MainActivity.this)) {
            CommonI.redirectToErrorPage(MainActivity.this, getString(R.string.check_internet), "", 0);
        } else {
            rvTrip.setHasFixedSize(true);
            rvTrip.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            trips = new ArrayList<>();

            RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    Urls.USER_CONTENT , null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (!(response.getBoolean(JsonChilds.IS_ERROR))) {
                            CommonI.redirectToErrorPage(MainActivity.this,
                                    getString(R.string.something_went_error),
                                    response.getString(JsonChilds.ERROR_MSG), 3);
                        } else
                            {


                                JSONArray tripsArray =response.getJSONObject(JsonChilds.DATA).getJSONArray(JsonChilds.TRIPS);

                                String firstName = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.PROFILE).getString(JsonChilds.FIRST_NAME);
                                String lastName = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.PROFILE).getString(JsonChilds.LAST_NAME);
                                String city = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.PROFILE).getString(JsonChilds.CITY);
                                String country = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.PROFILE).getString(JsonChilds.COUNTRY);

                                int rides = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.STATS).getInt(JsonChilds.RIDES);
                                int freeRides = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.STATS).getInt(JsonChilds.FREE_RIDES);
                                int value = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.STATS).getJSONObject(JsonChilds.CREDITS).getInt(JsonChilds.VALUE);
                                String currencySymbol = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.STATS).getJSONObject(JsonChilds.CREDITS).getString(JsonChilds.CURRENCY_SYMBOL);

                                String middleName = response.getJSONObject(JsonChilds.DATA).getJSONObject(JsonChilds.PROFILE).getString(JsonChilds.MIDDLE_NAME);

                                Glide.with(MainActivity.this)
                                        .load(middleName)
                                        .into(iv_profile_image);

                                tv_name.setText(firstName+" "+lastName);
                                tv_location.setText(city+","+country);
                                tv_rides.setText(String.valueOf(rides));
                                tv_freeRides.setText(String.valueOf(freeRides));
                                tv_value.setText(currencySymbol+String.valueOf(value));



                                for(int i=0;i< tripsArray.length() ;i++)
                                {
                                    JSONObject tripJSONObject = tripsArray.getJSONObject(i);



                                    trips.add(new Trip(tripJSONObject.getString(JsonChilds.FROM),tripJSONObject.getString(JsonChilds.TO),
                                            tripJSONObject.getLong(JsonChilds.FROM_TIME),tripJSONObject.getLong(JsonChilds.TO_TIME),
                                            tripJSONObject.getInt(JsonChilds.TRIP_DURATION_IN_MINUTE),tripJSONObject.getJSONObject(JsonChilds.COST).getInt(JsonChilds.VALUE),
                                            tripJSONObject.getJSONObject(JsonChilds.COST).getString(JsonChilds.CURRENCY),
                                            tripJSONObject.getJSONObject(JsonChilds.COST).getString(JsonChilds.CURRENCY_SYMBOL)));
                                }


                                tripAdapter = new TripAdapter(MainActivity.this, trips);
                                rvTrip.setAdapter(tripAdapter);
                                tripAdapter.notifyDataSetChanged();






                        }

                    } catch (JSONException e) {
                        CommonI.redirectToErrorPage(MainActivity.this,
                                getString(R.string.something_went_error),
                                e.getMessage(), 1);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NoConnectionError) {
                        CommonI.redirectToErrorPage(MainActivity.this, getString(R.string.check_internet), "", 0);
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(MainActivity.this,
                                getString(R.string.error_network_timeout),
                                Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {

                    } else if (error instanceof ServerError) {
                        CommonI.redirectToErrorPage(MainActivity.this,
                                getString(R.string.something_went_wrong),
                                error.toString(), 2);
                    } else if (error instanceof NetworkError) {
                        CommonI.redirectToErrorPage(MainActivity.this,
                                getString(R.string.something_went_error),
                                error.toString(), 2);

                    } else if (error instanceof ParseError) {

                    }
                }
            });


            mRequestQueue.add(jsonObjectRequest);
        }

    }

}
