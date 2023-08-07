package com.br.ifsp.Restaurante.dto;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseMessage {
    private String message;
    private HttpStatusCode httpStatus;

}
