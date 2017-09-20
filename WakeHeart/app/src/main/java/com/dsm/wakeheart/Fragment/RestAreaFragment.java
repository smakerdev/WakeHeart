package com.dsm.wakeheart.Fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsm.wakeheart.GPSinfo;
import com.dsm.wakeheart.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestAreaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GPSinfo gps;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_helper_restarea,container,false);
        SupportMapFragment mapFragment = ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapView));
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(5.0f);

        double latitude =37;
        double longitude=126;
        gps = new GPSinfo(getActivity());
        if(gps.isGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            System.out.println("위도 : "+latitude+ " 경도 : "+longitude);
        }else{
            gps.showSettingsAlert();
        }

        //Latitude(위도), Longitude(경도)
        LatLng latLng = new LatLng(latitude, longitude);
        CameraUpdateFactory.newLatLngZoom(latLng,20.0f);
        MarkerOptions marker = new MarkerOptions().position(latLng);
        mMap.addMarker(marker);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }
}