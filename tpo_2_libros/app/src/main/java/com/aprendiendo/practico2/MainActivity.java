package com.aprendiendo.practico2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aprendiendo.practico2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getMutableError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                binding.twError.setText(mensaje);
            }
        });

        binding.btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = binding.etTitulo.getText().toString();
                binding.twError.setText("");
                vm.buscarLibro(titulo);

            }
        });

        binding.etTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.twError.setText("");
            }
        });
    }


}