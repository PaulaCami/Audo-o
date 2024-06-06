/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.audocao1;


import com.mycompany.audocao1.Cadastro;
import com.mycompany.audocao1.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author pcami
 */
public class CadastroDAO {
    
 public void cadastrar(Cadastro u) throws SQLException {
        String cadastroSql = "INSERT INTO cadastro (nome, idade, genero, cpf, email, senha, verificarsenha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String usuarioSql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection()) {
            conexao.setAutoCommit(false); // Inicia a transação

            try (PreparedStatement cadastroPs = conexao.prepareStatement(cadastroSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                cadastroPs.setString(1, u.getNome());
                cadastroPs.setInt(2, u.getIdade());
                cadastroPs.setString(3, u.getGenero());
                cadastroPs.setString(4, u.getCpf());
                cadastroPs.setString(5, u.getEmail());
                cadastroPs.setString(6, u.getSenha());
                cadastroPs.setString(7, u.getVerificarSenha());

                cadastroPs.executeUpdate();

                try (ResultSet generatedKeys = cadastroPs.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int cadastroId = generatedKeys.getInt(1);
                        u.setUsuarioId(cadastroId); // Define o ID do usuário

                        try (PreparedStatement usuarioPs = conexao.prepareStatement(usuarioSql)) {
                            usuarioPs.setString(1, u.getEmail()); // Usando o email como login
                            usuarioPs.setString(2, u.getSenha());
                            usuarioPs.executeUpdate();
                        }
                    }
                }
            }

            conexao.commit(); // Confirma a transação
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar usuário e login: " + e.getMessage(), e);
        }
    }

    public void cadastrarUsuarioCompleto(String nome, int idade, String genero, String cpf, String email, String senha, String verificarSenha, String login, String senhaUsuario) throws SQLException {
        String sql = "{call sp_addCadastro(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conexao = ConnectionFactory.getConnection();
             CallableStatement stmt = conexao.prepareCall(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, genero);
            stmt.setString(4, cpf);
            stmt.setString(5, email);
            stmt.setString(6, senha);
            stmt.setString(7, verificarSenha);
            stmt.setString(8, login);
            stmt.setString(9, senhaUsuario);

            stmt.execute();
        }
    }
}