package com.bycdp.demo.poc.model;


import com.bycdp.demo.poc.validation.ValidDimensions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private String channel;
    private Item item;
    private MemberReference location;
    private MemberReference customer;
}
