package com.example.sampleloginapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sampleloginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.eTUserId.getText().toString().isEmpty()){
                    binding.eTUserId.setError("Nombre de Usuario necesario para continuar");
                } else if(binding.editTextPassword.getText().toString().isEmpty()){
                    binding.editTextPassword.setError("Contraseña necesaria para continuar");
                } else{
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}