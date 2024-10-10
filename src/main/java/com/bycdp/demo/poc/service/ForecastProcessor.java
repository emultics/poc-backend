package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.ForecastData;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ForecastProcessor  implements IForecastProcessor{
    /**
     * Compares the Sizes of two generic lists and checks if they are equal
     * @param list1 the first list to compare
     * @param list2 the second list to compare
     * @param <T> the type of elements in the list
     * @return true if both lists have same size, false otherwise
     */
    @Override
    public <T> boolean isSizeEqual(List<T> list1, List<T> list2) {
        return list1.size() == list2.size();
    }

    /**
     * calculate the total sum of elements in a list of double values
     * @param list the list of double values to sum
     * @return the total sum of the values in the list
     */
    @Override
    public double totalSum(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum();
    }

    /**
     * @param profiles the list of profile values
     * @param sumOfProfile the total sum of profile values
     * @return a list of normalized profile values
     * Formula: element_of_profiles / sumOfProfile
     */
    @Override
    public List<Double> calculateNormalizedProfileList(List<Double> profiles, double sumOfProfile) {
        return profiles.stream().map(prof -> prof/sumOfProfile).collect(Collectors.toList());
    }

    /**
     * Generates a new forecast list based on normalized profiles and total sum of forecast
     * @param normalizedProfileList the list of normalized profiles
     * @param sumOfForecast the total sum of forecast values
     * @return a list of new forecast values
     */
    @Override
    public List<Double> getCalculatedNewForecastList(List<Double> normalizedProfileList, double sumOfForecast) {
        return normalizedProfileList.stream().map(norm -> norm*sumOfForecast).collect(Collectors.toList());
    }

    /**
     * @param forecast the original forecast list
     * @param profileSize the size of the profile list
     */
    @Override
    public void fillForecastWithAverage(List<Double> forecast, int profileSize) {
        double avgForecast = totalSum(forecast)/forecast.size();
        // while the size of the forecast list is < profile size, keep adding the average value
        while(forecast.size() < profileSize) {
            forecast.add(avgForecast);
        }

    }

    /**
     * @param forecast
     * @param profileSize
     * @return
     */
    @Override
    public double trimForecastAndGetSum(List<Double> forecast, int profileSize) {
        List<Double> subForecast = forecast.subList(0, profileSize);
        return totalSum(subForecast);
    }

    /**
     * @param forecast
     * @param profile
     * @param normalizedProfile
     * @param newForecast
     * @return
     */
    @Override
    public Map<String, List<Double>> getResultMap(List<Double> forecast, List<Double> profile, List<Double> normalizedProfile, List<Double> newForecast) {
        Map<String, List<Double>> newDataMap = new HashMap<>();
        newDataMap.put("forecast", forecast);
        newDataMap.put("profile", profile);
        newDataMap.put("normalizedProfile", normalizedProfile);
        newDataMap.put("newForecast", newForecast);
        return newDataMap;
    }

    /**
     * @param data
     * @return
     */
    @Override
    public Map<String, List<Double>> calculatedNormalizedFactor(ForecastData data) {
        List<Double> forecast = data.getFcst();
        List<Double> profile = data.getProfile();
        if(isSizeEqual(forecast, profile)) {
            return handleEqualSize(forecast, profile);
        }else if(forecast.isEmpty()){
            return handleEmptyForecastCase(profile);

        }else if(forecast.size() < profile.size()) {
            return handleSmallerForecastCase(forecast, profile);
        }else if(forecast.size()> profile.size()) {
            return handleSmallerProfileCase(forecast, profile);
        }
        return null;
    }

    /**
     * handles the case where forecast and profile list are equal size
     *
     * @param forecast the forecast list
     * @param profile the profile list
     * @return a map containing the processed list
     */
    @Override
    public Map<String, List<Double>> handleEqualSize(List<Double> forecast, List<Double> profile) {
        double sumOfProfile = totalSum(profile);
        double sumOfForecast = totalSum(forecast);
        List<Double> normalizedProfiles = calculateNormalizedProfileList(profile, sumOfProfile);
        List<Double> newForecast = getCalculatedNewForecastList(normalizedProfiles, sumOfForecast);
        return getResultMap(forecast, profile, normalizedProfiles, newForecast);
    }

    /**
     * Handles the case where the forecast list is empty
     * @param profile the profile list
     * @return a map containing processed list
     */
    @Override
    public Map<String, List<Double>> handleEmptyForecastCase( List<Double> profile) {
        double sumOfProfile = totalSum(profile);
        List<Double> normalizedProfiles = calculateNormalizedProfileList(profile, sumOfProfile);
        List<Double> emptyNewForecast = new ArrayList<>(Collections.nCopies(profile.size(),0.0));
        return getResultMap(Collections.emptyList(), profile, normalizedProfiles, emptyNewForecast);
    }

    /**
     * @param forecast
     * @param profile
     * @return
     */
    @Override
    public Map<String, List<Double>> handleSmallerForecastCase(List<Double> forecast, List<Double> profile) {
        fillForecastWithAverage(forecast, profile.size());
        return handleEqualSize(forecast, profile);
    }

    /**
     * @param forecast
     * @param profile
     * @return
     */
    @Override
    public Map<String, List<Double>> handleSmallerProfileCase(List<Double> forecast, List<Double> profile) {
        double sumOfProfile = totalSum(profile);
        List<Double> normalizedProfiles = calculateNormalizedProfileList(profile, sumOfProfile);
        double sumOfTrimmedForecast = trimForecastAndGetSum(forecast, profile.size());
        List<Double> newForecast = getCalculatedNewForecastList(normalizedProfiles, sumOfTrimmedForecast);
        newForecast.addAll(forecast.subList(profile.size(), forecast.size()));
        return getResultMap(forecast, profile, normalizedProfiles, newForecast);
    }
}
