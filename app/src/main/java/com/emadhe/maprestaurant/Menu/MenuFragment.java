package com.emadhe.maprestaurant.Menu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.emadhe.maprestaurant.MapRestaurant.MapsActivity;
import com.emadhe.maprestaurant.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MenuFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_fragment);


        BottomNavigationView bottomNav = findViewById(R.id.navigationmenu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.menu_aplicacion_home);

        setFragment(new Home());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_aplicacion_mapares:
                            selectedFragment = new MapsActivity();
                            break;

                        case R.id.menu_aplicacion_home:
                            selectedFragment = new Home();
                            break;

                        case R.id.menu_aplicacion_about:
                            DialogFragment fragment = new AcercaDe();
                            fragment.show(getSupportFragmentManager(), "Fragment Acercade");
                            return true;


                        default:
                            selectedFragment = new Home();
                            break;

                    }
                    setFragment(selectedFragment);

                    return true;
                }
            };

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public void setFragmentServices(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}
