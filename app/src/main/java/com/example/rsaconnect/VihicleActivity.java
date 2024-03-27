package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class VihicleActivity extends AppCompatActivity {
    private ImageView back;
    private TextView txtDriverName, txtCarCompany, txtModel, txtFuel;
    private EditText edtCompany,edtmodel, edtPlateNo, edtFuel;
    private Button btnCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vihicle);
        initView();

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VihicleActivity.this, AddDetailActivity.class);
                startActivity(i);
                //TO DO:
            }
        });

    }
    public void initView(){
        back = findViewById(R.id.back);
        txtCarCompany = findViewById(R.id.txtCompany);
        txtFuel = findViewById(R.id.txtFuel);
        txtModel = findViewById(R.id.txtModel);
        txtDriverName = findViewById(R.id.txtDriverName);

        edtCompany = findViewById(R.id.edtCompany);
        edtmodel = findViewById(R.id.edtModel);
        edtFuel = findViewById(R.id.edtFuels);
        edtPlateNo = findViewById(R.id.edtPlateNo);

        btnCont = findViewById(R.id.btnConfirmCarDetail);

    }
}