package com.bycdp.demo.poc.model;

import com.bycdp.demo.poc.validation.ValidDimensions;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberReference {
    @NotNull
    private String ref_attr;
    @NotNull
    private String target_attr;
    @NotNull
    private String ref_member;
    @NotNull
    private String target_member;
}
