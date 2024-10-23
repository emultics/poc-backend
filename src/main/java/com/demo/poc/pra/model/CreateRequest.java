package com.demo.poc.pra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequest {
    private String launch_date;

    private String create_as;

    private Dimensions dimensions;

}
