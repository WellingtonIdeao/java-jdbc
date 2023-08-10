package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) {  
        ConnectionFactory factory = new ConnectionFactory();

        try {  
            Connection connection = factory.getConnection();
            
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM produto WHERE ID > 1");
            
            Integer linhasModificadas = stmt.getUpdateCount();
            System.out.println("Quantidade de linhas foram modificadas "+ linhasModificadas);
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
