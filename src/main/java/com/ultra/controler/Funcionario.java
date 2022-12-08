package com.ultra.controler;

import java.util.ArrayList;
import java.util.Objects;

public class Funcionario extends Pessoa {
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(Cargo cargo, String nome, String cpf, ArrayList<Endereco> enderecos, int pk) {
        super(nome, cpf, enderecos, pk);
        this.cargo = cargo;
    }

    public Funcionario(Cargo cargo, String nome, String cpf, ArrayList<Endereco> enderecos) {
        super(nome, cpf, enderecos);
        this.cargo = cargo;
    }

    public Funcionario(Cargo cargo, String nome, String cpf) {
        super(nome, cpf);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + '}' + super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.cargo);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.cargo, other.cargo);
    }
}
