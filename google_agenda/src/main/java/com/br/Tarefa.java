package com.br;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@AllArgsConstructor
@SuperBuilder
public class Tarefa extends Lembrete{

    private boolean repete;

}
