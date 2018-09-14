package com.example.lasitha.safedrive;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VehicleType extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_type);


    }

    public void OpenComparissionInterface(View V){
            Intent intent = new Intent(VehicleType.this, Comparission.class);
            startActivity(intent);
    }

}
