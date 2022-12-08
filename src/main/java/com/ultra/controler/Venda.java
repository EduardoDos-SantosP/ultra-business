/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.controler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Prof Luciano Carlos
 */
public class Venda extends Transacao{
    private Funcionario vendedor;

    public Venda() {
    }

    public Venda(Funcionario vendedor, Pessoa proprietario, int numero, Date data, ArrayList<TransacaoItem> itens, ArrayList<Financeiro> financerio, int pk) {
        super(proprietario, numero, data, itens, financerio, pk);
        this.vendedor = vendedor;
    }

    public Venda(Funcionario vendedor, Pessoa proprietario, int numero, Date data, ArrayList<TransacaoItem> itens, ArrayList<Financeiro> financerio) {
        super(proprietario, numero, data, itens, financerio);
        this.vendedor = vendedor;
    }

    public Venda(Funcionario vendedor, Pessoa proprietario, int numero, Date data) {
        super(proprietario, numero, data);
        this.vendedor = vendedor;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venda{" + "vendedor=" + vendedor + '}' + super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.vendedor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        return Objects.equals(this.vendedor, other.vendedor);
    }
    
    
}
