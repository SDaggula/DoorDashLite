package com.doordash.android.doordashlite.network;

import com.doordash.android.doordashlite.model.Restaurant;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public interface NetworkInterface {

    /*
    "/v2/restaurant/?lat=<LAT>&lng=<LNG>&offset=0&limit=50"
    **/
    @GET("/v2/restaurant/")
    Call<List<Restaurant>> getRestaurantList(@QueryMap Map<String, String> params);

    @GET("/v2/restaurant/{restaurant_id}/")
    Call<Restaurant> getRestaurant(@Path("restaurant_id") String restaurant_id);
}
