package com.model;

public class TipoRisco {
    private int idRisco;
    private String categoria;

    public TipoRisco() {}

    public TipoRisco(int idRisco, String categoria){
        this.idRisco = idRisco;
        this.categoria = categoria;
    }

    public int getIdRisco() {
        return idRisco;
    }

    public void setIdRisco(int idRisco) {
        this.idRisco = idRisco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}