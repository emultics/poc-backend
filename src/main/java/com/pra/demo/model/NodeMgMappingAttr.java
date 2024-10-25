package com.pra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeMgMappingAttr{
    public String name;
    public String level;
    public String refAttr;
    public String displayName;
}
