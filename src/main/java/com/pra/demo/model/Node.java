package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public String name;
    public String entity;
    public String description;
    public List<Dimension> dimensions;
    public String displayName;
    public String filter;
    public List<String> propertyGroup;
    public String createdBy;
    public String lastModifiedBy;
    public String createdTimestamp;
    public String modifiedTimestamp;
}

