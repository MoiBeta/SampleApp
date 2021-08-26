package com.example.sampleloginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sampleloginapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    List<Post> postList = new ArrayList<>();
    RecyclerViewAdapter adapter;
    PostViewModel postViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        postViewModel = new ViewModelProvider(getActivity()).get(PostViewModel.class);
        postList = postViewModel.getAllPosts().getValue();
        adapter = new RecyclerViewAdapter(postList);
        binding.recyclerView.setAdapter(adapter);
        setObserver();
        return binding.getRoot();
    }

    private void setObserver() {
        postViewModel.getAllPosts().observe(getActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postList = posts;
                Utils.orderList(postList);
                adapter.setData(postList);
            }
        });
    }
}
