package com.demo.model;

import com.demo.consts.ShapeType;
import com.demo.shape_post_processors.SortedShapePostProcessor;

import java.util.*;

public abstract class Shape {
    protected String name;
    protected String color;
    protected TreeSet<SortedShapePostProcessor> sortedShapePostProcessorSet = new TreeSet<>();

    public abstract void draw();
    public abstract ShapeType shapeType();
    public abstract void processScale(Double scale);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TreeSet<SortedShapePostProcessor> getSortedShapePostProcessorSet() {
        return sortedShapePostProcessorSet;
    }

    public void registerShapePostProcessor(SortedShapePostProcessor postProcessor) {
        sortedShapePostProcessorSet.add(postProcessor);
    }

    public void removeShapePostProcessor(SortedShapePostProcessor postProcessor) {
        sortedShapePostProcessorSet.remove(postProcessor);
    }
}
