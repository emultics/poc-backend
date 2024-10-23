package com.demo.poc.pra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberReference {
    
    private String dimension_name;

    private DimensionValues dimension_values;
}
