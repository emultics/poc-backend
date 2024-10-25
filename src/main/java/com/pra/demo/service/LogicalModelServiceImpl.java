package com.pra.demo.service;

import com.bycdp.demo.poc.constant.RouteConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LogicalModelServiceImpl implements LogicalModelService{
    @Autowired
    private ApiService apiService;

    @Override
    public Mono<String> getLogicalModel() {
        return apiService.fetchDataFromApi(RouteConstant.LOGICAL_MODEL_URI, HttpMethod.GET);
    }
}
