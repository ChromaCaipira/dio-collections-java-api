package edu.guilherme.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtos.add(new Produto(codigo, nome, preco, quantidade));
    }
    public Set<Produto> exibirProdutosPorNome() {
        // Dessa vez, utiliza-se o TreeSet para organizar o conjunto em determinada ordem
        Set<Produto> produtosPorNome = new TreeSet<>(produtos);
        return produtosPorNome;
    }
    public Set<Produto> exibirProdutosPorPreco() {
        // Esse TreeSet utiliza do Comparator criado para saber a forma que deverá organizar esse conjunto
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        // Adiciona todos os produtos desordenados nesse TreeSet organizado
        produtosPorPreco.addAll(produtos);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Mouse Razer", 150.4, 3);
        cadastroProdutos.adicionarProduto(2L, "Teclado Razer", 309.00, 2);
        cadastroProdutos.adicionarProduto(1L, "Monitor Ultrawide 4K", 1840.90, 1);
        cadastroProdutos.adicionarProduto(4L, "Monitor 144Hz", 854.09, 2);

        System.out.println("[PRODUTOS POR NOME]:\n" + cadastroProdutos.exibirProdutosPorNome());
        System.out.println("--------------------------");
        System.out.println("[PRODUTOS POR PREÇO]:\n" + cadastroProdutos.exibirProdutosPorPreco());
    }
}
