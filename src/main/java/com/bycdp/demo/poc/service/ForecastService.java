package com.bycdp.demo.poc.service;

import com.bycdp.demo.poc.model.FcstData;
import com.bycdp.demo.poc.model.ForecastData;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ForecastService implements IFcstService{

    ////////////////////
    /*
     * Old Version - Deprecated
     * This is the outdated version of the code.
     * Date: Oct 5, 2024
     */


    @Deprecated
    @Override
    public List<FcstData> calculateNormalizedFactors(List<FcstData> dataSet) {
        double totalFactors = totalSumOfFactors(dataSet);
        for(FcstData data: dataSet){
            double normalizedFactor = data.getFactors() / totalFactors;
            data.setNormalizedFactor(normalizedFactor);
        }
        return dataSet;
    }

    public List<Double> calculateNormalizedProfilesList(List<Double> profiles, double profileSum){
        List<Double> listOfNormalizedProfiles = new ArrayList<>();
        for(Double profile: profiles){
            listOfNormalizedProfiles.add(profile/profileSum);

        }
        return listOfNormalizedProfiles;
    }

    @Deprecated
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

    public List<Double> getCalculateNewForecastList(List<Double> normalizedProfiles, double forecastSum){
        List<Double> listOfNewForecastList = new ArrayList<>();
        for(Double normalizedProfile: normalizedProfiles){
            listOfNewForecastList.add(normalizedProfile * forecastSum);
        }
        return listOfNewForecastList;
    }

    @Deprecated
    @Override
    public double totalSumOfFactors(List<FcstData> dataSet) {
        return dataSet.stream().mapToDouble(FcstData::getFactors).sum();
    }

    @Deprecated
    @Override
    public double totalSumOfForecast(List<FcstData> dataSet) {
        return dataSet.stream().mapToDouble(FcstData::getFcst).sum();
    }
    /////////////////////////

    /*
     * New Version
     * This is the updated version of the code.
     * Date: Oct 9, 2024
     */

    /////////////////////////

    public ForecastData getNewForecastData(List<FcstData> data){
        List<Double> forecastList = getListOfForecast(data);
        List<Double> profiles = getListOfProfile(data);
        System.out.println(forecastList.size());
        System.out.println(profiles.size());
        ForecastData forecastData = new ForecastData();
        forecastData.setFcst(forecastList);
        forecastData.setProfile(profiles);
        return forecastData;
    }

    /**
     * Retrieves a list of forecast values from a given list of FcstData objects.
     *
     * @param dataList the list of FcstData objects from which forecast values are to be extracted
     * @return a List of Double containing the forecast values
     */

    @Override
    public List<Double> getListOfForecast(List<FcstData> dataList){

        // Use Java Streams to map each FcstData object to its forecast value and collect it into a list.

        return dataList.stream().map(FcstData::getFcst).collect(Collectors.toList());
    }

    /**
     * Retrieves a list of profiles values from a given list of FcstData objects.
     *
     * @param dataList the list of FcstData objects from which factors are to be extracted
     * @return a List of Double containing the factors
     */
    @Override
    public List<Double> getListOfProfile(List<FcstData> dataList){

        // Use Java Streams to map each FcstData object to its factors value and collect it into a list.

        return dataList.stream().map(FcstData::getFactors).collect(Collectors.toList());
    }

    /**
     * Compares the sizes of two generic lists and checks if they are equal.
     *
     * @param <T>   the type of elements in the lists
     * @param list1 the first list to compare
     * @param list2 the second list to compare
     * @return true if both lists have the same size, false otherwise
     */

    @Override
    public <T> boolean isSizeEqual(List<T> list1, List<T> list2) {
        return list1.size() == list2.size();
    }


    /**
     * Calculates the total sum of the elements in a list of Double values.
     *
     * @param list1 the list of Double values to sum
     * @return the total sum of the values in the list
     */
    private double totalSum(List<Double> list1){
        return list1.stream().mapToDouble(Double::doubleValue).sum();
    }

    private Map<String,List<Double>> getResultMap(List<Double> forecast, List<Double> profile, List<Double> normalizedProfile, List<Double> newForecast ){
        Map<String, List<Double>> newDataMap = new HashMap<>();
        newDataMap.put("fcst", forecast);
        newDataMap.put("profile", profile);
        newDataMap.put("normalizedProfile", normalizedProfile);
        newDataMap.put("newForecast", newForecast);
        return newDataMap;
    }

    public Map<String, List<Double>> calculateNormalizedFactor(ForecastData data) {

        /**
         * Case 1 : IsEqual length
         */
        if(isSizeEqual(data.getFcst(), data.getProfile())){
            double sumOfProfile = totalSum(data.getProfile());
            double sumOfForecast = totalSum(data.getFcst());
            List<Double> normalizedProfiles = calculateNormalizedProfilesList(data.getProfile(), sumOfProfile);
            List<Double> listOfNewForecast = getCalculateNewForecastList(normalizedProfiles, sumOfForecast);
            return getResultMap(data.getFcst(), data.getProfile(), normalizedProfiles, listOfNewForecast);
        }
        /**
         * Case 2: is Forecast Empty
         */
        else if(data.getFcst().isEmpty()){
            double sumOfProfile = totalSum(data.getProfile());
            List<Double> listOfEmptyNewForecast = new ArrayList<>(Collections.nCopies(data.getProfile().size(), 0.0));
            List<Double> normalizedProfiles = calculateNormalizedProfilesList(data.getProfile(),sumOfProfile);
            return getResultMap(data.getFcst(), data.getProfile(), normalizedProfiles, listOfEmptyNewForecast);

        }else if(!data.getFcst().isEmpty() && (data.getFcst().size() < data.getProfile().size())){
            /**
             * check forecast list is Empty or not
             * if  Size of Forecast less than Size of profile
             * then Average of remaining value in forecast will be filled in empty index
             */
            double avgOfForecast = totalSum(data.getFcst())/data.getFcst().size();
            while(data.getFcst().size() < data.getProfile().size()){
                data.getFcst().add(avgOfForecast);
            }

            double sumOfProfile = totalSum(data.getProfile());
            double sumOfForecast = totalSum(data.getFcst());

            List<Double> normalizedProfiles = calculateNormalizedProfilesList(data.getProfile(), sumOfProfile);
            List<Double> listOfNewForecast = getCalculateNewForecastList(normalizedProfiles, sumOfForecast);

            return getResultMap(data.getFcst(), data.getProfile(), normalizedProfiles, listOfNewForecast);

        }else if(!data.getProfile().isEmpty() && data.getProfile().size() < data.getFcst().size()){
            double sumOfProfile = totalSum(data.getProfile());
            List<Double> normalizedProfiles = calculateNormalizedProfilesList(data.getProfile(), sumOfProfile);

            List<Double> newSubForecast = data.getFcst().subList(0, data.getProfile().size()-1);
            double sumOfForecast = totalSum(newSubForecast);
            List<Double> listOfNewForecast = getCalculateNewForecastList(normalizedProfiles, sumOfForecast);
            for(int i=listOfNewForecast.size()-1 ; i< data.getFcst().size();i++){

                listOfNewForecast.add(data.getFcst().get(i));
            }


            return getResultMap(data.getFcst(), data.getProfile(), normalizedProfiles, listOfNewForecast);
        }
        return null;



    }
}
