package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private String channel;

    private List<MemberReference> member_ref;
    private int variant;

}
