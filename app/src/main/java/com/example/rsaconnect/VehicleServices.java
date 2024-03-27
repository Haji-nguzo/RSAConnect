package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class VehicleServices extends AppCompatActivity {
    private RadioGroup radioGroup;
    private ImageView imgBack;
    private Button btnConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_services);

        radioGroup = findViewById(R.id.radioG);
        imgBack = findViewById(R.id.back);
        btnConfirm = findViewById(R.id.btnConfirmService);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VehicleServices.this, VihicleActivity.class);
                startActivity(i);
            }
        });
    }
}