package com.reto.interbank.calculoremesa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculoConversionDtoRequest {

    private String monedaOrigen;
    private String monedaDestino;
    private Double montoOrigen;

}
