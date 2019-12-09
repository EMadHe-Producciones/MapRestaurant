package com.emadhe.maprestaurant.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    private static Retrofit retrofit;

    //Esto es un singleton, lo que hara es no crear una instancia de
    //Retrofit cada vez que lo mandemos llamar, es una buena practica
    public static Retrofit MapBoxApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
