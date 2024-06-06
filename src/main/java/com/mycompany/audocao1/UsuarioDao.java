package com.mycompany.audocao1;


import com.mycompany.audocao1.Usuario;
import com.mycompany.audocao1.ConnectionFactory;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcami
 */
public class UsuarioDao {
    //tipo de retorno, nome, lista de parametros, corpo
    public Usuario existe(Usuario u) throws Exception {
 
        var sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        var conexao = new ConnectionFactory().getConnection();

        var ps = conexao.prepareStatement(sql);

        ps.setString(1, u.getLogin());
        ps.setString(2, u.getSenha());

        var rs = ps.executeQuery();

        var usuarioExiste = rs.next();
         if(usuarioExiste){
            var tipo = rs.getInt("tipo");
            u.setTipo(tipo);
        }
        else{
            u = null;
        }
                
        //7. Fechar a conexão
        rs.close();
        ps.close();
        conexao.close();
//        if(usuarioExiste)
//            return true;
//        return false;
//        return usuarioExiste ? true : false;
          return u;
    }
            
    //cláusula catch or declare
    void cadastrar(Usuario u)  throws Exception{
        //1. Especificar o comando SQL (INSERT)
        var sql = "INSERT INTO usuarios(login, senha) VALUES(?, ?)";
        //3. Preparar o comando
        try ( //2. Estabelecer uma conexão com o banco
        var conexao = new ConnectionFactory().getConnection()) {
            //3. Preparar o comando
            var ps = conexao.prepareStatement(sql);
            //4. Substituir os eventuais placeholders
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
//        ps.setInt(3, );
            //5. Executar o comando
            ps.execute();
            //6. Fechar a conexão
            conexao.close();
        }
    }     
}

