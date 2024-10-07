package com.bycdp.demo.poc.controller;

import com.bycdp.demo.poc.model.CreateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {

    @PostMapping("/create")
    public ResponseEntity<CreateRequest> doCreate(@Valid @RequestBody CreateRequest createRequest){

        return ResponseEntity.ok(createRequest);
    }
}
