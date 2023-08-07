package com.br.ifsp.Restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifsp.Restaurante.dto.PratoRequestDTO;
import com.br.ifsp.Restaurante.dto.PratoResponseDTO;
import com.br.ifsp.Restaurante.dto.ResponseMessage;
import com.br.ifsp.Restaurante.mappers.PratoMapper;
import com.br.ifsp.Restaurante.model.Prato;
import com.br.ifsp.Restaurante.service.PratoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("prato")
public class PratoController {

    @Autowired
    private PratoService service;

    @Autowired
    private ResponseMessage responseMessage;

    @Autowired
    private PratoMapper mapper;

    @GetMapping
    public ResponseEntity<Iterable<PratoResponseDTO>> findAll() {
        Iterable<Prato> pratos = service.findAll();
        return ResponseEntity.ok(mapper.toListResponseDTO(pratos));
    }

    @GetMapping("{id}")
    public ResponseEntity<PratoResponseDTO> findById(@PathVariable int id) {
        Prato prato = service.findById(id);
        return ResponseEntity.ok(mapper.toResponseDTO(prato));
    }

    @PostMapping
    public ResponseEntity<PratoResponseDTO> createPrato(@RequestBody @Valid PratoRequestDTO request) {
        Prato prato = service.createPrato(request);
        return ResponseEntity.ok(mapper.toResponseDTO(prato));
    }

    @PutMapping("{id}")
    public ResponseEntity<PratoResponseDTO> editPrato(@RequestBody @Valid PratoRequestDTO request, @PathVariable int id) {
        Prato prato = service.editPrato(request, id);
        return ResponseEntity.ok(mapper.toResponseDTO(prato));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseMessage> editPrato(@PathVariable int id) {
        service.deleteById(id);
        responseMessage.setMessage("Deletado com sucesso");
        responseMessage.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.ok(responseMessage);
    }
}
