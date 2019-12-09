package com.emadhe.maprestaurant.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.emadhe.maprestaurant.Menu.MenuFragment;
import com.emadhe.maprestaurant.R;

public class Splash extends AppCompatActivity {


    private final int demora_splash = 2000; // para agregar la duración del splash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public android.content.Context mContext;

            @Override
            public void run() {

                Intent mi_intent = new Intent(Splash.this, MenuFragment.class);
                startActivity(mi_intent);
                finish();


            }
        }, demora_splash); //creacion de un hilo para procesos, Sirve para llamar una funcion y esta genere un proceso
    }
}