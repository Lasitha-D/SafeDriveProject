package com.example.lasitha.safedrive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lasitha.safedrive.Model.TagDetails;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "safe_drive.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TagDetails.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TagDetails.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertNewTag(String id, String vehicle, int speed_limit){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TagDetails.TAG_ID, id);
        contentValues.put(TagDetails.VEHICLE, vehicle);
        contentValues.put(TagDetails.SPEED_LIMIT, speed_limit);

        db.insert(TagDetails.TABLE_NAME, null, contentValues);
    }

    public TagDetails viewTagDetails(SQLiteDatabase db) {

        String[] projection = {TagDetails.TAG_ID, TagDetails.VEHICLE, TagDetails.SPEED_LIMIT};
        Cursor cursor = db.query(TagDetails.TABLE_NAME, projection, null, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        TagDetails tagDetails = new TagDetails(
                cursor.getString(cursor.getColumnIndex(TagDetails.TAG_ID)),
                cursor.getString(cursor.getColumnIndex(TagDetails.VEHICLE)),
                cursor.getInt(cursor.getColumnIndex(TagDetails.SPEED_LIMIT)));

        // close the db connection
        cursor.close();
        return tagDetails;
    }

    public List<TagDetails> getAllNotes() {
        List<TagDetails> tagDetailsList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TagDetails.TABLE_NAME + " GROUP BY " +
                TagDetails.VEHICLE ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TagDetails tagDetails = new TagDetails();
                tagDetails.setTagId(cursor.getString(cursor.getColumnIndex(TagDetails.TAG_ID)));
                tagDetails.setVehicle(cursor.getString(cursor.getColumnIndex(TagDetails.VEHICLE)));
                tagDetails.setSpeedLimit(cursor.getInt(cursor.getColumnIndex(TagDetails.SPEED_LIMIT)));

                tagDetailsList.add(tagDetails);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return tagDetailsList;
    }

}
