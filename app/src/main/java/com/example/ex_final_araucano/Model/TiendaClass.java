package com.example.ex_final_araucano.Model;

public class TiendaClass {

    String  titulo,resumen,autor,fecha_publicacion,tienda1,tienda2,tienda3,foto;

    public TiendaClass(String titulo, String resumen, String autor, String fecha_publicacion, String tienda1, String tienda2, String tienda3, String foto) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.tienda3 = tienda3;
        this.foto = foto;
    }

    public TiendaClass() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getTienda1() {
        return tienda1;
    }

    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }

    public String getTienda2() {
        return tienda2;
    }

    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }

    public String getTienda3() {
        return tienda3;
    }

    public void setTienda3(String tienda3) {
        this.tienda3 = tienda3;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
