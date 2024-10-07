package com.bycdp.demo.poc.model;

import com.bycdp.demo.poc.validation.ValidDimensions;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
@ValidDimensions
public class CreateRequest {
    private String launch_date;

    @NotNull
    private String create_as;

    @NotNull
    private Dimensions dimensions;




}
