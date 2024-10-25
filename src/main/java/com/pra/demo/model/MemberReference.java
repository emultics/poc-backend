package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberReference {
    
    private String dimension_name;

    private DimensionValues dimension_values;
    private Boolean isModifiedDimensionRefLevel=false;
    private Boolean isModifiedDimensionRefMember=false;
}
