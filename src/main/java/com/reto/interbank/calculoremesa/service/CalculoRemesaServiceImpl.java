package com.reto.interbank.calculoremesa.service;

import com.reto.interbank.calculoremesa.controller.CalculoController;
import com.reto.interbank.calculoremesa.dto.CalculoConversionDtoRequest;
import com.reto.interbank.calculoremesa.dto.CalculoConversionDtoResponse;
import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoRequest;
import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CalculoRemesaServiceImpl implements CalculoRemesaService{

    Logger logger = LoggerFactory.getLogger(CalculoController.class);

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<InformacionCalculoDtoResponse> calculoMoneda(InformacionCalculoDtoRequest request) {

        logger.info("llamada a api calculoMoneda");
        CalculoConversionDtoResponse calculoConversionDtoResponse = CalculoConversionDtoResponse.builder().build();
        return   webClient.post().uri("v1/conversion/")
                .bodyValue(CalculoConversionDtoRequest.builder()
                        .monedaOrigen(request.getMonedaOrigen())
                        .monedaDestino(request.getMonedaDestino())
                        .montoOrigen(request.getMontoOrigen()).build())
                .retrieve()
                .toEntity(CalculoConversionDtoResponse.class)
                .map(calculoConversionDtoResponseResponseEntity ->{

                    logger.info("api status{}{}", calculoConversionDtoResponseResponseEntity.toString(), calculoConversionDtoResponseResponseEntity.getStatusCode());
                    return    InformacionCalculoDtoResponse.builder().dni(request.getDni())
                .monedaDestino(request.getMonedaDestino())
                .nombres(request.getNombres())
                .apellidos(request.getApellidos())
                .montoDestino(calculoConversionDtoResponseResponseEntity.getBody().getMontoDestino())
                .montoOrigen(request.getMontoOrigen())
                .fechaConsulta(LocalDateTime.now())
                .build();
                })
                .defaultIfEmpty(InformacionCalculoDtoResponse.builder().build())
                .onErrorResume(throwable -> {
                    logger.error("error desde api,detalle {}", throwable.getMessage());
                   return Mono.just(InformacionCalculoDtoResponse.builder().build());
                });


    }
}
