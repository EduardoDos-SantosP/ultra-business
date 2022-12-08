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
public class Log {
    
    private String usuario;
    private String opr;
    private String tabela;
    private String descricao;
    private Date data;
    
    private int pk;

    public Log() {
    }

    public Log(String usuario, String opr, String tabela, String descricao, Date data, int pk) {
        this.usuario = usuario;
        this.opr = opr;
        this.tabela = tabela;
        this.descricao = descricao;
        this.data = data;
        this.pk = pk;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.usuario);
        hash = 29 * hash + Objects.hashCode(this.opr);
        hash = 29 * hash + Objects.hashCode(this.tabela);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.data);
        hash = 29 * hash + this.pk;
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
        final Log other = (Log) obj;
        if (this.pk != other.pk) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.opr, other.opr)) {
            return false;
        }
        if (!Objects.equals(this.tabela, other.tabela)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Log{" + "usuario=" + usuario + ", opr=" + opr + ", tabela=" + tabela + ", descricao=" + descricao + ", data=" + data + ", pk=" + pk + '}';
    }
}
