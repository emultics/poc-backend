package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    public List<Dimension> dimensions;
    public List<Node> nodes;
    public List<MeasureGroup> measureGroups;
    public List<Object> ruleSets;
}

