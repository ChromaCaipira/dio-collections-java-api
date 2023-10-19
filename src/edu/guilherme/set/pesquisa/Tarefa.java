package edu.guilherme.set.pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao, boolean concluida) {
        this.descricao = descricao;
        this.concluida = concluida;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao());
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public boolean getConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
