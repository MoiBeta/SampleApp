package com.example.sampleloginapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderService {

    @GET("/todos")
    Call<List<Post>> getPosts();
}
