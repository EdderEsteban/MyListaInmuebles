package com.ddrssoft.mylistainmuebles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ddrssoft.mylistainmuebles.databinding.ActivityMainBinding;
import com.ddrssoft.mylistainmuebles.modelo.Inmueble;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewModelMainActivity vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMainActivity.class);
        //Crear el Observer
        vm.getMutableInmueble().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmuebleAdapter ia = new InmuebleAdapter(MainActivity.this, binding.listaInmueble.getId(), inmuebles, getLayoutInflater());
                binding.listaInmueble.setAdapter(ia);
            }
        });
        vm.agregarInmueble();
    }
}