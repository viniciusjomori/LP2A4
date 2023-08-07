package com.br.ifsp.Restaurante.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.br.ifsp.Restaurante.dto.PratoRequestDTO;
import com.br.ifsp.Restaurante.model.Prato;

@Service
public class PratoService {
    private List<Prato> pratos = new ArrayList<>();

    public Iterable<Prato> findAll() {
        return Collections.unmodifiableCollection(pratos);
    }

    public Prato createPrato(PratoRequestDTO dto) {
        Prato.QntTotal_plus1();
        Prato prato = Prato.builder()
            .id(Prato.getQntTotal())
            .nome(dto.nome())
            .preco(dto.preco())
            .build();
        pratos.add(prato);
        return prato;
    }

    public Prato findById(int id) {
        for(Prato prato : pratos) {
            if(prato.getId() == id) {
                return prato;
            }
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Prato não encontrado"
        );
    }

    public Prato editPrato(PratoRequestDTO dto, int id) {
        Prato prato = findById(id);
        BeanUtils.copyProperties(dto, prato);
        int index = pratos.indexOf(prato);
        pratos.set(index, prato);
        return prato;
    }

    public void deleteById(int id) {
        Prato prato = findById(id);
        if(pratos.contains(prato)) {
            pratos.remove(prato);
        }
    }
}
