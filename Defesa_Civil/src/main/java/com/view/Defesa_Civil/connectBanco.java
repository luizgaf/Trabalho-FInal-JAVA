package com.view.Defesa_Civil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectBanco {

    private static final String url = "jdbc:mysql://localhost:3306/defesacivil"; 
    private static final String usuario = "root"; 
    private static final String senha = ""; 

    public connectBanco(){
        conectar();
    }

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver do MySQL permanece o mesmo
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public static void main(String[] args) {
        // Testa a conexão
        Connection conexao = conectar();
        if (conexao != null) {
            try {
                conexao.close(); // Fecha a conexão após o teste
                System.out.println("Conexão encerrada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
