package com.example.ex_final_araucano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registrar_libros extends AppCompatActivity {

    ImageView imagen;
    EditText titulo;
    EditText resumen;
    EditText autor;
    EditText fecha_publicacion;
    EditText tienda1;
    EditText tienda2;
    EditText tienda3;
    Button registrar;
    Button subirGaleria;
    Button subirCamara;
    String imagenString;
    Uri imageUri;

    static final int REQUEST_IMAGE_CAPTURE = 10;
    private static final int PICK_IMAGE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_libros);

        imagen = findViewById(R.id.imgaen);
        registrar = findViewById(R.id.registrar);
        subirGaleria = findViewById(R.id.subirGaleria);
        subirCamara = findViewById(R.id.subirCamara);
        titulo = findViewById(R.id.titulo);
        resumen = findViewById(R.id.resumen);
        autor = findViewById(R.id.autor);
        fecha_publicacion = findViewById(R.id.fecha_publi);
        tienda1 = findViewById(R.id.tienda1);
        tienda2 = findViewById(R.id.tienda2);
        tienda3 = findViewById(R.id.tienda3);


        checkPermisos();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service crearLibro = retrofit.create(Service.class);

        registrar.setOnClickListener(v -> {

            //titulo, resumen,autor, fecha_publicacion, tienda1, tienda2, tienda3;
            String nombresLibros = titulo.getEditableText().toString().trim();
            String resumenes = resumen.getEditableText().toString().trim();
            String AUTORLIB = autor.getText().toString().trim();
            String FECHA_PUBLI = fecha_publicacion.getText().toString().trim();
            String tienda_1 = tienda1.getText().toString().trim();
            String tienda_2 = tienda2.getText().toString().trim();
            String tienda_3 = tienda3.getText().toString().trim();


            Libros libro = new Libros(nombresLibros, resumenes,AUTORLIB, FECHA_PUBLI,tienda_1, tienda_2, imagenString);

            Log.e("Titulo ", nombresLibros);
            Log.e("Resumenes ", resumenes);
            Log.e("Autor ", AUTORLIB);
            Log.e("fecha ", FECHA_PUBLI);
            Log.e("tienda1 ", tienda_1);
            Log.e("tienda2 ", tienda_2);



            if (!nombresLibros.equals("") && !resumenes.equals("") && imagenString != null && !imagenString.equals("")) {
                Call<Void> entre = crearLibro.postCrearLibro(libro);
                entre.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        String respons = String.valueOf(response.code());
                        if (respons.equals("200")) {
                            Toast.makeText(getApplicationContext(), "LIBRO Registrado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                            Log.i("MAIN_APP", "ERROR 1");
                        } else {
                            Log.e("error  ", respons);
                            Toast.makeText(getApplicationContext(), "LIBRO no registrado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("ERROR", t.getMessage());
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "ERROR1", Toast.LENGTH_SHORT).show();
            }
        });

        subirGaleria.setOnClickListener(v -> cargarImagen());

        subirCamara.setOnClickListener(v -> abrirCamara());
    }

    private void abrirCamara() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imagen = stream.toByteArray();
            imagenString = Base64.encodeToString(imagen, Base64.DEFAULT);

        }

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imagen.setImageURI(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                byte[] image = outputStream.toByteArray();
                String encodedString = Base64.encodeToString(image, Base64.DEFAULT);
                imagenString = encodedString;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkPermisos() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(registrar_libros.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
    }
}