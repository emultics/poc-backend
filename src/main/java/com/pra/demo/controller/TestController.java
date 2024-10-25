package com.pra.demo.controller;

import com.pra.demo.model.LogicalModel;
import com.pra.demo.model.RequestPayload;
import com.pra.demo.service.LogicalModelService;
import com.pra.demo.utils.DimensionValidator;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("V3API-LOGICAL-MODEL")
@RequestMapping("/v3/api")
public class TestController {
    @Autowired
    private LogicalModelService logicalModelService;

    @Autowired
    private DimensionValidator dimensionValidator;

    @GetMapping("/logical-model")
    public ResponseEntity<?> fetchFromApi() {
        LogicalModel logicalModel = logicalModelService.getLogicalModel();
        return  new ResponseEntity<>(logicalModel, HttpStatus.OK);
    }

    @GetMapping("/create-req")


    public ResponseEntity<RequestPayload> create(@RequestBody RequestPayload createRequest){
        dimensionValidator.validateDimensions(createRequest);
        return new ResponseEntity<RequestPayload>(createRequest, HttpStatus.OK);
    }
}
