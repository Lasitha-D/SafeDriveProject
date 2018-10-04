package com.example.lasitha.safedrive.api;

/*
* Created 27/09/2018 @10.06pm
* RL Dilshan
* */


import com.example.lasitha.safedrive.models.Result;
import com.example.lasitha.safedrive.models.TagsDetailsResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    //The register call
    @FormUrlEncoded
    @POST("addNewTag")
    Call<Result> createTagDetails(
            @Field("tag_id") String tag_id,
            @Field("vehicle_type") String vehicle_type,
            @Field("speed_limit") int speed_limit
    );


    //the signin call
    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );


    //the viewall tags
    @GET("tagsDetails")
    Call<TagsDetailsResult> getAllTags();
}