package com.example.ex_final_araucano;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

    @GET("N00179858")
    Call<Libros> getLibro();

    @POST("N00179858/libros")
    Call<Void> postCrearLibro(@Body Libros libros);



}
