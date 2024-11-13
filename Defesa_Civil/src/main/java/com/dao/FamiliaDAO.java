package com.dao;

import com.model.CadastroFamilia; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO {
    private Connection connection;

    public FamiliaDAO() {
        // Inicialize a conexão com o banco de dados
        this.connection = connectBanco.conectar();
    }

    // Método para salvar uma nova família
    public boolean salvarFamilia(CadastroFamilia familia) {
        String sql = "INSERT INTO familias (descricao, tipo_risco, tipo_emergencia) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, familia.getDescricao());
            stmt.setString(2, familia.getTipoRisco().getCategoria()); // Obtendo a categoria diretamente
            stmt.setString(3, familia.getTipoEmergencia().getCategoria()); // Obtendo a categoria diretamente

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar todas as famílias
    public List<CadastroFamilia> listarFamilias() {
        List<CadastroFamilia> familias = new ArrayList<>();
        String sql = "SELECT * FROM familias";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Instancia um novo CadastroFamilia com os dados do banco
                CadastroFamilia familia = new CadastroFamilia();

                familias.add(familia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return familias;
    }


    // Método para atualizar informações de uma família
    public boolean atualizarFamilia(CadastroFamilia familia) {
        String sql = "UPDATE familias SET tipo_risco = ?, tipo_emergencia = ? WHERE descricao = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, familia.getTipoRisco().getCategoria());
            stmt.setString(2, familia.getTipoEmergencia().getCategoria());
            stmt.setString(3, familia.getDescricao());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir uma família pela descrição
    public boolean excluirFamilia(String descricao) {
        String sql = "DELETE FROM familias WHERE descricao = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, descricao);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
