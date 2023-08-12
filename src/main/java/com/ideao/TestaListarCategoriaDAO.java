package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ideao.dao.CategoriaDAO;
import com.ideao.factory.ConnectionFactory;
import com.ideao.model.Categoria;

public class TestaListarCategoriaDAO {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            CategoriaDAO  categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();
            listaDeCategorias.stream().forEach(ct -> System.out.println(ct));
        } 
    }
}
