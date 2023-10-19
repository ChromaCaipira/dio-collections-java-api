package edu.guilherme.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeroList;

    public SomaNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeroList.add(numero);
    }
    public int calcularSoma() {
        int soma = 0;
        // Checa se a lista não está vazia
        if (!numeroList.isEmpty()) {
            // Para cada número na lista, soma-o ao resultado de soma atual
            for (Integer numero : numeroList) {
                soma += numero;
            }
        }
        return soma;
    }
    public int encontrarMaiorNumero() {
        // Começa pelo menor inteiro possível
        int maiorNumero = Integer.MIN_VALUE;
        // Checa se a lista não está vazia
        if (!numeroList.isEmpty()) {
            for (Integer numero : numeroList) {
                // Se o número encontrado na lista for maior que o maior número atual..
                if (numero >= maiorNumero) {
                    // ..o novo maior número será igual ao maior número que foi encontrado
                    maiorNumero = numero;
                }
            }
        }
        return maiorNumero;
    }
    public int encontrarMenorNumero() {
        // Começa pelo maior inteiro possível
        int menorNumero = Integer.MAX_VALUE;
        // Checa se a lista não está vazia
        if (!numeroList.isEmpty()) {
            for (Integer numero : numeroList) {
                // Se o número encontrado na lista for menor que o menor número atual..
                if (numero <= menorNumero) {
                    // ..o novo menor número será igual ao menor número que foi encontrado
                    menorNumero = numero;
                }
            }
        }
        return menorNumero;
    }
    public List<Integer> exibirNumeros() {
        return numeroList;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(47);
        somaNumeros.adicionarNumero(286);
        somaNumeros.adicionarNumero(100);
        somaNumeros.adicionarNumero(3);

        System.out.println(somaNumeros.exibirNumeros());
        System.out.println("[SOMA DOS NÚMEROS]: " + somaNumeros.calcularSoma());
        System.out.println("[MAIOR NÚMERO]: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("[MENOR NÚMERO]: " + somaNumeros.encontrarMenorNumero());
    }
}
