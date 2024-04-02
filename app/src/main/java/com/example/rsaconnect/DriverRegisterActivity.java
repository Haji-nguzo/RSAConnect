package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DriverRegisterActivity extends AppCompatActivity {
    private EditText editName, editEmail, editPhone;
    private Button btnRegister;
    private TextView txtSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_register);

        editEmail = findViewById(R.id.edtDriverEmail);
        editName = findViewById(R.id.edtDriverName);
        editPhone = findViewById(R.id.edtPhoneNo);
        btnRegister = findViewById(R.id.btnRegister);
        txtSignIn = findViewById(R.id.txtSignIn);

        //Sign In Listener
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DriverRegisterActivity.this, DriverLoginActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DriverRegisterActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}