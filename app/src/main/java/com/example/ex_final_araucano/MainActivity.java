package com.example.ex_final_araucano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.registrar);

        registrar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), registrar_libros.class);
            startActivity(intent);
        });

    }

}