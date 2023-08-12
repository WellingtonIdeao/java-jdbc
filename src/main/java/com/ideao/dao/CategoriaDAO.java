package com.ideao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ideao.model.Categoria;
import com.ideao.model.Produto;


public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List <Categoria> listar() throws SQLException {
        System.out.println("Executando a query de listar categoria");

        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nome FROM categoria";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.execute();
            
            try (ResultSet rst = pstmt.getResultSet()) {
                while(rst.next()){
                    categorias.add(new Categoria(rst.getInt(1), rst.getString(2)));
                }
            } 
        } 
        return categorias;
    }

    public List <Categoria> listarComProdutos() throws SQLException {
        System.out.println("Executando a query listar categoria com produtos");

        Categoria ultima = null;
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT C.id, C.nome, P.id, P.nome, P.descricao FROM categoria C INNER JOIN"
        + " produto P ON C.id = P.categoria_id";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.execute();
            
            try (ResultSet rst = pstmt.getResultSet()) {
                while(rst.next()){
                    //se é é a primeiro loop no laço OU nome tem que ser dierente do nome anterior no laço - evita duplicação de registros 
                    if(ultima == null || !ultima.getNome().equals(rst.getString(2))){ 
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    ultima.add(new Produto(rst.getInt(3), rst.getString(4), rst.getString(5)));
                }
            } 
        } 
        return categorias;
    }
}
