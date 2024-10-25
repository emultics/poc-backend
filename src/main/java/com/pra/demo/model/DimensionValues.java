package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DimensionValues {
    private String ref_level;

    private List<String> ref_member;

    private String target_level;

    private List<String> target_member;
}
