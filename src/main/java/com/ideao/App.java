package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ideao.factory.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        ConnectionFactory factory = new ConnectionFactory();
        
        try {
            Connection connection = factory.getConnection();
            System.out.println("Fechando a conexão");
            connection.close(); 
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }
}
