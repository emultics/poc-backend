package com.pra.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;


@Service
public class ApiService {
    private final WebClient webClient;

    public ApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    Logger logger = LoggerFactory.getLogger(ApiService.class);

    public Mono<String> fetchDataFromApi(String uri, HttpMethod httpMethod){
        return webClient.get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("There is an error while retrieving api: ")))
                .bodyToMono(String.class)
                .doOnError(error -> logger.error("There is an error while sending request {}", error.getMessage()))
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(3)));

    }

    public <T> Mono<String> fetchDataFromApi(String uri, HttpMethod httpMethod, T body) {
        return webClient.method(httpMethod)
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("There is an error while retrieving the api: ")))
                .bodyToMono(String.class)
                .doOnError(error -> logger.error("There is an error while sending request {}", error.getMessage()))
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(3)));


    }









}
