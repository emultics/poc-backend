package com.pra.demo.service;

import reactor.core.publisher.Mono;

public interface LogicalModelService {
    public Mono<String> getLogicalModel();

}
