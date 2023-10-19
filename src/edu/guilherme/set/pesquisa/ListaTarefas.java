package edu.guilherme.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao, false));
    }
    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
        } else {
            System.err.println("ERRO -- Lista vazia!");
        }
        tarefaSet.remove(tarefaParaRemover);
    }
    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }
    public int contarTarefas() {
        return tarefaSet.size();
    }
    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcuidas = new HashSet<>();
        for (Tarefa t : tarefaSet) {
            // Adiciona a tarefa à lista de concluídas, caso seu atributo booleano de conclusão dê verdadeiro
            if (t.getConcluida() == true) {
                tarefasConcuidas.add(t);
            }
        }
        return tarefasConcuidas;
    }
    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : tarefaSet) {
            // Adiciona a tarefa à lista de pendentes, caso seu atributo booleano de conclusão dê falso
            if (t.getConcluida() == false) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }
    public void marcarTarefaConcluida(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                }
            }
        } else {
            System.err.println("ERRO -- Lista vazia!");
        }
    }
    public void marcarTarefaPendente(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                }
            }
        } else {
            System.err.println("ERRO -- Lista vazia!");
        }
    }
    public void limparListaTarefas() {
        Set<Tarefa> tarefas = new HashSet<>(tarefaSet);
        tarefaSet.removeAll(tarefas);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        System.out.println("{LISTA DE TAREFAS}\n");

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        // Se a descrição é a mesma, não será adicionado
        listaTarefas.adicionarTarefa("Tarefa 2");

        listaTarefas.marcarTarefaConcluida("Tarefa 1");

        listaTarefas.exibirTarefas();
        System.out.println("[NÚMERO DE TAREFAS]: " + listaTarefas.contarTarefas());
        System.out.println("[TAREFAS CONCLUÍDAS]: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("[TAREFAS PENDENTES]: " + listaTarefas.obterTarefasPendentes());
        System.out.println("====================================");

        listaTarefas.marcarTarefaPendente("Tarefa 1");
        listaTarefas.removerTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 4");
        listaTarefas.adicionarTarefa("Tarefa 5");

        listaTarefas.exibirTarefas();
        System.out.println("[NÚMERO DE TAREFAS]: " + listaTarefas.contarTarefas());
        System.out.println("[TAREFAS CONCLUÍDAS]: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("[TAREFAS PENDENTES]: " + listaTarefas.obterTarefasPendentes());
        System.out.println("====================================");

        listaTarefas.limparListaTarefas();
        listaTarefas.removerTarefa("Tarefa 4");

        listaTarefas.exibirTarefas();
        System.out.println("[NÚMERO DE TAREFAS]: " + listaTarefas.contarTarefas());
        System.out.println("[TAREFAS CONCLUÍDAS]: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("[TAREFAS PENDENTES]: " + listaTarefas.obterTarefasPendentes());
    }
}
