package com.ideao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    private DataSource dataSource;

    public ConnectionFactory() {
        // pool de
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("dbsql123");
        this.dataSource = comboPooledDataSource;
    }
    
    public Connection getConnection() throws SQLException{
       return this.dataSource.getConnection();
    }
}
