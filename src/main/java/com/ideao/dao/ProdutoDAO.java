package com.ideao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ideao.model.Categoria;
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

    public List<Produto> listar() throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, descricao FROM produto";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.execute();

            try (ResultSet rst = pstmt.getResultSet()) {
                while(rst.next()){
                    produtos.add(new Produto(rst.getInt(1), rst.getString(2), rst.getString(3)));
                }
            }
        } 
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, descricao FROM produto WHERE categoria_id = ?";
        System.out.println("Executando a query de buscar produto por categoria");
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, ct.getId());
            pstmt.execute();

            try (ResultSet rst = pstmt.getResultSet()) {
                while(rst.next()){
                    produtos.add(new Produto(rst.getInt(1), rst.getString(2), rst.getString(3)));
                }
            }
        } 
        return produtos;
    }
}
