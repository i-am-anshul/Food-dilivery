package com.example.anshul.p1.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.anshul.p1.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Created by Anshul on 1/12/2018.
 */

public class frag2 extends Fragment implements OnMapReadyCallback{

    private GoogleMap googleMap;
    private MapView mapView;
    private boolean mapsSupported = true;
    public frag2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            mapsSupported = false;

        }

        if (mapView != null) {
            mapView.onCreate(savedInstanceState);
        }
        initializeMap();
    }


    private void initializeMap() {
        if (googleMap == null && mapsSupported) {
            mapView = (MapView) getActivity().findViewById(R.id.map);

            mapView.getMapAsync(this);
            //setup markers etc...
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RelativeLayout parent = (RelativeLayout) inflater.inflate(R.layout.fragment_two, container, false);
        mapView = (MapView) parent.findViewById(R.id.map);
        return parent;


    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        initializeMap();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;



        LatLng r1 = new LatLng(26.992070, 75.778885);
        googleMap.addMarker(new MarkerOptions().position(r1).title("Resturant 1").snippet("This is Resturant 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon3)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(r1));

        LatLng r2 = new LatLng(28.7041, 77.1025);
        googleMap.addMarker(new MarkerOptions().position(r2).title("Resturant 2").snippet("This is Resturant 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon3)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(r2));

        LatLng r3 = new LatLng(19.0760, 72.8777);
        googleMap.addMarker(new MarkerOptions().position(r3).title("Resturant 3").snippet("This is Resturant 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon3)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(r3));
    }
}
