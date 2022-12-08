/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.controler;

import java.util.Objects;

/**
 *
 * @author Prof Luciano Carlos
 */
public class TransacaoItem {
    
    private Produto produto;
    private double qtd;
    private double valorUnitario;

    private int fk;//compra ou venda    
    private int pk;
    
    private boolean update = false;

    public TransacaoItem() {
    }

    public TransacaoItem(Produto produto, double qtd, double valorUnitario, int fk, int pk) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.fk = fk;
        this.pk = pk;
    }

    public TransacaoItem(Produto produto, double qtd, double valorUnitario, int fk) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.fk = fk;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.update = true;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
        this.update = true;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
        this.update = true;
    }

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
        this.update = true;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
        this.update = true;
    }

    @Override
    public String toString() {
        return "TrasacaoItem{" + "produto=" + produto + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", fk=" + fk + ", pk=" + pk + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.qtd) ^ (Double.doubleToLongBits(this.qtd) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.valorUnitario) ^ (Double.doubleToLongBits(this.valorUnitario) >>> 32));
        hash = 23 * hash + this.fk;
        hash = 23 * hash + this.pk;
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
        final TransacaoItem other = (TransacaoItem) obj;
        if (Double.doubleToLongBits(this.qtd) != Double.doubleToLongBits(other.qtd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorUnitario) != Double.doubleToLongBits(other.valorUnitario)) {
            return false;
        }
        if (this.fk != other.fk) {
            return false;
        }
        if (this.pk != other.pk) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }
    
        

    
}
