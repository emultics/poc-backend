package com.demo.poc.pra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private String channel;

    private List<MemberReference> memberReferences;
}
