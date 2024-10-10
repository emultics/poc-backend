package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.FcstData;

import java.util.List;

@Deprecated
public interface IFcstService {
    @Deprecated
    public List<FcstData> calculateNormalizedFactors(List<FcstData> dataSet);

    @Deprecated
    public List<FcstData> calculateNewForecast(List<FcstData> dataSet);

    public double totalSumOfFactors(List<FcstData>dataSet);

    public double totalSumOfForecast(List<FcstData> dataSet);

    public List<Double> getListOfForecast(List<FcstData> dataList);

    public List<Double> getListOfProfile(List<FcstData> dataList);

    public <T> boolean isSizeEqual(List<T> list1, List<T> list2);






}
