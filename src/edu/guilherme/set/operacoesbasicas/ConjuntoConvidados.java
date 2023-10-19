package edu.guilherme.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidados;

    public ConjuntoConvidados() {
        this.convidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidados.add(new Convidado(nome, codigoConvite));
    }
    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if (!convidados.isEmpty()) {
            for (Convidado c : convidados) {
                if (c.getCodigoConvite() == codigoConvite) {
                    convidadoParaRemover = c;
                    break;
                }
            }
        }
        convidados.remove(convidadoParaRemover);
    }
    public int contarConvidados() {
        return convidados.size();
    }
    public void exibirConvidados() {
        System.out.println(convidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("[NÚMERO DE CONVIDADOS]: " + conjuntoConvidados.contarConvidados());
        System.out.println("==============================");

        conjuntoConvidados.adicionarConvidado("João", 1234);
        conjuntoConvidados.adicionarConvidado("Maria", 1235);
        conjuntoConvidados.adicionarConvidado("Pedro", 1236);

        // Convidado com código clonado
        conjuntoConvidados.adicionarConvidado("Luisa", 1235);
        
        conjuntoConvidados.exibirConvidados();
        System.out.println("[NÚMERO DE CONVIDADOS]: " + conjuntoConvidados.contarConvidados());
        System.out.println("==============================");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);

        conjuntoConvidados.exibirConvidados();
        System.out.println("[NÚMERO DE CONVIDADOS]: " + conjuntoConvidados.contarConvidados());
    }
}
