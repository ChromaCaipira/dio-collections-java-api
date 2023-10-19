package edu.guilherme.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeroList;

    public OrdenacaoNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeroList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        // Duplicata da lista atributo da classe
        List<Integer> numerosAscendente = new ArrayList<>(this.numeroList);
        // Ordena a lista de forma ascendente/crescente
        Collections.sort(numerosAscendente);
        return numerosAscendente;
    }
    public List<Integer> ordenarDescendente() {
        // Duplicata da lista atributo da classe
        List<Integer> numerosDescendente = new ArrayList<>(this.numeroList);
        // Ordena a lista, porém na forma inversa/descendente/decrescente
        Collections.sort(numerosDescendente, Collections.reverseOrder());
        return numerosDescendente;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(47);
        ordenacaoNumeros.adicionarNumero(286);
        ordenacaoNumeros.adicionarNumero(100);
        ordenacaoNumeros.adicionarNumero(3);

        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
