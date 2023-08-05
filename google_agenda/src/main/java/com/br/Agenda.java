package com.br;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Agenda {
    private String username;
    private List<Lembrete> lembretes;
    private List<Tarefa> tarefas;
    private List<Evento> eventos;

    public void printLembretes() {
        System.out.println("Lembretes: ");
        int index = 0;
        for(Lembrete lembrete : lembretes) {
            System.out.println("[" + index + "] " + lembrete.toString());
            index++;
        }
        System.out.println("");
    }

    public void printTarefas() {
        System.out.println("Tarefas: ");
        int index = 0;
        for(Tarefa tarefa : tarefas) {
            System.out.println("[" + index + "] " + tarefa.toString());
            index++;
        }
        System.out.println("");
    } 

    public void printEventos() {
        System.out.println("Eventos: ");
        int index = 0;
        for(Evento evento : eventos) {
            System.out.println("[" + index + "] " + evento.toString());
            index++;
        }
        System.out.println("");
    }

}
