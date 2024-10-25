package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measure{
    public String name;
    public String displayName;
    public String description;
    public String refAttr;
    public List<String> tags;
    public String dmsAggregationType;
    public String dataType;
    public boolean enableDdpCache;
    public boolean isEditable;
    public boolean isStored;
    public String precision;
    public String maasAggregationType;
    public String timeRangeType;
}
