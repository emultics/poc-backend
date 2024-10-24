package com.pra.demo.controller;

import com.bycdp.demo.poc.constant.RouteConstant;
import com.pra.demo.service.ApiService;
import com.pra.demo.service.LogicalModelService;
import com.pra.demo.service.LogicalModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("V3API-LOGICAL-MODEL")
@RequestMapping("/v3/api")
public class TestController {
    @Autowired
    private LogicalModelService logicalModelService;

    @GetMapping("/logical-model")
    public Mono<String> fetchFromApi() {
        return  logicalModelService.getLogicalModel();
    }
}
