package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class VehicleServices extends AppCompatActivity {
    private ImageView imgBack;
    private Button btnConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_services);

        imgBack = findViewById(R.id.backArrow);
        btnConfirm = findViewById(R.id.btnConfirmService);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });


  findViewById(R.id.card1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.card2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.card3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonTire = findViewById(R.id.radioTire);
                if (radioButtonTire.isChecked()) {
                    radioButtonTire.setChecked(false);
                }else {
                    radioButtonTire.setChecked(true);
                }
            }
        });
        findViewById(R.id.card4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonKey = findViewById(R.id.radioKey);
                if (radioButtonKey.isChecked()) {
                    radioButtonKey.setChecked(false);
                }else {
                    radioButtonKey.setChecked(true);
                }
            }
        });
        findViewById(R.id.card5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonBattery = findViewById(R.id.radioBattery);
                if (radioButtonBattery.isChecked()){
                    radioButtonBattery.setChecked(false);
                }else {
                    radioButtonBattery.setChecked(true);
                }
            }
        });
        findViewById(R.id.card6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonOther = findViewById(R.id.radioOther);
                if (radioButtonOther.isChecked()) {
                    radioButtonOther.setChecked(false);
                }else {
                    radioButtonOther.setChecked(true);
                }
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(VehicleServices.this, VihicleActivity.class);
                    startActivity(i);

            }
        });
        getOnBackPressedDispatcher().onBackPressed();
    }
    public void selectedService(){

    }
}