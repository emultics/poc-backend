package com.bycdp.demo.poc.model;

import lombok.Data;

import java.util.List;

@Data
public class ForecastData {
    private List<Double> fcst;
    private List<Double> profile;
}
