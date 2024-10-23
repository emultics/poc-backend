package com.demo.poc.pra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private String channel;
    private ItemMemberReference item;
    private List<MemberReference> memberReferences;
}
