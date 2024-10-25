package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property{
    public String name;
    public String displayName;
    public String description;
    public String refAttr;
    public String type;
    public String format;
    public boolean required;
    public List<String> tags;
}
