package com.ideao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ideao.model.Categoria;


public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List <Categoria> listar() throws SQLException {
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
}
