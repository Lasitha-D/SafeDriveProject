package com.example.lasitha.safedrive;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "safe_drive_db";
    public static final String TABLE_NAME = "rfid_details";
    public static final String ID = "ID";
    public static final String VEHICLE = "VEHICLE";
    public static final String SPEED_LIMIT = "SPEEDLIMIT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
