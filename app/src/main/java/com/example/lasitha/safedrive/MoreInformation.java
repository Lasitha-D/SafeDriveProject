package com.example.lasitha.safedrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreInformation extends AppCompatActivity {

    Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);

        admin = findViewById(R.id.Administrator_btn);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInformation.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
