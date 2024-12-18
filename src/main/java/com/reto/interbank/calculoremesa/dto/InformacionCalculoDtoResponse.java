package com.reto.interbank.calculoremesa.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformacionCalculoDtoResponse {

    private String nombres;
    private String apellidos;
    private String dni;
    private Double montoOrigen;
    private Double montoDestino;
    private String monedaDestino;
    private LocalDateTime fechaConsulta;
}
