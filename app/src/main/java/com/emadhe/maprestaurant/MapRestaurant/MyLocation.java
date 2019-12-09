package com.emadhe.maprestaurant.MapRestaurant;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MyLocation {
    LatLng latLng;
    String title;
    String snippet;

    private void LocationsLoaded(List<MyLocation> locations) {

        for (MyLocation myLoc : locations) {
         /*   mMap.addMarker(new MarkerOptions()
                    .position(myLoc.latLng)
                    .title(myLoc.title)
                    .snippet(myLoc.snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        }*/
        }
    }
}
