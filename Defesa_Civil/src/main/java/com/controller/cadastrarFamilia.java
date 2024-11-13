package com.controller;

import com.model.*;
import com.dao.*;

public class cadastrarFamilia{
    private FamiliaDAO familiaDAO;

    public cadastrarFamilia() {
        // Inicialize o DAO
        this.familiaDAO = new FamiliaDAO();
    }

    // Método para cadastrar uma nova família
    public boolean cadastrarFamilia(String descricao, TipoRisco risco, TipoEmergencia tipoEmergencia) {
        // Validação básica dos campos
        if (tipoEmergencia == null) {
            System.out.println("O tipo de Emergência e Obrigatorio.");
            return false;
        }
        if (risco == null) {
            System.out.println("O risco deve ser adicionado.");
            return false;
        }

        // Criar uma nova instância de Família
        CadastroFamilia novaFamilia = new CadastroFamilia(descricao, risco, tipoEmergencia);

        // Tentar salvar a família no banco de dados
        boolean sucesso = familiaDAO.salvarFamilia(novaFamilia);
        
        if (sucesso) {
            System.out.println("Família cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar a família.");
        }
        
        return sucesso;
    }
}