package com.bycdp.demo.poc;

import com.bycdp.demo.poc.model.ForecastData;
import com.bycdp.demo.poc.service.ForecastProcessor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForecastProcessorTest {
    private final ForecastProcessor forecastProcessor = new ForecastProcessor();



    @Test
    public void testIsSizeEqual_EqualSizeLists(){
        List<Double> forecast = Arrays.asList(2.0, 3.0, 6.0);
        List<Double> profile = Arrays.asList(2.0, 1.0, 16.0);

        assertTrue(forecastProcessor.isSizeEqual(forecast, profile));
    }


    @Test
    public void testCalculateNormalizedProfileLists(){
        List<Double> profileList = Arrays.asList(2.0, 4.0, 6.0);
        double sumOfProfile = 12.0;
        List<Double> normalizedProfiles = forecastProcessor.calculateNormalizedProfileList(profileList, sumOfProfile);
        List<Double> expected = Arrays.asList(0.166, 0.333, 0.5);

        for(int i=0;i<expected.size();i++){
            assertEquals(expected.get(i), normalizedProfiles.get(i), 0.001);
        }
    }

    @Test
    public void testGetCalculateNewForecastList(){
        List<Double>  normalizedProfiles = Arrays.asList(0.2, 0.3, 0.5);
        double sumOfForecast = 100.0;
        List<Double> newForecast = forecastProcessor.getCalculatedNewForecastList(normalizedProfiles, sumOfForecast);
        List<Double> expected = Arrays.asList(20.0, 30.0, 50.0);
        assertEquals(expected, newForecast);
    }

    @Test
    public void testFillForecastWithAverage(){
        List<Double> forecast = new ArrayList<>(Arrays.asList(10.0, 20.0));
        int profileSize = 4;
        forecastProcessor.fillForecastWithAverage(forecast, profileSize);
        List<Double> expected = Arrays.asList(10.0,20.0, 15.0, 15.0);
        assertEquals(expected, forecast);

    }
    @Test
    public void testTrimForecastAndGetSum(){
        List<Double> forecast = Arrays.asList(10.0, 20.0, 30.0);
        double sumOftrimmedForecast = forecastProcessor.trimForecastAndGetSum(forecast, 2);
        assertEquals(30.0, sumOftrimmedForecast, 0.001);
    }

    @Test
    public void testHandleEqualSizeCase(){
        List<Double> forecast = Arrays.asList(10.0, 20.0, 30.0);
        List<Double> profile = Arrays.asList(2.0, 4.0, 6.0);

        ForecastData data = new ForecastData();
        data.setProfile(profile);
        data.setFcst(forecast);
    }
}
