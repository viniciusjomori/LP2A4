package com.br.ifsp.Restaurante.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Prato {
    private int id;
    private String nome;
    private float preco;

    @Getter
    private static int qntTotal = 0;

    public static void QntTotal_plus1() {
        qntTotal++;
    }
}
