package com.demo.shape_post_processors;

import com.demo.model.Shape;

public class ColorPostProcessor extends SortedShapePostProcessor {
    protected String shapeColorBeforeDraw;
    protected String shapeColorAfterDraw;

    public ColorPostProcessor() {
    }

    public ColorPostProcessor(String shapeColorBeforeDraw, String shapeColorAfterDraw) {
        this.shapeColorBeforeDraw = shapeColorBeforeDraw;
        this.shapeColorAfterDraw = shapeColorAfterDraw;
    }

    @Override
    public String getName() {
        return "ColorPostProcessor";
    }

    @Override
    public Shape postProcessBeforeDraw(Shape shape) {
        System.out.println("ColorPostProcessor postProcessBeforeDraw, set color = " + this.shapeColorBeforeDraw);
        shape.setColor(this.shapeColorBeforeDraw);
        return shape;
    }

    @Override
    public Shape postProcessAfterDraw(Shape shape) {
        System.out.println("ColorPostProcessor postProcessAfterDraw, set color = " + this.shapeColorAfterDraw);
        shape.setColor(this.shapeColorAfterDraw);
        return shape;
    }

    @Override
    public Integer getOrder() {
        return 101;
    }
}
