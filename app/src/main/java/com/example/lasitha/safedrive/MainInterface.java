package com.example.lasitha.safedrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainInterface extends AppCompatActivity {

    Button con_btn, more_info;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_interface);

        databaseHelper = new DatabaseHelper(this);

        more_info = findViewById(R.id.more_information);
        con_btn =  findViewById(R.id.main_continue_button);

        con_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInterface.this,VehicleType.class);
                startActivity(intent);
            }
        });

        more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInterface.this,MoreInformation.class);
                startActivity(intent);
            }
        });
    }

}
