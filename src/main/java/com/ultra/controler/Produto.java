/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.controler;

/**
 * @author Prof Luciano Carlos
 */
public class Produto extends Model {

    private String nome;
    private double estoqueMinimo;
    private double qtdEstoque;

    public Produto() {
    }

    public Produto(String nome, double estoqueMinimo, double qtdEstoque, int pk) {
        super(pk);
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto(String nome, double estoqueMinimo, double qtdEstoque) {
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
