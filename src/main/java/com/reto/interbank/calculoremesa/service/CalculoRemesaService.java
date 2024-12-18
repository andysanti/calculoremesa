package com.reto.interbank.calculoremesa.service;

import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoRequest;
import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoResponse;
import reactor.core.publisher.Mono;

public interface CalculoRemesaService {

    Mono<InformacionCalculoDtoResponse> calculoMoneda(InformacionCalculoDtoRequest request);
}
