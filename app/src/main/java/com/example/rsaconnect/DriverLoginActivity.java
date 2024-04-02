package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DriverLoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassord;
    private Button btnlogin;
    private TextView txtForgrtPass, txtSignUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        edtEmail = findViewById(R.id.edtLognEmail);
        edtPassord = findViewById(R.id.edtLognPass);
        btnlogin = findViewById(R.id.btnLogin);
        txtForgrtPass = findViewById(R.id.txtForgetPass);
        txtSignUp = findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DriverLoginActivity.this, DriverRegisterActivity.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DriverLoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}