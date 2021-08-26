package com.example.sampleloginapp;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repositorio {
    MutableLiveData<List<Post>> allPosts;

    public Repositorio() {
    }

    public MutableLiveData<List<Post>> getAllPosts(){
        if (allPosts == null){
            allPosts = new MutableLiveData<>();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderService jsonPlaceHolderService = retrofit.create(JsonPlaceHolderService.class);

        Call<List<Post>> call = jsonPlaceHolderService.getPosts();
            call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    allPosts.setValue(response.body());

                } else{
                    Toast.makeText(MyApp.getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Connection error", Toast.LENGTH_SHORT).show();
            }
        });
        return allPosts;
    }
}
