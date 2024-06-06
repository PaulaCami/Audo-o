/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.audocao1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pcami
 */
public class EventoDAO {
    List<Evento> listar() throws Exception {
        
        var eventos = new ArrayList<Evento>();
        
        var sql = "SELECT * FROM eventos";
        
        try (
                var conexao = new ConnectionFactory().getConnection(); 
                 var ps = conexao.prepareStatement(sql); 
                
                 var rs = ps.executeQuery();) {
            while (rs.next()) {
                
                var codigo = rs.getInt("cod_evento");
                var nome = rs.getString("nome");
                var descricao = rs.getString("descricao");
                java.util.Date dataInicio = rs.getDate("data_inicio");
                java.util.Date dataFim = rs.getDate("data_fim");
                var evento = new Evento();
                evento.setCodigo(codigo);
                evento.setNome(nome);
                evento.setDescricao(descricao);
                evento.setDataInicio(dataInicio);
                evento.setDataFim(dataFim);
                eventos.add(evento);
            }
            
            return eventos;
        }
    }
    public static void main(String[] args) throws Exception{
        var eventoDAO = new EventoDAO();
        var eventos = eventoDAO.listar();
        for (Evento e : eventos){
            System.out.println(e);
                    
        }
    }
}
