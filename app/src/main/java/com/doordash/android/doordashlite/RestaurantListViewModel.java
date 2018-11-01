package com.doordash.android.doordashlite;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import com.doordash.android.doordashlite.model.Restaurant;
import com.doordash.android.doordashlite.network.NetworkClient;
import com.doordash.android.doordashlite.network.NetworkInterface;
import com.doordash.android.doordashlite.network.NetworkUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SreeL1 on 10/31/2018.
 *
 */

class RestaurantListViewModel extends ViewModel {
    private MutableLiveData<List<Restaurant>> restaurantList;

    //Pass params if the request query parameters are dynamic
    LiveData<List<Restaurant>> getRestaurantList() {
        if (restaurantList == null) {
            restaurantList = new MutableLiveData<>();
            loadRestaurants();
        }
        return restaurantList;
    }

    private void loadRestaurants() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LAT_KEY, NetworkUtil.LAT_VALUE);
        params.put(NetworkUtil.LNG_KEY, NetworkUtil. LNG_VALUE);
        params.put(NetworkUtil.OFFSET_KEY, NetworkUtil.OFFSET_VALUE);
        params.put(NetworkUtil.LIMIT_KEY, NetworkUtil.LIMIT_VALUE);

        NetworkInterface networkInterface = NetworkClient.getClient().create(NetworkInterface.class);
        Call<List<Restaurant>> call = networkInterface.getRestaurantList(params);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(@NonNull Call<List<Restaurant>> call, @NonNull Response<List<Restaurant>> response) {
                if (response.isSuccessful()) {
                    restaurantList.setValue(response.body());
                } else {
                    Log.d("RestaurantListViewModel", "Response Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Restaurant>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
