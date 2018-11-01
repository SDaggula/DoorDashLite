package com.doordash.android.doordashlite;

import com.doordash.android.doordashlite.model.Restaurant;
import com.doordash.android.doordashlite.network.NetworkClient;
import com.doordash.android.doordashlite.network.NetworkInterface;
import com.doordash.android.doordashlite.network.NetworkUtil;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Network local unit test, which will execute on the development machine (host).
 *
 */
public class NetworkUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getRestaurants_Success() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LAT_KEY, NetworkUtil.LAT_VALUE);
        params.put(NetworkUtil.LNG_KEY, NetworkUtil. LNG_VALUE);
        params.put(NetworkUtil.OFFSET_KEY, NetworkUtil.OFFSET_VALUE);
        params.put(NetworkUtil.LIMIT_KEY, NetworkUtil.LIMIT_VALUE);
        getRestaurants(params);
        Response<List<Restaurant>> response = getRestaurants(params);
        List<Restaurant> restaurants = response.body();
        assertTrue(response.isSuccessful() && restaurants != null && restaurants.size() > 0);
    }

    @Test
    public void getRestaurants_Success2() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LAT_KEY, "-1");
        params.put(NetworkUtil.LNG_KEY,"-1");
        params.put(NetworkUtil.OFFSET_KEY, NetworkUtil.OFFSET_VALUE);
        params.put(NetworkUtil.LIMIT_KEY, "10");
        getRestaurants(params);
        Response<List<Restaurant>> response = getRestaurants(params);
        if(response != null) {
            List<Restaurant> restaurants = response.body();
            assertTrue(response.isSuccessful() && restaurants != null && restaurants.size() == 0);
        }
    }

    @Test
    public void getRestaurants_Success3() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LAT_KEY, NetworkUtil.LAT_VALUE);
        params.put(NetworkUtil.LNG_KEY, NetworkUtil. LNG_VALUE);
        getRestaurants(params);
    }

    @Test
    public void getRestaurants_failure1() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LAT_KEY, NetworkUtil.LAT_VALUE);
        params.put(NetworkUtil.OFFSET_KEY, NetworkUtil.OFFSET_VALUE);
        params.put(NetworkUtil.LIMIT_KEY, NetworkUtil.LIMIT_VALUE);
        Response<List<Restaurant>> response = getRestaurants(params);
        if(response != null)
            assertTrue(!response.isSuccessful());
    }

    @Test
    public void getRestaurants_failure2() {
        Map<String, String> params = new HashMap<>();
        params.put(NetworkUtil.LNG_KEY, NetworkUtil. LNG_VALUE);
        params.put(NetworkUtil.OFFSET_KEY, NetworkUtil.OFFSET_VALUE);
        params.put(NetworkUtil.LIMIT_KEY, NetworkUtil.LIMIT_VALUE);
        Response<List<Restaurant>> response = getRestaurants(params);
        if(response != null)
            assertTrue(!response.isSuccessful());
    }

    @Test
    public void getRestaurants_failure3() {
        Map<String, String> params = new HashMap<>();
        Response<List<Restaurant>> response = getRestaurants(params);
        if(response != null)
            assertTrue(!response.isSuccessful());
    }

    private Response<List<Restaurant>> getRestaurants(Map<String, String> params) {
        NetworkInterface networkInterface = NetworkClient.getClient().create(NetworkInterface.class);
        Call<List<Restaurant>> call = networkInterface.getRestaurantList(params);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}