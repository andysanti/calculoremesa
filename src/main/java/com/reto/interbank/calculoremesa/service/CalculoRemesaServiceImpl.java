package com.reto.interbank.calculoremesa.service;

import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoRequest;
import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CalculoRemesaServiceImpl implements CalculoRemesaService{


    @Override
    public Mono<InformacionCalculoDtoResponse> calculoMoneda(InformacionCalculoDtoRequest request) {
        return  Mono.just(InformacionCalculoDtoResponse.builder().dni("12345")
                .monedaDestino("USD")
                .nombres("ANDY ")
                .apellidos("SANTI")
                .montoDestino( Double.valueOf("20.80"))
                .montoOrigen(Double.valueOf("80.00"))
                .fechaConsulta(LocalDateTime.now())
                .build())
                ;
    }
}
