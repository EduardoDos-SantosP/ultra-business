package com.ultra.controler;

public class Cargo extends Model {
    private String nome;
    private String descricao;

    public Cargo() {
    }

    public Cargo(String nome, String descricao, int pk) {
        super(pk);
        this.nome = nome;
        this.descricao = descricao;
    }

    public Cargo(String nome, String descricao) {
        this(nome, descricao, 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
