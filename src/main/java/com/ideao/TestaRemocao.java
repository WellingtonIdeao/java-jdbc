package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ideao.factory.ConnectionFactory;

public class TestaRemocao {
    public static void main(String[] args) {  
        ConnectionFactory factory = new ConnectionFactory();

        try (
            Connection connection = factory.getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM produto WHERE ID > ?")
            ){
            stmt.setInt(1, 1);
            stmt.execute();
            
            Integer linhasModificadas = stmt.getUpdateCount();
            System.out.println("Quantidade de linhas foram modificadas "+ linhasModificadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
