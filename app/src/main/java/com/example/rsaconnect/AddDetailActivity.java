package com.example.rsaconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddDetailActivity extends AppCompatActivity {
    private ImageView img;
    private EditText edtDetail;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detail);
        img = findViewById(R.id.back);
        edtDetail = findViewById(R.id.txtAddDetail);
        buttonAdd = findViewById(R.id.btnAddDetail);

        String detail = edtDetail.getText().toString();

        //Add onclick listerner
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    Intent i = new Intent(AddDetailActivity.this, )
            }
        });
    }
}