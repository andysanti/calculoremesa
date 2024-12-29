package com.reto.interbank.calculoremesa.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InformacionCalculoDtoRequest {

    private String nombres;
    private String apellidos;
    private String dni;
    private Double montoOrigen;
    private String monedaDestino;
    private String monedaOrigen;
}
