package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        String nome = "Mouse'";
        String descricao = "Mouse sem fio);delete from produto"; // prova que não injeta instruções SQL( SQL Injection)

        try {
            Connection connection = factory.getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO produto (NOME, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            
            stmt.execute();

            ResultSet rst = stmt.getGeneratedKeys();

            while(rst.next()){
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: "+id);
                
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
