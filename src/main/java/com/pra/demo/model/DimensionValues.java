package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DimensionValues {
    private String ref_level;

    private String ref_member;

    private String target_level;

    private String target_member;

    private int variant;
}
