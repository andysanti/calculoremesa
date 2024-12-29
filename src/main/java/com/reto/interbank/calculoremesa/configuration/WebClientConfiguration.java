package com.reto.interbank.calculoremesa.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${conversion.base.url}")
    private String conversionBaseUrl;
    @Bean
    public WebClient webClient(){

        return WebClient.builder()
                .baseUrl(conversionBaseUrl).build();
    }
}
