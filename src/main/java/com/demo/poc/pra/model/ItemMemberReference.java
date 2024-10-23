package com.demo.poc.pra.model;


import jakarta.validation.constraints.Min;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemMemberReference extends MemberReference {
    @Min(1)
    private int quantity;
}
