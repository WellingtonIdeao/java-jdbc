package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ideao.dao.ProdutoDAO;
import com.ideao.model.Produto;

public class TestaListarProdutoDAO {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
        } 
    }
}