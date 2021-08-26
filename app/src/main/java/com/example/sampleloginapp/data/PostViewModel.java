package com.example.sampleloginapp.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sampleloginapp.retrofit.Post;

import java.util.List;

public class PostViewModel extends AndroidViewModel {

    private final Repositorio repositorio;
    private final LiveData<List<Post>> posts;

    public PostViewModel(@NonNull Application application) {
        super(application);
        repositorio = new Repositorio();
        posts = repositorio.getAllPosts();
    }

    public LiveData<List<Post>> getAllPosts() {
        return posts;
    }

    public void addPost(Post newPost){
        newPost.setId(posts.getValue().size() + 1);
        posts.getValue().add(newPost);
    }
}
