package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Level {
	public String name;
    public String displayName;
    public String description;
    public boolean leafLevel;
    public String memberNameProperty;
    public String refAttr;
    public List<Property> properties;
    public String level;
    public int order;
}
