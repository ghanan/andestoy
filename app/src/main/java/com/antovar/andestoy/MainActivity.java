package com.antovar.andestoy;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String provider;
    private TextView lat;
    private TextView lng;
    private Location punto;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);

        lat = (TextView)findViewById(R.id.lat);
        lng = (TextView)findViewById(R.id.lng);
    }

    public void gps(View v) {
        provider = LocationManager.GPS_PROVIDER;
        comienza();
    }

    public void red(View v) {
        provider = LocationManager.NETWORK_PROVIDER;
        comienza();
    }

    private void comienza() {
        punto = locationManager.getLastKnownLocation(provider);
        if (punto != null) {
            //double lati = punto.getLatitude();
            //double lngi = punto.getLongitude();
            lat.setText("Lat: " + punto.getLatitude());
            lng.setText("Lon: " + punto.getLongitude());
            enviar();
        } else {
            lat.setText("--");
            lng.setText("--");
        }
    }

    private void enviar() {

    }

    public void terminar(View v) {
        finish();
    }
}

//http://expocodetech.com/descargar-datos-de-un-servidor-en-android/
//http://expocodetech.com/enviar-datos-a-un-servidor-desde-android/
///home/atc/Dropbox/movil/android/ECTUploadData.zip
