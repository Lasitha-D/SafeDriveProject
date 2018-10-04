package com.example.lasitha.safedrive.models;


/*
 * Created 01/10/2018 @09.00am
 * RL Dilshan
 * */


import java.util.List;

public class TagsDetailsResult {

    private String error;
    private List<TagDetail> tagsDetails;

    public TagsDetailsResult(String error, List<TagDetail> tagsDetails) {
        this.error = error;
        this.tagsDetails = tagsDetails;
    }

    public String getError() {
        return error;
    }

    public List<TagDetail> getTagsDetails() {
        return tagsDetails;
    }
}