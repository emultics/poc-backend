package com.bycdp.demo.poc.controller;
import com.bycdp.demo.poc.constant.RouteConstant;
import com.bycdp.demo.poc.model.FcstData;
import com.bycdp.demo.poc.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RouteConstant.FORECAST_ROUTE)
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/health")
    public String health(){
        return "Ok";
    }


    @PostMapping("/calculate")
    public List<FcstData> calculateNewForecast(@RequestBody List<FcstData> dataSet){
        return forecastService.calculateNewForecast(dataSet);
    }

}
