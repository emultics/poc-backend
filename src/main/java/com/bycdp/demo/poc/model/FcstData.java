package com.bycdp.demo.poc.model;

import lombok.Data;

@Deprecated
@Data
public class FcstData {
    private double fcst;
    private double factors;
    private double normalizedFactor;
    private double newForecast;

}
