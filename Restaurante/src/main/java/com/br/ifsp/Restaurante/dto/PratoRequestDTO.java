package com.br.ifsp.Restaurante.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PratoRequestDTO(
    @NotBlank String nome,
    @NotNull Float preco
) {
    
}
