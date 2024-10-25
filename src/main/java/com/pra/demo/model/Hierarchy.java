package com.pra.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hierarchy {
	public String name;
    public String displayName;
    public String description;
    public boolean enableRbac;
    public List<Level> levels;
}
