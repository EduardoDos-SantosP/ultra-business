package com.ultra.controler;

import java.util.List;
import java.util.function.Supplier;

public class TipoPessoa {
    private final int id;
    private final String nome;

    private TipoPessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static TipoPessoa cliente() {
        return new TipoPessoa(0, "Cliente");
    }

    public static TipoPessoa fornecedor() {
        return new TipoPessoa(1, "Fornecedor");
    }

    public static TipoPessoa funcionario() {
        return new TipoPessoa(2, "Funcionario");
    }

    public void switchCase(Runnable cliente, Runnable fornecedor, Runnable funcionario) {
        List.of(cliente, funcionario, fornecedor).get(id).run();
    }

    public <T> T switchCase(Supplier<T> cliente, Supplier<T> fornecedor, Supplier<T> funcionario) {
        return List.of(cliente, funcionario, fornecedor).get(id).get();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id == ((TipoPessoa) o).id;
    }
}
