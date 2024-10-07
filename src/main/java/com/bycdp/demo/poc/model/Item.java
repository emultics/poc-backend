package com.bycdp.demo.poc.model;


import jakarta.validation.constraints.Min;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item extends MemberReference {
    @Min(1)
    private int quantity;
}
