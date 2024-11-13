package com.model;
import java.time.LocalDate;

public class Membro {
    private String CPF;
    private String nome;
    private String numTelefone;
    private LocalDate DataNasc;
    private String email;
    private String numEmergencia;
    private Endereco endereco;
    private CadastroFamilia cadastroFamilia;

    public Membro(){}

    public Membro(String CPF, String nome, String numTelefone, LocalDate DataNasc, String email, String numEmergencia, Endereco endereco, CadastroFamilia cadastroFamilia){
        this.CPF = CPF;
        this.nome = nome;
        this.numTelefone = numTelefone;
        this.DataNasc = DataNasc;
        this.email = email;
        this.numEmergencia = numEmergencia;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

     public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public LocalDate getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        DataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(String numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CadastroFamilia getCadastroFamilia() {
        return cadastroFamilia;
    }

    public void setCadastroFamilia(CadastroFamilia cadastroFamilia) {
        this.cadastroFamilia = cadastroFamilia;
    }
}
