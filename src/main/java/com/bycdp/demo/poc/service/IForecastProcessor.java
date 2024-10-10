package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.ForecastData;

import java.util.List;
import java.util.Map;

public interface IForecastProcessor {

    public <T> boolean isSizeEqual(List<T> list1, List<T> list2);

    public double totalSum(List<Double> list);

    public List<Double> calculateNormalizedProfileList(List<Double> profiles, double sumOfProfile);

    public List<Double> getCalculatedNewForecastList(List<Double> normalizedProfileList, double sumOfForecast);


    public void fillForecastWithAverage(List<Double> forecast, int profileSize);

    public double trimForecastAndGetSum(List<Double> forecast, int profileSize);

    public Map<String, List<Double>> getResultMap(List<Double> forecast, List<Double> profile, List<Double> normalizedProfile, List<Double> newForecast);

    public Map<String, List<Double>> calculatedNormalizedFactor(ForecastData data);

    public Map<String, List<Double>> handleEqualSize(List<Double> forecast, List<Double> profile);

    public Map<String, List<Double>> handleEmptyForecastCase(List<Double> profile);

    public Map<String, List<Double>> handleSmallerForecastCase(List<Double> forecast, List<Double> profile);

    public Map<String, List<Double>> handleSmallerProfileCase(List<Double> forecast, List<Double> profile);
}
