package com.demo.model;

import com.demo.consts.ShapeType;

public class Square extends Shape {
    private Double length;
    private Double width;

    public Square() {
    }

    public Square(String name, String color, double length, double width) {
        this.name = name;
        this.color = color;
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("Draw a square! " + this);
    }

    @Override
    public ShapeType shapeType() {
        return ShapeType.SQUARE;
    }

    @Override
    public void processScale(Double scale) {
        this.length = this.length * scale;
        this.width = this.width * scale;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "name = " + getName() + ", color = " + getColor() + ", length = " + getLength() + ", width = " + getWidth();
    }
}
