package com.emadhe.maprestaurant.Menu;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emadhe.maprestaurant.ListaRestaurants.ListaAdapter;
import com.emadhe.maprestaurant.R;
import com.emadhe.maprestaurant.Api.ApiClient;
import com.emadhe.maprestaurant.Api.RetrofitClient;
import com.emadhe.maprestaurant.Model.Response;
import com.emadhe.maprestaurant.Model.Feature;
import com.emadhe.maprestaurant.db.Database;

import retrofit2.Call;
import retrofit2.Callback;


public class Home extends Fragment {

    private final String TOKEN = "pk.eyJ1IjoiZW1hZGhlcHJvZHVjdGlvbnMiLCJhIjoiY2szd2pjbzR5MGVyMTNla2k5cHg2eDQ1aCJ9.TJfo4ssu2sChrQOj7VP1cQ";

    private RecyclerView rvDatos;

    private Feature feature = new Feature();

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Casting
        rvDatos = view.findViewById(R.id.recyclerView);
        final ListaAdapter adapter = new ListaAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        //Set recyclerView
        rvDatos.setLayoutManager(layoutManager);
        rvDatos.setAdapter(adapter);
        rvDatos.setHasFixedSize(true);

        ApiClient api = RetrofitClient.MapBoxApi().create(ApiClient.class);
        Call<Response> responseCall = api.getRestaurants(10, TOKEN);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                Log.d("call", call.toString());
                if(response.code() == 200){
                    if(response.body() != null){

                        try {
                            for (int i = 0; i<response.body().features.size();i++){
                                Database.getInstance(getActivity().getApplicationContext()).restaurantsDAO().insertRestanurant(feature = response.body().features.get(i));
                            }
                        }catch (Exception ex){
                            Log.d("ex", ex.getMessage());
                        }

                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<Response> call,@NonNull Throwable t) {
                Log.d("call", call.toString());
                Log.d("error", t.getMessage());

            }
        });

        adapter.addAllLugares(Database.getInstance(getActivity().getApplicationContext()).restaurantsDAO().seletResponse());
        return view;
    }

}



