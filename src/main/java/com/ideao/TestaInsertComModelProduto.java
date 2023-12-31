package com.ideao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ideao.dao.ProdutoDAO;
import com.ideao.factory.ConnectionFactory;
import com.ideao.model.Produto;

public class TestaInsertComModelProduto {
    
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Geladeira","Geladeira Azul");

        try(Connection connection = new ConnectionFactory().getConnection()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
        }
        System.out.println(comoda);
    }
}
