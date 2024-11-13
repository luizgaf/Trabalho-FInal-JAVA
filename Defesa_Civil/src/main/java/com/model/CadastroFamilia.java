package com.model;

public class CadastroFamilia {
    private int idFamilia;
    private String descricao;
    private TipoRisco tipoRisco;
    private TipoEmergencia tipoEmergencia;

    public CadastroFamilia(int idFamilia, String descricao, TipoRisco tipoRisco, TipoEmergencia tipoEmergencia){
        this.idFamilia = idFamilia;
        this.descricao = descricao;
        this.tipoRisco = tipoRisco;
        this.tipoEmergencia = tipoEmergencia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoRisco getTipoRisco() {
        return tipoRisco;
    }

    public void setTipoRisco(TipoRisco tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public TipoEmergencia getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(TipoEmergencia tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }
}
