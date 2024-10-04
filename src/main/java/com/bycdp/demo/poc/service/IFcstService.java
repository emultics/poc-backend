package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.FcstData;

import java.util.List;

public interface IFcstService {
    public List<FcstData> calculateNormalizedFactors(List<FcstData> dataSet);

    public List<FcstData> calculateNewForecast(List<FcstData> dataSet);

    public double totalSumOfFactors(List<FcstData>dataSet);

    public double totalSumOfForecast(List<FcstData> dataSet);


}
