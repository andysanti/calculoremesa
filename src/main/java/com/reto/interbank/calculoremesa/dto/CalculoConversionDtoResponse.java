package com.reto.interbank.calculoremesa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculoConversionDtoResponse {

    private String monedaOrigen;
    private String monedaDestino;
    private Double montoOrigen;
    private Double montoDestino;
}
