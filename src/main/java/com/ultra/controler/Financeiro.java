/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultra.controler;

import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Prof Luciano Carlos
 */
public class Financeiro {
    
    private Date dataEmissao;
    private Date dataVencimento;
    private Date dataBaixa;
    private double valor;
    private String forma;
    
    private int fk;
    private int pk;
    
    private boolean update = false;

    public Financeiro() {
    }

    public Financeiro(Date dataEmissao, Date dataVencimento, Date dataBaixa, double valor, String forma, int fk, int pk) {
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.valor = valor;
        this.forma = forma;
        this.fk = fk;
        this.pk = pk;
    }

    public Financeiro(Date dataEmissao, Date dataVencimento, Date dataBaixa, double valor, String forma, int fk) {
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.valor = valor;
        this.forma = forma;
        this.fk = fk;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
        this.update = true;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
        this.update = true;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
        this.update = true;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        this.update = true;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
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
        return "Financeiro{" + "dataEmissao=" + dataEmissao + ", dataVencimento=" + dataVencimento + ", dataBaixa=" + dataBaixa + ", valor=" + valor + ", forma=" + forma + ", fk=" + fk + ", pk=" + pk + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dataEmissao);
        hash = 97 * hash + Objects.hashCode(this.dataVencimento);
        hash = 97 * hash + Objects.hashCode(this.dataBaixa);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.forma);
        hash = 97 * hash + this.fk;
        hash = 97 * hash + this.pk;
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
        final Financeiro other = (Financeiro) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.fk != other.fk) {
            return false;
        }
        if (this.pk != other.pk) {
            return false;
        }
        if (!Objects.equals(this.forma, other.forma)) {
            return false;
        }
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        return Objects.equals(this.dataBaixa, other.dataBaixa);
    }
    
    
    
}
