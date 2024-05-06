package com.example.rsaconnect;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DriverLoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassord;
    private Button btnlogin;
    private TextView txtForgrtPass, txtSignUp;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://rsaconnect-2881d-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        edtEmail = findViewById(R.id.edtLognEmail);
        edtPassord = findViewById(R.id.edtLognPass);
        btnlogin = findViewById(R.id.btnLogin);
        txtForgrtPass = findViewById(R.id.txtForgetPass);
        txtSignUp = findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(v -> {
            Intent i = new Intent(DriverLoginActivity.this, DriverRegisterActivity.class);
            startActivity(i);
        });

        btnlogin.setOnClickListener(v -> driverlogin());


    }
    private void driverlogin(){
        String email = edtEmail.getText().toString().trim();
        String password = edtPassord.getText().toString().trim();
        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(password)) {
            Toast.makeText(DriverLoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            edtPassord.setError("Wrong password");
        }

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("drivers");

        Query emailQuery = usersRef.orderByChild("email").equalTo(email);

        emailQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // A driver with the provided email exists
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String driverId = childSnapshot.getKey();
                        String hashedPassword = childSnapshot.child("password").getValue(String.class);
                        if (hashedPassword.equals(password)) {
                            Toast.makeText(DriverLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(DriverLoginActivity.this, MainActivity.class);
                            i.putExtra("driverId",driverId);
                            startActivity(i);
                        }
                    }
                } else {
                    Toast.makeText(DriverLoginActivity.this, "Wrong password or Email" , Toast.LENGTH_SHORT).show();
                    edtPassord.setError("Wrong password");
                    edtPassord.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DriverLoginActivity.this, "Login failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}