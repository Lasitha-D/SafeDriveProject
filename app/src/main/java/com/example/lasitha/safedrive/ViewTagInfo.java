package com.example.lasitha.safedrive;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lasitha.safedrive.Model.TagDetails;

public class ViewTagInfo extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tag_info);

        listView = findViewById(R.id.view_tag_info_list);


    }
}
