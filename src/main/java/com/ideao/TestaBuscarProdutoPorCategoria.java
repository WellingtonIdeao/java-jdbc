package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ideao.dao.CategoriaDAO;
import com.ideao.factory.ConnectionFactory;
import com.ideao.model.Categoria;
import com.ideao.model.Produto;

public class TestaBuscarProdutoPorCategoria {
  public static void main(String[] args) throws SQLException {
    try (Connection connection = new ConnectionFactory().getConnection()) {
        CategoriaDAO  categoriaDAO = new CategoriaDAO(connection);
        List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
        listaDeCategorias.stream().forEach(ct -> {
            System.out.println(ct);
              for (Produto produto : ct.getProdutos()) {
                  System.out.println(ct.getNome() + " - " + produto.getNome());
              }
        });
    } 
  }  
}
