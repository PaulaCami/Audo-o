package com.mycompany.audocao1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcami
 */
public class Usuario {
    private int codigo;
    private String login;
    private String senha;
    
    //construtor padrão
    Usuario(){}
    
    Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin(){
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login){
        this.login=login;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

