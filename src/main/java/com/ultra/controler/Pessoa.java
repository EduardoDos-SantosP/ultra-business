package com.ultra.controler;

import java.util.ArrayList;

public class Pessoa extends Model {
    private String nome;
    private String cpf;
    private ArrayList<Endereco> enderecos;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, ArrayList<Endereco> enderecos, int pk) {
        super(pk);
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = enderecos;
    }

    public Pessoa(String nome, String cpf, ArrayList<Endereco> enderecos) {
        this(nome, cpf, enderecos, 0);
    }

    public Pessoa(String nome, String cpf) {
        this(nome, cpf, null, 0);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Endereco> getEnderecos() {

        if (this.enderecos == null) {
            this.enderecos = new ArrayList<>();
        }

        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
