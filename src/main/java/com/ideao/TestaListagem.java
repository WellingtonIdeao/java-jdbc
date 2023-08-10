package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

          try {
            Connection connection = factory.getConnection();
            
            PreparedStatement stmt = connection.prepareStatement("SELECT id, nome, descricao FROM produto");
            boolean isQuery = stmt.execute();
            System.out.println(isQuery);

            ResultSet rst = stmt.getResultSet();
            
            while (rst.next()) {
                // Integer id = rst.getInt(1);
                Integer id = rst.getInt("id");
                System.out.println(id);
                
                String nome = rst.getString("nome");
                System.out.println(nome);
                
                String descricao = rst.getString("descricao");
                System.out.println(descricao);
            }   
            connection.close(); 
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }
}
