package com.reto.interbank.calculoremesa.dominio;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InformacionRemesa {

    private String nombres;
    private String apellidos;
    private String dni;
    private Double montoOrigen;
    private Double montoDestino;
    private String monedaDestino;
    private LocalDateTime fechaConsulta;
}
