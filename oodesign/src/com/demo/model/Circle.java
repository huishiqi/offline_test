package com.demo.model;

import com.demo.consts.ShapeType;

public class Circle extends Shape {
    private Double r;

    public Circle() {
    }

    public Circle(String name, String color, Double r) {
        this.name = name;
        this.color = color;
        this.r = r;
    }

    public void draw() {
        System.out.println("Draw a circle !" + this);
    }

    @Override
    public ShapeType shapeType() {
        return ShapeType.CIRCLE;
    }

    @Override
    public void processScale(Double scale) {
        this.r = this.r * scale;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "name = " + getName() + ", color = " + getColor() + ", r = " + getR();
    }
}
