package com.example.ex_final_araucano;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ex_final_araucano.Model.Tienda;

public class detalleActivity extends AppCompatActivity {

    ImageView imagen;
    EditText titulo;
    EditText resumen;
    EditText autor;
    EditText fecha_publicacion;
    EditText tienda1;
    EditText tienda2;
    EditText tienda3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Tienda tienda = (Tienda) getIntent().getSerializableExtra("Tienda");


        titulo = findViewById(R.id.titulo);
        resumen = findViewById(R.id.resumen);
        autor = findViewById(R.id.autor);
        fecha_publicacion = findViewById(R.id.fecha_publi);
        tienda1 = findViewById(R.id.tienda1);
        tienda2 = findViewById(R.id.tienda2);
        tienda3 = findViewById(R.id.tienda3);

    }
}