package com.ideao.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Produto> produtos;

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Categoria [" + this.nome + "]";
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

   

   

    
}
