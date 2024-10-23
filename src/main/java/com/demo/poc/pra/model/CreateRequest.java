package com.demo.poc.pra.model;

import com.bycdp.demo.poc.model.Dimensions;

public class CreateRequest {
    private String launch_date;

    @NotNull
    private String create_as;

    @NotNull
    private Dimensions dimensions;

}
