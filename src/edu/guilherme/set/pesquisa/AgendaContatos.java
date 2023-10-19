package edu.guilherme.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }
    public void exibirContatos() {
        System.out.println(contatoSet);
    }
    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            // Checa se o nome do contato COMEÇA com o nome inserido, não necessariamente o mesmo nome
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }
    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
        } else {
            System.err.println("[ERRO -- Agenda vazia!]");
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        System.out.println("{AGENDA DE CONTATOS}");
        
        agendaContatos.adicionarContato("Guilherme", 123456);
        // A duplicata não será adicionada, conforme os métodos equals e hashCode
        agendaContatos.adicionarContato("Guilherme", 555555);

        agendaContatos.adicionarContato("Guilherme da Silva", 333333333);
        agendaContatos.adicionarContato("Gabriel", 7654321);
        agendaContatos.adicionarContato("José", 8888);

        agendaContatos.exibirContatos();
        System.out.println("======================");

        System.out.println("[PESQUISA POR: 'GUILHERME']");
        System.out.println(agendaContatos.pesquisarPorNome("Guilherme"));
        System.out.println("======================");

        System.out.println("[CONTATO ATUALIZADO!]: " + 
            agendaContatos.atualizarNumeroContato("José", 8181));

        agendaContatos.exibirContatos();
    }
}
