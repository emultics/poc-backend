package com.bycdp.demo.poc.controller;
import com.bycdp.demo.poc.constant.RouteConstant;
import com.bycdp.demo.poc.model.FcstData;
import com.bycdp.demo.poc.model.ForecastData;
import com.bycdp.demo.poc.service.ForecastProcessor;
import com.bycdp.demo.poc.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(RouteConstant.FORECAST_ROUTE)
public class ForecastController {

    @Autowired
    private ForecastProcessor processor;

    @GetMapping("/health")
    public String health(){
        return "Ok";
    }

    @PostMapping("/get-forecast-new")
    public Map<String, List<Double>> doCalculate(@RequestBody ForecastData data){
        return processor.calculatedNormalizedFactor(data);
    }


}