package com.model;

public class TipoEmergencia {
    private int idEmergencia;
    private String categoria;

    public TipoEmergencia() {}

    public TipoEmergencia(int idEmergencia, String categoria){
        this.idEmergencia = idEmergencia;
        this.categoria = categoria;
    }

    public int getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(int idRisco) {
        this.idEmergencia = idRisco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
