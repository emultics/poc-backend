package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPayload {
    private String launch_date;

    private String create_as;

    private Dimensions dimensions;

}
