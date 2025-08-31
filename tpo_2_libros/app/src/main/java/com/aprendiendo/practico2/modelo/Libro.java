package com.aprendiendo.practico2.modelo;


import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String ISNB;
    private String autor;
    private String editorial;
    private String descripcion;
    private String  etiqueta;
    private int anio;
    private int paginas;
    private int imagen;
    private String colorFondo;
    private String colorTexto;

    public Libro(String titulo, String ISNB, String autor, String editorial, String descripcion, String etiqueta, int anio, int paginas, int imagen, String colorFondo, String colorTexto) {
        this.titulo = titulo;
        this.ISNB = ISNB;
        this.autor = autor;
        this.editorial = editorial;
        this.descripcion = descripcion;
        this.etiqueta = etiqueta;
        this.anio = anio;
        this.paginas = paginas;
        this.imagen = imagen;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISNB() {
        return ISNB;
    }

    public void setISNB(String ISNB) {
        this.ISNB = ISNB;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }
}