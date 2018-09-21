package com.example.lasitha.safedrive.Model;

public class TagDetails {
    private String tagId;
    private String vehicle;
    private  int speedLimit;

    public static final String TABLE_NAME = "tag_info";
    public static final String TAG_ID = "id";
    public static final String VEHICLE = "vehicle";
    public static final String SPEED_LIMIT = "speed_limit";

    //create table query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                + TAG_ID + "TEXT PRIMARY KEY,"
                + VEHICLE + " TEXT,"
                + SPEED_LIMIT + " INTEGER"
                + ")";

    public TagDetails(){

    }

    public TagDetails(String tag_id, String vehicle, int speed_limit){
        this.tagId = tag_id;
        this.vehicle = vehicle;
        this.speedLimit = speed_limit;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
