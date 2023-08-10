package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        // String nome = "Mouse'";
        // String descricao = "Mouse sem fio);delete from produto"; // prova que não injeta instruções SQL( SQL Injection)

        try (Connection connection = factory.getConnection()) {
            connection.setAutoCommit(false);
     
            try(PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO produto (NOME, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                
                addVariable("SmartTV", "45 polegadas", stmt);
                addVariable("Radio", "Radio a bateria", stmt);
                
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Rollback executado");
            }
        }    
    }

    private static void addVariable(String nome, String descricao, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, nome);
        stmt.setString(2, descricao);
        // if(nome.equals("Radio")){
        //     throw new RuntimeException("Não foi possivel adicionar o produto");
        // }
        
        stmt.execute();

        try (ResultSet rst = stmt.getGeneratedKeys()) {
            while(rst.next()){
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: "+id);     
            }   
        }
    }
}
