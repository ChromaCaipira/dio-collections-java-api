package edu.guilherme.set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private long codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(long codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto p) {
        // Compara se o nome do produto consultado, em ordem alfabética, é maior ou menor na ordem do que o atual
        return nome.compareToIgnoreCase(p.getNome());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public String toString() {
        return '{' +
            "codigo=" + codigo +
            ", nome='" + nome + '\'' +
            ", preço=" + preco +
            ", quantidade=" + quantidade +
            '}';
    }

    public long getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
}

class ComparatorPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        // Faz comparação de preço entre dois produtos, retornando um double
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
    
}
