package edu.guilherme.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }
    public void removerPalavra(String palavra) {
        if (!palavrasUnicas.isEmpty()) {
            // contains() checa se há um elemento dentro do conjunto igual ao inserido
            if (palavrasUnicas.contains(palavra)) {
                palavrasUnicas.remove(palavra);
            } else {
                System.out.println("[ERRO -- Palavra inexistente!]");
            }
        } else {
            System.out.println("[ERRO -- Conjunto vazio!]");
        }
    }
    public boolean verificarPalavra(String palavra) {
        return palavrasUnicas.contains(palavra);
    }
    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Batata");
        conjuntoPalavrasUnicas.adicionarPalavra("Pão");
        conjuntoPalavrasUnicas.adicionarPalavra("Pneu");

        // A palavra inserida não está no conjunto, logo retornará como inexistente
        conjuntoPalavrasUnicas.removerPalavra("Queimado");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println("[CONTÉM 'Batata']: " + conjuntoPalavrasUnicas.verificarPalavra("Batata"));
        System.out.println("==============================");

        conjuntoPalavrasUnicas.removerPalavra("Pão");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // A palavra já não está mais presente no conjunto, logo não será encontrada
        System.out.println("[CONTÉM 'Pão']: " + conjuntoPalavrasUnicas.verificarPalavra("Pão"));
    }
}
