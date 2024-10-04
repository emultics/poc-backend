package com.bycdp.demo.poc.model;

import lombok.Data;


@Data
public class FcstData {
    private int fcst;
    private int factors;
    private double normalizedFactor;
    private double newForecast;

}
