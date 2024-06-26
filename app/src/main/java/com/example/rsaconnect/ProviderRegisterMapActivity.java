package com.example.rsaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class ProviderRegisterMap extends AppCompatActivity {
    private MapView mapView;
    private IMapController mapController;
    private GeoPoint selectedLocation;
    private String providerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_register_map);

        mapView = findViewById(R.id.map);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        providerId = getIntent().getStringExtra("providerId");

        mapController = mapView.getController();
        mapController.setZoom(25.0);
        GeoPoint startPoint = new GeoPoint(-6.7924, 39.2083); // Example coordinates (Dar es Salaam)
        mapController.setCenter(startPoint);

        mapView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });

        Button confirmLocationButton = findViewById(R.id.confirmLocationButton);
        confirmLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedLocation != null) {
                    saveLocationToFirebase(selectedLocation);
                    Intent intent = new Intent(ProviderRegisterMap.this, CorporateDoneActivity.class);
                    startActivity(intent);

                }
            }
        });
    }

    private void saveLocationToFirebase(GeoPoint location) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("providers");

        ProviderLocation serviceProvider = new ProviderLocation(providerId, location.getLatitude(), location.getLongitude());
        myRef.child(providerId).setValue(serviceProvider)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ProviderRegisterMap.this, "Location saved successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ProviderRegisterMap.this, "Failed to save location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}