package com.example.lasitha.safedrive;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.lasitha.safedrive.R.id.add_tag_vehicle_type_val;

public class AddTag extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Define variables - Insert into database
    DatabaseHelper databaseHelper;
    EditText tagId, speedLimit;
    Spinner vehicleTypeSpn;
    Context context = this;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tag_info);

        //Spinner (Dropdown) - Choose vehicle type
        vehicleTypeSpn = findViewById(add_tag_vehicle_type_val);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vehicles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpn.setAdapter(adapter);
        vehicleTypeSpn.setOnItemSelectedListener(this);

        //Casting editText variables - Insert into database
        tagId = findViewById(R.id.add_tag_id_val);
        speedLimit = findViewById(R.id.add_tag_speed_limit_val);

    }

    //Onclick function - Insert into database
    public void addNewTag(View view){

        String id = tagId.getText().toString();
        String vehicle = vehicleTypeSpn.getSelectedItem().toString();
        int speedlimit = Integer.parseInt(speedLimit.getText().toString());

        databaseHelper = new DatabaseHelper(context);

        sqLiteDatabase = databaseHelper.getWritableDatabase();

        databaseHelper.insertNewTag(id, vehicle, speedlimit);

        if(id.isEmpty()){
            Toast.makeText(getBaseContext(), "Fill all the fields", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
            clear(view);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //Onclick function - Clear data
    public void clear(View view){
        tagId.getText().clear();
        vehicleTypeSpn.setSelection(0);
        speedLimit.getText().clear();
    }

}
