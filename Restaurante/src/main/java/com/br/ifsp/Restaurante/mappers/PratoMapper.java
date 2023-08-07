package com.br.ifsp.Restaurante.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.br.ifsp.Restaurante.dto.PratoResponseDTO;
import com.br.ifsp.Restaurante.model.Prato;

@Mapper(componentModel = "spring")
public interface PratoMapper {
    PratoMapper INSTACE = Mappers.getMapper(PratoMapper.class);

    PratoResponseDTO toResponseDTO(Prato prato);
    Iterable<PratoResponseDTO> toListResponseDTO(Iterable<Prato> pratos);
}
