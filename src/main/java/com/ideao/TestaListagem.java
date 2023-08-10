package com.ideao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

          try {
            Connection connection = factory.getConnection();
            
            Statement stmt = connection.createStatement();
            boolean isQuery = stmt.execute("SELECT id, nome, descricao FROM produto");
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
