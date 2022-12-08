/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.controler;

public class Endereco extends Model {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private int fk;

    private boolean update = false;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cidade, String estado, String pais, String cep, int pk, int fk) {
        super(pk);
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.fk = fk;
    }

    public Endereco(String logradouro, String bairro, String cidade, String estado, String pais, String cep, int fk) {
        this(logradouro, bairro, cidade, estado, pais, cep, fk, 0);
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        this.update = true;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
        this.update = true;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        this.update = true;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        this.update = true;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
        this.update = true;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
        this.update = true;
    }

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
        this.update = true;
    }

    @Override
    public String toString() {
        return logradouro + "; " + bairro + "; \n" + cidade + "; " + estado;
    }
}
