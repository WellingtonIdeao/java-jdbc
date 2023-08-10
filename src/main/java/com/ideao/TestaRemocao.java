package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
    public static void main(String[] args) {  
        ConnectionFactory factory = new ConnectionFactory();

        try {  
            Connection connection = factory.getConnection();
            
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM produto WHERE ID > ?");
            stmt.setInt(1, 1);
            stmt.execute();
            
            Integer linhasModificadas = stmt.getUpdateCount();
            System.out.println("Quantidade de linhas foram modificadas "+ linhasModificadas);
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
