package com.example.sampleloginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sampleloginapp.databinding.FragmentAddMessageBinding;

public class AddMessageFragment extends Fragment {
    private FragmentAddMessageBinding binding;
    private PostViewModel postViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddMessageBinding.inflate(inflater, container, false);
        postViewModel = new ViewModelProvider(getActivity()).get(PostViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editTextPost.getText().toString().isEmpty()){
                    binding.editTextPost.setError("Por favor ingresa el texto que deseas publicar.");
                } else{
                    int idFijo = 11;
                    String post = binding.editTextPost.getText().toString();
                    boolean completed = false;
                    Post newPost = new Post(idFijo, post, completed);
                    postViewModel.addPost(newPost);
                    Toast.makeText(getActivity(), "Mensaje agregado!", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(AddMessageFragment.this).navigate(R.id.action_navigation_add_message_to_navigation_home);
                }
            }
        });
    }
}
