package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureGroup {
    public String name;
    public String description;
    public String node;
    public String timeGranularity;
    public String entity;
    public List<String> tags;
    public List<NodeMgMappingAttr> nodeMgMappingAttr;
    public List<Measure> measures;
    public String createdBy;
    public String lastModifiedBy;
    public String createdTimestamp;
    public String modifiedTimestamp;
    public String displayName;
}

