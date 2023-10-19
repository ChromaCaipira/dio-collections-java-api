package edu.guilherme.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    // Cria uma nova lista para o carrinho de compras, contendo objetos baseados em Item.java
    private List<Item> carrinhoDeCompras;

    // Construtor para criar uma lista de arrays vazia para esse carrinho de compras
    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String item, double preco, int quantidade) {
        // Adiciona na lista um novo objeto de Item com determinados atributos do método
        carrinhoDeCompras.add(new Item(item, preco, quantidade));
    }
    public void removerItem(String item) {
        List<Item> itensParaRemover = new ArrayList<>();

        // Confere se a lista não está vazia
        if (!carrinhoDeCompras.isEmpty()) {
            // Loop para identificar todos os itens dentro da lista original que possuem mesmo nome dito no método
            for (Item i : carrinhoDeCompras) {
                // Se o nome do item obtido no loop for igual ao nome declarado no método..
                if (i.getNome().equalsIgnoreCase(item)) {
                    // ..será adicionado para a lista de itens para remoção
                    itensParaRemover.add(i);
                }
            }
            
            // Checa se há itens para remover, antes de efetuar a remoção
            if (!itensParaRemover.isEmpty()) {
                // Remove todas os itens da lista com mesmo nome, obtidos no loop
                carrinhoDeCompras.removeAll(itensParaRemover);
            } else {
                // Caso não haja itens para remoção, o item inserido não existe no carrinho
                System.out.println("[ERRO -- Item inserido inexistente]");
            }
        } else {
            System.out.println("[ERRO -- Lista Vazia!]");
        }
    }
    public void calcularValorTotal() {
        double valorTotal = 0d;
        int quantidadeTotal = 0;

        // Confere se a lista não está vazia
        if (!carrinhoDeCompras.isEmpty()) {
            for (Item i : carrinhoDeCompras) {
                // Adiciona ao valor total o preço de cada item multiplicado por sua quantidade
                valorTotal += i.getPreco() * i.getQuantidade();
                quantidadeTotal += i.getQuantidade();
            }   
        } else {
            System.out.println("[ERRO -- Lista Vazia!]");
        }

        System.out.println("[Valor Total]: " + valorTotal);
        System.out.println("[Quantidade de Itens]: " + quantidadeTotal);
    }
    public void exibirItens() {
        if (!carrinhoDeCompras.isEmpty()) {
            System.out.println(carrinhoDeCompras);
        } else {
            System.out.println("[ERRO -- Lista Vazia!]");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // TÍTULO DA APLICAÇÃO
        System.out.println("{CARRINHO DE COMPRAS}\n");
        
        carrinhoDeCompras.adicionarItem("Biscoito Maizena", 6.69, 3);
        carrinhoDeCompras.adicionarItem("Biscoito Recheado", 4.49, 5);
        carrinhoDeCompras.adicionarItem("Monster Energy", 8.82, 1);

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();

        System.out.println("==================================================\n");

        carrinhoDeCompras.removerItem("Biscoito Recheado");
        carrinhoDeCompras.adicionarItem("Salgadinho Cheetos Bola", 3.60, 2);

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();

        System.out.println("==================================================\n");

        carrinhoDeCompras.removerItem("Biscoito Maizena");
        carrinhoDeCompras.removerItem("Monster Energy");

        // Dará ERRO após remover um item que não há na lista
        carrinhoDeCompras.removerItem("Álbum da Copa");

        carrinhoDeCompras.removerItem("Salgadinho Cheetos Bola");
        // Dará ERRO após remover mais itens do que há na lista
        carrinhoDeCompras.removerItem("Salgadinho Cheetos Bola");

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();
    }
}
