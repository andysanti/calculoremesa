package com.reto.interbank.calculoremesa.controller;

import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoRequest;
import com.reto.interbank.calculoremesa.dto.InformacionCalculoDtoResponse;
import com.reto.interbank.calculoremesa.service.CalculoRemesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/calculoremesa/")
public class CalculoController {
    private final CalculoRemesaService calculoRemesaService;

    public CalculoController(CalculoRemesaService calculoRemesaService) {
        this.calculoRemesaService = calculoRemesaService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Mono<InformacionCalculoDtoResponse>> getCalculoRemesa(@RequestBody InformacionCalculoDtoRequest request){
        return new ResponseEntity<>(calculoRemesaService.calculoMoneda( request), HttpStatus.OK);
    }
}
