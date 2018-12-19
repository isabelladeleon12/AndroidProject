package com.foodmap.foodmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapfit.android.MapView;
import com.mapfit.android.Mapfit;
import com.mapfit.android.MapfitMap;
import com.mapfit.android.OnMapReadyCallback;
import com.mapfit.android.annotations.Marker;
import com.mapfit.android.annotations.MarkerOptions;
import com.mapfit.android.annotations.callback.OnMarkerClickListener;
import com.mapfit.android.geometry.LatLng;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // if you have an Application class, you should call this from it
        Mapfit.getInstance(this, "591dccc4e499ca0001a4c6a4ff0a7de04c0346d3bc0b3a0b682f0476");

        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NotNull MapfitMap mapfitMap) {
                // mapfitMap is ready to be used!
                LatLng latLng = new LatLng(40.744023, -73.993150);
                mapfitMap.addMarker(new MarkerOptions().position(latLng));


                mapfitMap.setOnMarkerClickListener(new OnMarkerClickListener() {
                    @Override
                    public void onMarkerClicked(Marker m) {
                        // Do whatever you want in here
                        m.remove();
                    }
                });
            }



        });





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}
