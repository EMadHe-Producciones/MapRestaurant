package com.emadhe.maprestaurant.MapRestaurant;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.emadhe.maprestaurant.Model.Feature;
import com.emadhe.maprestaurant.R;
import com.emadhe.maprestaurant.Api.ApiClient;
import com.emadhe.maprestaurant.Api.RetrofitClient;
import com.emadhe.maprestaurant.Model.Response;
import com.emadhe.maprestaurant.db.Database;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private final String TOKEN = "pk.eyJ1IjoiZW1hZGhlcHJvZHVjdGlvbnMiLCJhIjoiY2szd2pjbzR5MGVyMTNla2k5cHg2eDQ1aCJ9.TJfo4ssu2sChrQOj7VP1cQ";


    private GoogleMap mMap;

    public MapsActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
             .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);

        return view;
    }
    //Aqui debajo en onMapReady tiene que estar las coordenadas de tus maracdores, para quie se vean en el mapa

    @Override
    public void onMapReady (GoogleMap googleMap) {
        mMap = googleMap;

        List<Feature> coordenadas = new ArrayList<>();
        coordenadas.addAll(Database.getInstance(getActivity().getApplicationContext()).restaurantsDAO().seletResponse());
        for (int i = 0; i<coordenadas.size();i++){
            //Coordenadas en latitud y longitud
            LatLng sydney = new LatLng(coordenadas.get(i).getCenter().get(1), coordenadas.get(i).getCenter().get(0));
            mMap.addMarker(new MarkerOptions().position(sydney).title(coordenadas.get(i).getPlaceName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }
}
