package com.example.lasitha.safedrive.models;

import com.google.gson.annotations.SerializedName;

public class TagDetail {
    @SerializedName("tag_id")
    private String tagId;
    @SerializedName("vehicle_type")
    private String vehicleType;
    @SerializedName("speed_limit")
    private int speedLimit;

    public TagDetail(String tagId, String vehicleType, int speedLimit) {
        this.tagId = tagId;
        this.vehicleType = vehicleType;
        this.speedLimit = speedLimit;
    }

    public String getTagId() {
        return tagId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }
}
