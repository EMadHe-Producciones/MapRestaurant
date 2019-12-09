package com.emadhe.maprestaurant.Api;


import com.emadhe.maprestaurant.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiClient {

    @GET("mexico_restaurantes.json")
    //Asegurarse que el call sea de retrofit, porque hay otras librerias que son call y te dara error
    Call<Response> getRestaurants(@Query("limit") int limit, @Query("access_token") String token);

}
