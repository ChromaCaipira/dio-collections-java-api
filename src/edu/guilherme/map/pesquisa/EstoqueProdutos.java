package edu.guilherme.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(codigo, new Produto(nome, preco, quantidade));
    }
    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }
    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            // Método values() retorna uma coleção do tipo Produto, com os valores nesse Map
            for (Produto p : estoqueProdutosMap.values()) {
                // Multiplica o preço do produto à sua quantidade
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() < menorPreco) {
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotal = null;
        double maiorPrecoQuantidade = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco()*p.getQuantidade() > maiorPrecoQuantidade) {
                    produtoMaiorQuantidadeValorTotal = p;
                    maiorPrecoQuantidade = p.getPreco()*p.getQuantidade();
                }                
            }
        }
        return produtoMaiorQuantidadeValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoqueProdutos.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoqueProdutos.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoqueProdutos.adicionarProduto(4L, "Teclado", 2, 40.0);

        estoqueProdutos.exibirProdutos();

        System.out.println("[VALOR TOTAL DO ESTOQUE]: " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("[PRODUTO MAIS CARO]: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("[PRODUTO MAIS BARATO]: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("[PRODUTO DE MAIOR VALOR E QUANTIDADE]: " +
            estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println("===============================");
    }
}
