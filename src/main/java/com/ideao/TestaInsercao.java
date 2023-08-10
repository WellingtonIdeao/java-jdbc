package com.ideao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        
        try {
            Connection connection = factory.getConnection();
            
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO produto (NOME, descricao) VALUES ('TV', 'TV LG')",
            Statement.RETURN_GENERATED_KEYS);

            ResultSet rst = stmt.getGeneratedKeys();

            while(rst.next()){
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: "+id);
                
            }
            rst.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
