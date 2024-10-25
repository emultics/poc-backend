package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimension {
    public String name;
    public String displayName;
    public String description;
    public String entity;
    public String filter; 
    public boolean isTimeDimension;
    public List<Level> levels;
    public List<Hierarchy> hierarchies;
    public String createdBy;
    public String lastModifiedBy;
    public String createdTimestamp;  
    public String modifiedTimestamp; 
    public String level; //
    public String refAttr; //
}

