package com.br;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class Evento extends Lembrete{
    private LocalDate dataFim;
    private LocalTime horarioFim;
    private String local;
}
