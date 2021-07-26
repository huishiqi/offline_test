package com.demo.shape_post_processors;

import com.demo.model.Shape;

public class CircleColorPostProcessor extends ColorPostProcessor {
    public CircleColorPostProcessor() {
    }

    public CircleColorPostProcessor(String shapeColorBeforeDraw, String shapeColorAfterDraw) {
        super(shapeColorBeforeDraw, shapeColorAfterDraw);
    }

    @Override
    public String getName() {
        return "CircleColorPostProcessor";
    }

    @Override
    public Shape postProcessBeforeDraw(Shape shape) {
        System.out.println("CircleColorPostProcessor postProcessBeforeDraw, set color = " + this.shapeColorBeforeDraw);
        shape.setColor(this.shapeColorBeforeDraw);
        return shape;
    }

    @Override
    public Shape postProcessAfterDraw(Shape shape) {
        System.out.println("CircleColorPostProcessor postProcessAfterDraw, set color = " + this.shapeColorAfterDraw);
        shape.setColor(this.shapeColorAfterDraw);
        return shape;
    }

    @Override
    public Integer getOrder() {
        return 1;
    }
}
