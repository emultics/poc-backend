package com.bycdp.demo.poc.controller;
import com.bycdp.demo.poc.constant.RouteConstant;
import com.bycdp.demo.poc.model.FcstData;
import com.bycdp.demo.poc.model.ForecastData;
import com.bycdp.demo.poc.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(RouteConstant.FORECAST_ROUTE)
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/health")
    public String health(){
        return "Ok";
    }


    /**
     * @Deprecated Version
     * @param dataSet
     * @return
     */
    @Deprecated
    @PostMapping("/calculate")
    public List<FcstData> calculateNewForecast(@RequestBody List<FcstData> dataSet){
        return forecastService.calculateNewForecast(dataSet);
    }


    @GetMapping("/fcst-list")
    public ForecastData getForecastList(@RequestBody List<FcstData> data){
        return forecastService.getNewForecastData(data);

    }

    @PostMapping("/do")
    public Map<String, List<Double>> doCalculate(@RequestBody ForecastData data){
        return forecastService.calculateNormalizedFactor(data);
    }


}
