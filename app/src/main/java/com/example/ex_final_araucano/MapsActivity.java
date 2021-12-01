package com.example.ex_final_araucano;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ex_final_araucano.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    String lat;
    String lon;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        String ubicacion = getIntent().getStringExtra("ubicacion");
        String[] parStrings = ubicacion.split(",");
        Log.e("corr",parStrings[0]);
        lat = parStrings[0];
        lon = parStrings[1];
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney2 = new LatLng(-7.1583243, -78.5191328);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2, 14));
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(Float.parseFloat(lat), Float.parseFloat(lon));
        mMap.addMarker(new MarkerOptions().position(sydney).title("TIENDA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,20));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}