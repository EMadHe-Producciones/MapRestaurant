package com.emadhe.maprestaurant.Api;


import com.emadhe.maprestaurant.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiClient {

    @GET("Nayarit_restaurantes.json")
    Call<Response> getRestaurants(@Query("limit") int limit, @Query("access_token") String token);

}
