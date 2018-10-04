package com.example.lasitha.safedrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.lasitha.safedrive.api.APIService;
import com.example.lasitha.safedrive.api.APIUrl;

import com.example.lasitha.safedrive.models.Result;
import com.example.lasitha.safedrive.models.TagDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.lasitha.safedrive.R.id.add_tag_vehicle_type_val;

public class AddNewTag extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText tag_id, speed_limit;
    Spinner vehicle_type;
    Button newTagSave_btn;

    //This is our root url
    public static final String ROOT_URL = "http://172.19.56.147/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_tag);

        //Spinner (Dropdown) - Choose vehicle type
        vehicle_type = findViewById(add_tag_vehicle_type_val);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vehicles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicle_type.setAdapter(adapter);
        vehicle_type.setOnItemSelectedListener(this);

        //Casting editText variables - Insert into database
        tag_id = findViewById(R.id.add_tag_id_val);
        speed_limit = findViewById(R.id.add_tag_speed_limit_val);

        newTagSave_btn = findViewById(R.id.add_tag_save);

        newTagSave_btn.setOnClickListener(this);
    }


    public void addNewTag(){

            String tagId = tag_id.getText().toString().trim();
            String vehicleType = vehicle_type.getSelectedItem().toString().trim();
            int speedLimit = Integer.parseInt(speed_limit.getText().toString().trim());

            //building retrofit object
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //Defining retrofit api service
            APIService service = retrofit.create(APIService.class);

            //Defining the user object as we need to pass it with the call
            TagDetail tagDetail = new TagDetail(tagId, vehicleType, speedLimit);

            //defining the call
            Call<Result> call = service.createTagDetails(
                    tagDetail.getTagId(),
                    tagDetail.getVehicleType(),
                    tagDetail.getSpeedLimit()
            );

            //calling the api
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
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
        tag_id.getText().clear();
        vehicle_type.setSelection(0);
        speed_limit.getText().clear();
    }

    @Override
    public void onClick(View v) {
        addNewTag();
        clear(v);
    }
}
