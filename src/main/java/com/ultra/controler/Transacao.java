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
public class Transacao {

    private Pessoa proprietario;//cliente ou fornecedor
    private int numero;
    private Date data;
    private ArrayList<TransacaoItem> itens = new ArrayList<>();
    private ArrayList<Financeiro> financerio;
    
    private int pk;

    public Transacao() {
    }

    public Transacao(Pessoa proprietario, int numero, Date data, ArrayList<TransacaoItem> itens, ArrayList<Financeiro> financerio, int pk) {
        this.proprietario = proprietario;
        this.numero = numero;
        this.data = data;
        this.itens = itens;
        this.financerio = financerio;
        this.pk = pk;
    }

    public Transacao(Pessoa proprietario, int numero, Date data, ArrayList<TransacaoItem> itens, ArrayList<Financeiro> financerio) {
        this.proprietario = proprietario;
        this.numero = numero;
        this.data = data;
        this.itens = itens;
        this.financerio = financerio;
    }

    public Transacao(Pessoa proprietario, int numero, Date data) {
        this.proprietario = proprietario;
        this.numero = numero;
        this.data = data;
    }
    /**
     * Varre o vetor de itens e retorna o valor total dessa transacao
     * @return 
     */
    public double calculeValorTotal(){
        return 0;
    }
    /**
     * varre o vetor de financeiro e retorna o valor total conciliado
     * @return 
     */
    public double calculeFinanceiroTotal(){
        return 0;
    }
    /**
     * retorna verdadeiro se o valor total for igual ao financeiro total
     * @return 
     */
    public boolean isMatch(){
        return calculeValorTotal()==calculeFinanceiroTotal();
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<TransacaoItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<TransacaoItem> itens) {
        this.itens = itens;
    }

    public ArrayList<Financeiro> getFinancerio() {
        if (this.financerio == null){
            this.financerio = new ArrayList<>();
        }
        return financerio;
    }

    public void setFinancerio(ArrayList<Financeiro> financerio) {
        this.financerio = financerio;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "Transacao{" + "proprietario=" + proprietario + ", numero=" + numero + ", data=" + data + ", itens=" + itens + ", financerio=" + financerio + ", pk=" + pk + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.proprietario);
        hash = 47 * hash + this.numero;
        hash = 47 * hash + Objects.hashCode(this.data);
        hash = 47 * hash + Objects.hashCode(this.itens);
        hash = 47 * hash + Objects.hashCode(this.financerio);
        hash = 47 * hash + this.pk;
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
        final Transacao other = (Transacao) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.pk != other.pk) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return Objects.equals(this.financerio, other.financerio);
    }
    
    
    


    
    
    
    
    
}
