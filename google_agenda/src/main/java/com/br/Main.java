package com.br;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static int selectOptions() {
        System.out.println("Opções:");
        System.out.println("[1] Exibir todos os lembretes, tarefas e eventos");
        System.out.println("[2] Criar lembrete");
        System.out.println("[3] Criar tarefa");
        System.out.println("[4] Criar evento");
        System.out.println("[5] Editar lembrete");
        System.out.println("[6] Editar tarefa");
        System.out.println("[7] Editar evento");
        System.out.println("[8] Deletar lembrete");
        System.out.println("[9] Deletar tarefa");
        System.out.println("[10] Deletar evento");
        int option = scanInteger("Insira a opção");
        return option;
    }

    public static String scanString(String message) {
        System.out.println(message);
        String string = scan.nextLine();
        return string;
    }

    public static int scanInteger(String message) {
        System.out.println(message);
        Integer integer = scan.nextInt();
        scan.nextLine();
        return integer;
    }

    public static LocalDate scanLocalDate(String message) {
        String string = scanString(message + " [yyyy-mm-dd]");
        return LocalDate.parse(string);
    }

    public static LocalTime scanLocalTime(String message) {
        String string = scanString(message + " [HH:mm]");
        return LocalTime.parse(string);
    }

    public static boolean scanBoolean(String message) {
        String string = scanString(message + " [s/n]");
        return string.equals("s");
    }

    public static Lembrete createLembrete() {
        String titulo = scanString("Insira um titulo:");
        LocalDate data = scanLocalDate("Insira uma data:");
        LocalTime horario = scanLocalTime("Insira um horário:");
        return new Lembrete(titulo, data, horario);
    }

    public static Tarefa createTarefa() {
        Lembrete lembrete = createLembrete();
        boolean repete = scanBoolean("Repete ?");
        Tarefa tarefa = Tarefa.builder()
            .titulo(lembrete.getTitulo())
            .dataInicio(lembrete.getDataInicio())
            .horarioInicio(lembrete.getHorarioInicio())
            .repete(repete)
            .build();
        return tarefa;
    }

    public static Evento createEvento() {
        Lembrete lembrete = createLembrete();
        LocalDate dataFim = scanLocalDate("Insira uma data de fim: ");
        LocalTime horarioFim = scanLocalTime("Insira um horario de fim: ");
        String local = scanString("Insira um local: ");
        Evento evento = Evento.builder()
            .titulo(lembrete.getTitulo())
            .dataInicio(lembrete.getDataInicio())
            .horarioInicio(lembrete.getHorarioInicio())
            .dataFim(dataFim)
            .horarioFim(horarioFim)
            .local(local)
            .build();
        return evento;
    }

    public static void main(String[] args) {

        String username = scanString("Insira um username: ");

        Agenda agenda = Agenda.builder()
            .username(username)
            .lembretes(new ArrayList<>())
            .tarefas(new ArrayList<>())
            .eventos(new ArrayList<>())
            .build();

        int option;
        do {
            option = selectOptions();
            switch (option) {
                case 1:
                    agenda.printLembretes();
                    agenda.printTarefas();
                    agenda.printEventos();
                    break;
                case 2:
                    Lembrete lembrete = createLembrete();
                    agenda.getLembretes().add(lembrete);
                    break;
                case 3:
                    Tarefa tarefa = createTarefa();
                    agenda.getTarefas().add(tarefa);
                    break;
                case 4:
                    Evento evento = createEvento();
                    agenda.getEventos().add(evento);
                    break;
                case 5:
                    if(agenda.getLembretes().size() != 0) {
                        agenda.printLembretes();
                        agenda.getLembretes().set(
                            scanInteger("Insira o index:"),
                            createLembrete()
                    );
                    } else {
                        System.out.println("Sem lembretes");
                    }
                    break;
                case 6:
                    if(agenda.getTarefas().size() != 0) {
                        agenda.printTarefas();
                        agenda.getTarefas().set(
                            scanInteger("Insira o index:"), 
                            createTarefa()
                        );
                    } else {
                        System.out.println("Sem tarefas");
                    }
                    break;
                case 7:
                    if(agenda.getEventos().size() != 0) {
                       agenda.printEventos();
                        agenda.getEventos().set(
                            scanInteger("Insira o index:"),
                            createEvento()
                        ); 
                    } else {
                        System.out.println("Sem eventos");
                    }
                    break;
                case 8:
                    if(agenda.getLembretes().size() != 0) {
                       agenda.printLembretes();
                        agenda.getLembretes().remove(
                            scanInteger("Insira o index")
                        ); 
                    } else {
                        System.out.println("Sem lembretes");
                    }
                    break;
                case 9:
                    if(agenda.getTarefas().size() != 0) {
                       agenda.printTarefas();
                        agenda.getTarefas().remove(
                            scanInteger("Insira o index")
                        ); 
                    } else {
                        System.out.println("Sem tarefas");
                    }
                    break;
                case 10:
                    if(agenda.getEventos().size() != 0) {
                       agenda.printEventos();
                        agenda.getEventos().remove(
                            scanInteger("Insira o index")
                        ); 
                    } else {
                        System.out.println("Sem eventos");
                    }
                    break;
            }
        } while(option != 0);
    }
}