package com.ideao.model;

public class Categoria {
    private Integer id;
    private String nome;

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    

    
}
