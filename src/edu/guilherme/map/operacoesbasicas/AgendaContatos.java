package edu.guilherme.map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        // Método put() serve tanto para adicionar quanto para atualizar, ou seja, substitui um já existente
        agendaContatoMap.put(nome, telefone);
    }
    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }
    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }
    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        System.out.println("{AGENDA DE CONTATOS}");
        
        agendaContatos.adicionarContato("Guilherme", 123456);
        // A duplicata substituirá o número da anterior, conforme os métodos equals e hashCode
        agendaContatos.adicionarContato("Guilherme", 555555);

        agendaContatos.adicionarContato("Guilherme da Silva", 333333333);
        agendaContatos.adicionarContato("Gabriel", 7654321);
        agendaContatos.adicionarContato("José", 8888);

        agendaContatos.exibirContatos();
        System.out.println("======================");

        System.out.println("[PESQUISA POR: 'GUILHERME']");
        System.out.println(agendaContatos.pesquisarPorNome("Guilherme"));

        System.out.println("======================");

        agendaContatos.removerContato("Gabriel");
        agendaContatos.exibirContatos();
    }
}
