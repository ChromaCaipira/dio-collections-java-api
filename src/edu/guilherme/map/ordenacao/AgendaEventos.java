package edu.guilherme.map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    // Usamos LocalDate pela sua facilidade, extendendo Comparable que organizará o TreeMap de exibirAgenda()
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }
    public void exibirAgenda() {
        // TreeMap organizará a lista em ordem crescente, a partir do LocalDate/data dos eventos
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }
    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);

        // Checa cada evento, na lista ordenada por data, até encontrar o primeiro evento mais próximo
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            // Se a chave da data do entry for igual ou após a data atual, será o próximo evento a ocorrer
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                // Ambos getKey() e getValue() poderiam ter sido inseridos diretamente no "sysout"..
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                // ..isso é apenas uma prática para facilitar a visualização e entendimento do código
                System.out.println("[PRÓXIMO EVENTO]: " + proximoEvento);
                System.out.println("[DATA DO PRÓXIMO EVENTO]: " + proximaData);
                break; // Quebra quando encontra o primeiro próximo evento
            }   
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 4), "Quatro de Julho", "Queima de Fogos nos USA");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 18), "Rec'n'Play", "Abertura do evento Rec'n'Play em Recife");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 20), "Rec'n'Play", "Arena Geek REC 'n' Play - Dia 3");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 21), "Rec'n'Play", "Arena Geek REC 'n' Play - Dia 4");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
