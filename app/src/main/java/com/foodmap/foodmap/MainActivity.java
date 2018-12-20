package com.foodmap.foodmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapfit.android.MapView;
import com.mapfit.android.Mapfit;
import com.mapfit.android.MapfitMap;
import com.mapfit.android.OnMapLongClickListener;
import com.mapfit.android.OnMapReadyCallback;
import com.mapfit.android.annotations.MapfitMarker;
import com.mapfit.android.annotations.Marker;
import com.mapfit.android.annotations.MarkerOptions;
import com.mapfit.android.annotations.callback.OnMarkerClickListener;
import com.mapfit.android.geometry.LatLng;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    MapView mapView;
    ArrayList<MarkerOptions> markerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // if you have an Application class, you should call this from it
        Mapfit.getInstance(this, "591dccc4e499ca0001a4c6a4ff0a7de04c0346d3bc0b3a0b682f0476");

        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NotNull final MapfitMap mapfitMap) {
                // mapfitMap is ready to be used!

                LatLng coords = new LatLng(40.744023, -73.993150);
                MarkerOptions mOp = new MarkerOptions().position(coords);
                markerList.add(mOp);

                //attempt at revitalizing pins
                for (MarkerOptions mop : markerList) {
                    mapfitMap.addMarker(mop);
                }

                //Long click add a new marker, then open its info
                mapfitMap.setOnMapLongClickListener(new OnMapLongClickListener() {
                    @Override
                    public void onMapLongClicked(@NotNull LatLng latLng) {
                        MarkerOptions mOp = new MarkerOptions().position(latLng);
                        markerList.add(mOp);
                        Marker marker1 = mapfitMap.addMarker(mOp);
                        marker1.setIcon(MapfitMarker.RESTAURANT);


                    }
                });


                //open up the information for the marker placed
                mapfitMap.setOnMarkerClickListener(new OnMarkerClickListener() {
                    @Override
                    public void onMarkerClicked(Marker m) {
                        // Do whatever you want in here
                        HashMap<String, String> hm = new HashMap<>();
                        hm.put("Name", "Tutta Bella");
                        hm.put("Rating", "3.5");
                        m.setData(hm);
                        Intent intent = new Intent(mapView.getContext(), MarkerInfo.class);
                        intent.putExtra("Name", "Tutta Bella");
                        intent.putExtra("Rating", "3.5");
                        startActivity(intent);
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


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("editTextValue");
            }
        }
    }*/

    //sleep code
    /*final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        // Do something after 5s = 5000ms
        buttons[inew][jnew].setBackgroundColor(Color.BLACK);
    }
}, 5000);*/


}
