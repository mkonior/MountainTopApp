package com.example.gosia.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView localization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localization = (TextView) findViewById(R.id.gps);
        LocationManager localManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener localListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                location.getLatitude(); // szerokosc geograficzna
                location.getLongitude(); // dlugosc geogr

                String currentLocationText = "Current location\n" + "Latitude: " + location.getLongitude() +
                        " Longtitude: " + location.getLongitude();

                localization.setText(currentLocationText);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        localManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, localListener);
    }
}
