package com.ideao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ideao.model.Produto;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException{
        String sql = "INSERT INTO produto(nome, descricao) VALUES (?, ?)";
            
        try(PreparedStatement pstmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString (1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());

            pstmt.execute();

            try(ResultSet rst = pstmt.getGeneratedKeys()){
                while(rst.next()){
                    produto.setId(rst.getInt(1));
                }
            }    
        }
    }
}
