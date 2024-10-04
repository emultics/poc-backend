package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.FcstData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService implements IFcstService{

    @Override
    public List<FcstData> calculateNormalizedFactors(List<FcstData> dataSet) {
        double totalFactors = totalSumOfFactors(dataSet);
        for(FcstData data: dataSet){
            double normalizedFactor = data.getFactors() / totalFactors;
            data.setNormalizedFactor(normalizedFactor);
        }
        return dataSet;
    }

    @Override
    public List<FcstData> calculateNewForecast(List<FcstData> dataSet) {
       double forecastSum = totalSumOfForecast(dataSet);
       List<FcstData> withNormalizedFactors = calculateNormalizedFactors(dataSet);
       for(FcstData data: withNormalizedFactors){
           double newForecast = data.getNormalizedFactor() * forecastSum;
           data.setNewForecast(newForecast);
       }

       return withNormalizedFactors;
    }

    @Override
    public double totalSumOfFactors(List<FcstData> dataSet) {
        return dataSet.stream().mapToDouble(FcstData::getFactors).sum();
    }

    @Override
    public double totalSumOfForecast(List<FcstData> dataSet) {
        return dataSet.stream().mapToDouble(FcstData::getFcst).sum();
    }
}
