package com.example.lasitha.safedrive;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lasitha.safedrive.Model.TagDetails;

import java.util.ArrayList;

public class ViewTagInfo extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;
    ArrayList<String> list;
    ArrayAdapter adapter;
    Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tag_info);

        listView = findViewById(R.id.view_tag_info_list);
        list = new ArrayList<>();

        databaseHelper = new DatabaseHelper(this);

        view();

    }

    private void view(){
        cursor = databaseHelper.viewTagDetails();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

}
