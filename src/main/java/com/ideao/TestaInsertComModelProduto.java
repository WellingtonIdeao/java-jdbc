package com.ideao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ideao.model.Produto;

public class TestaInsertComModelProduto {
    
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda","Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().getConnection()){

            String sql = "INSERT INTO produto(nome, descricao) VALUES (?, ?)";
            
            try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                addProduto(comoda, pstmt);
            }
        }
        System.out.println(comoda);
    }

    private static void addProduto(Produto comoda, PreparedStatement pstmt) throws SQLException {
        pstmt.setString (1, comoda.getNome());
        pstmt.setString(2, comoda.getDescricao());

        pstmt.execute();

        try(ResultSet rst = pstmt.getGeneratedKeys()){
            while(rst.next()){
                comoda.setId(rst.getInt(1));
            }
        }
    }
}
