package com.pra.demo.service;

import com.bycdp.demo.poc.constant.RouteConstant;
import com.google.gson.Gson;
import com.pra.demo.model.LogicalModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LogicalModelServiceImpl implements LogicalModelService{
    @Autowired
    private ApiService apiService;
    @Autowired
    private final Gson gson;

    @Override
    public LogicalModel getLogicalModel() {
      return apiService.fetchDataFromApi(RouteConstant.LOGICAL_MODEL_URI, HttpMethod.GET)
                .flatMap(response -> {
                    try {
                        LogicalModel logicalModel = gson.fromJson(response, LogicalModel.class);
                        System.out.println(logicalModel.toString());
                        return Mono.just(logicalModel);

                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("Failed to parse LogicalModel response", e));
                    }
                })
                .doOnNext(logicalModel -> System.out.println("Received LogicalModel: " + logicalModel))
                .onErrorResume(e -> {
                    return Mono.error(new RuntimeException("Failed to fetch LogicalModel from API", e));
                }).block();

    }

}
